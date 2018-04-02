var app = new Vue({
    el: "#app",
    data: {
        plist: {
            title: "面试管理",
            active: 6
        },
        interview: [
            { step: 1, text: "一面" },
            { step: 2, text: "二面" },
            { step: 3, text: "三面" },
            { step: 4, text: "终面" },
            { step: 5, text: "offer" },
            { step: 6, text: "on board" }
        ],
        requirementid: 0,
        recruitmentData: null
    },
    mounted: function () {
        var _this = this;
        // 取消保存
        _this.initButton();
        _this.initRecruitment();
    },
    methods: {
        initButton: function () {
            var _this = this;
            $(".cancel").click(function () {
                self.location = './recmanager';
            });
            $(".save").click(function () {
                var url = "./recruitment/save";
                var id = 0,
                    requirementid = _this.requirementid,
                    interviewee = "",
                    step = $(".interview li.active").attr("step"),
                    interviewdateStr = $("#interviewDate").val(),
                    interviewer = $("#interviewer").val(),
                    evaluation = $("#evaluation").val(),
                    remark = $("#remark").val();

                var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) {
                    id = +r[2];
                }
                var para = {
                    id: id,
                    requirementid: requirementid,
                    interviewee: interviewee,
                    step: step,
                    interviewdateStr: interviewdateStr,
                    interviewer: interviewer,
                    evaluation: evaluation,
                    remark: remark
                }
                console.log(para);
                $.post(url, para, function (result) {
                    _this.recruitmentData = $.extend(true, {}, result);
                    self.location = './recmanager';
                });
            });
            $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                // e.target // newly activated tab
                // e.relatedTarget // previous active tab
                var step = $(e.target).parent().attr("step");
                $("#interviewDate").val(_this.recruitmentData["interviewdate" + step]);
                $("#interviewer").val(_this.recruitmentData["interviewer" + step]);
                $("#evaluation").val(_this.recruitmentData["evaluation" + step]);
                $("#remark").val(_this.recruitmentData["remark" + step]);
            })
        },
        initRecruitment: function () {
            var _this = this;
            var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                $.get("./recruitment/r", { id: r[2] }, function (result) {
                    _this.recruitmentData = $.extend(true, {}, result);
                    _this.requirementid = result["requirementid"];
                    var step = +result.step;
                    $(".interviewee").text(result["interviewee"]);
                    if (step == 0) {
                        $(".interview li[step=1]").addClass("active");
                        $("#interview1").addClass("active");
                        return;
                    } else {
                        $(".interview li[step=" + step + "]").addClass("active");
                        $("#interview" + step).addClass("active");
                        for (var i = 1; i < step + 1; i++) {
                            var $interview = $("#interview" + i);
                            $interview.find(".interviewDate").text(result["interviewdate" + i]);
                            $interview.find(".interviewer").text(result["interviewer" + i]);
                            $interview.find(".evaluation").text(result["evaluation" + i]);
                            $interview.find(".remark").text(result["remark" + i]);
                        }
                        $("#interviewDate").val(result["interviewdate" + step]);
                        $("#interviewer").val(result["interviewer" + step]);
                        $("#evaluation").val(result["evaluation" + step]);
                        $("#remark").val(result["remark" + step]);
                    }
                });
            }
        }
    }
})