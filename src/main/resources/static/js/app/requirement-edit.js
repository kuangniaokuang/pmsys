var app = new Vue({
    el: "#app",
    data: {
        plist: {
            title: "需求添加",
            active: 4
        },
        master: {
            "hukous": [],
            "companysites": [],
            "politicals": []
        }
    },
    mounted: function () {
        var _this = this;
        // 取消保存
        _this.initButton();
        // 公司选择
        _this.initMasterData();
        _this.initRequirement();
    },
    methods: {
        initRequirement: function () {
            var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                $.get("./requirement/r", { id: r[2] }, function (result) {
                    $("input[name='addtype'][value=" + result.addtype + "]").attr("checked", true);
                    $("#formDate").val(result.formdate);
                    if (result.department != undefined && result.department.id != "" && result.department.id != undefined) {
                        var data = $("#organization").treeview("getUnselected");
                        var node = $.Enumerable.From($("#organization").treeview("getUnselected")).Where("$.value==" + result.department.id).First();
                        $('#organization').treeview('selectNode', node);
                    }
                    $("#companySite").val(result.companysite.id);
                    $("#suggestSalary").val(result.suggestsalary);
                    $("#positionName").val(result.positionname);
                    $("input[name='addReason'][value=" + result.addreason + "]").attr("checked", true);
                    $("#arrivalDate").val(result.arrivaldate);
                    $("#addCount").val(result.addcount);
                    $("input[name='sex'][value=" + result.sex + "]").attr("checked", true);
                    $("#education").val(result.education);
                    $("#appearance").val(result.appearance);
                    $("input[name='marryStatus'][value=" + result.marrystatus + "]").attr("checked", true);
                    $("#major").val(result.major);
                    $("#others").val(result.others);
                    $("#age").val(result.age);
                    $("#trait").val(result.trait);
                    $("#experience").val(result.experience);
                    $("#duty").val(result.duty);
                    $("#proposer").val(result.proposer);
                    $("#manager").val(result.manager);
                    $("#director").val(result.director);
                    $("#chairman").val(result.chairman);
                    $("#hr").val(result.hr);
                });
            }
        },
        initButton: function () {
            $(".reqedit .cancel").click(function () {
                self.location = './reqmanager';
            });
            $(".reqedit .save").click(function () {
                var url = "./requirement/save";
                var departmentid = null;
                if ($("#organization").treeview("getSelected")[0] != undefined) {
                    departmentid = $("#organization").treeview("getSelected")[0].value;
                }
                var id = 0,
                    addtype = $("input[name='addtype']:checked").val(),
                    formdate = $("#formDate").val(),
                    companysiteid = $("#companySite option:selected").val(),
                    suggestsalary = $("#suggestSalary").val(),
                    positionname = $("#positionName").val(),
                    addreason = $("input[name='addReason']:checked").val(),
                    arrivaldate = $("#arrivalDate").val(),
                    addcount = $("#addCount").val(),
                    sex = $("input[name='sex']:checked").val(),
                    education = $("#education").val(),
                    appearance = $("#appearance").val(),
                    marrystatus = $("input[name='marryStatus']:checked").val(),
                    major = $("#major").val(),
                    others = $("#others").val(),
                    age = $("#age").val(),
                    trait = $("#trait").val(),
                    experience = $("#experience").val(),
                    duty = $("#duty").val(),
                    proposer = $("#proposer").val(),
                    manager = $("#manager").val(),
                    director = $("#director").val(),
                    chairman = $("#chairman").val(),
                    hr = $("#hr").val();

                var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) {
                    id = +r[2];
                }
                if (positionname == "") {
                    $("#positionName").addClass("inputwarn");
                    return;
                } else {
                    $("#positionName").removeClass("inputwarn");
                }
                var para = {
                    id: id,
                    addtype: addtype,
                    formdateStr: formdate,
                    departmentid: departmentid,
                    companysiteid: companysiteid,
                    suggestsalary: suggestsalary,
                    positionname: positionname,
                    addreason: addreason,
                    arrivaldateStr: arrivaldate,
                    addcount: addcount,
                    sex: sex,
                    education: education,
                    appearance: appearance,
                    marrystatus: marrystatus,
                    major: major,
                    others: others,
                    age: age,
                    trait: trait,
                    experience: experience,
                    duty: duty,
                    proposer: proposer,
                    manager: manager,
                    director: director,
                    chairman: chairman,
                    hr: hr
                }
                console.log(para);
                $.post(url, para, function (result) {
                    console.log(result);
                    self.location = './reqmanager';
                });
            });
        },
        initMasterData: function () {
            var _this = this;
            $.get("./master/all", {}, function (result) {
                _this.master["hukous"] = result["hukous"];
                _this.master["companysites"] = result["companysites"];
                _this.master["politicals"] = result["politicals"];
            });
        }
    }
})