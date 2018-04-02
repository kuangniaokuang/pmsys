var app = new Vue({
    el: "#app",
    data: {
        plist: {
            title: "人员添加",
            active: 2
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
        // 公司 户口 政治面貌 工作地点
        _this.initMasterData();
        _this.initStaff();
    },
    methods: {
        initStaff: function () {
            var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                $.get("./staff/s", { id: r[2] }, function (result) {
                    $("#staffNo").val(result.staffno);
                    $("#staffName").val(result.staffname);
                    if (result.imgurl != "" && result.imgurl != undefined) {
                        $("#portrait").attr("src", "./uploads/" + result.imgurl);
                        $("#portrait").attr("name", result.imgurl);
                    } else {
                        $("#portrait").attr("src", "./imgs/image.png");
                    }
                    $("#workingState").val(result.workingstate);
                    if (result.department != undefined && result.department.id != "" && result.department.id != undefined) {
                        var data = $("#organization").treeview("getUnselected");
                        var node = $.Enumerable.From($("#organization").treeview("getUnselected")).Where("$.value==" + result.department.id).First();
                        $('#organization').treeview('selectNode', node);
                    }
                    $("#companySite").val(result.companysite.id);
                    $("#positionName").val(result.positionname);
                    $("input[name='sex'][value=" + result.sex + "]").attr("checked", true);
                    $("#idCardNo").val(result.idcardno);
                    $("#birthday").val(result.birthday);
                    $("#nationality").val(result.nationality);
                    $("#hukouType").val(result.hukou.id);
                    $("input[name='marryStatus'][value=" + result.marrystatus + "]").attr("checked", true);
                    $("#politicalStatus").val(result.political.id);
                    $("#highestEducation").val(result.highesteducation);
                    $("#school").val(result.school);
                    $("#major").val(result.major);
                    $("#joinedDate").val(result.joineddate);
                    $("#contractDate").val(result.contractdate);
                    $("#positiveDate").val(result.positivedate);
                    $("#nowWorkingYears").val(result.nowworkingyears);
                    $("#mobileNo").val(result.mobileno);
                    $("#insideNo").val(result.insideno);
                    $("#outsideNo").val(result.outsideno);
                    $("#nativePlace").val(result.nativeplace);
                    $("#livingAddress").val(result.livingaddress);
                    $("#contractPeriod").val(result.contractperiod);
                    $("#contractType").val(result.contracttype);
                    $("input[name='profile'][value=" + result.profile + "]").attr("checked", true);
                    $("#cardNo").val(result.cardno);
                    $("#bank").val(result.bank);
                    $("#subBank").val(result.subbank);
                    $("#verifier").val(result.verifier);
                    $("#staffRemark").val(result.staffremark);
                });
            }
        },
        initButton: function () {
            $(".empedit .cancel").click(function () {
                self.location = './empmanager';
            });
            $(".empedit .save").click(function () {
                var url = "./staff/save";
                var imgurl = "";
                if ($(".filelist .title").length == 0) {
                    imgurl = $("#portrait").attr("name");
                } else {
                    imgurl = $(".filelist .title").text();
                }
                var departmentid = null;
                if ($("#organization").treeview("getSelected")[0] != undefined) {
                    departmentid = $("#organization").treeview("getSelected")[0].value;
                }
                var id = 0,
                    staffno = $("#staffNo").val(),
                    staffname = $("#staffName").val(),
                    workingstate = $("#workingState").val(),
                    companysiteid = $("#companySite option:selected").val(),
                    positionname = $("#positionName").val(),
                    sex = $("input[name='sex']:checked").val(),
                    idcardno = $("#idCardNo").val(),
                    birthday = $("#birthday").val(),
                    nationality = $("#nationality").val(),
                    hukouid = $("#hukouType option:selected").val(),
                    marrystatus = $("input[name='marryStatus']:checked").val(),
                    politicalid = $("#politicalStatus option:selected").val(),
                    highesteducation = $("#highestEducation option:selected").val(),
                    school = $("#school").val(),
                    major = $("#major").val(),
                    joineddate = $("#joinedDate").val(),
                    contractdate = $("#contractDate").val(),
                    positivedate = $("#positiveDate").val(),
                    nowworkingyears = $("#nowWorkingYears").val(),
                    mobileno = $("#mobileNo").val(),
                    insideno = $("#insideNo").val(),
                    outsideno = $("#outsideNo").val(),
                    nativeplace = $("#nativePlace").val(),
                    livingaddress = $("#livingAddress").val(),
                    contractperiod = $("#contractPeriod").val(),
                    contracttype = $("#contractType option:selected").val(),
                    profile = $("input[name='profile']:checked").val(),
                    cardno = $("#cardNo").val(),
                    bank = $("#bank").val(),
                    subbank = $("#subBank").val(),
                    verifier = $("#verifier").val(),
                    staffremark = $("#staffRemark").val(),
                    basic = $("#basic").val();

                var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) {
                    id = +r[2];
                }
                if (staffname == "") {
                    $("#staffName").addClass("inputwarn");
                    return;
                } else {
                    $("#staffName").removeClass("inputwarn");
                }
                var para = {
                    id: id,
                    staffno: staffno,
                    staffname: staffname,
                    imgurl: imgurl,
                    workingstate: workingstate,
                    departmentid: departmentid,
                    companysiteid: companysiteid,
                    positionname: positionname,
                    sex: sex,
                    idcardno: idcardno,
                    birthdayStr: birthday,
                    nationality: nationality,
                    hukouid: hukouid,
                    marrystatus: marrystatus,
                    politicalid: politicalid,
                    highesteducation: highesteducation,
                    school: school,
                    major: major,
                    joineddateStr: joineddate,
                    contractdateStr: contractdate,
                    positivedateStr: positivedate,
                    nowworkingyears: nowworkingyears,
                    mobileno: mobileno,
                    insideno: insideno,
                    outsideno: outsideno,
                    nativeplace: nativeplace,
                    livingaddress: livingaddress,
                    contractperiod: contractperiod,
                    contracttype: contracttype,
                    profile: profile,
                    cardno: cardno,
                    bank: bank,
                    subbank: subbank,
                    verifier: verifier,
                    staffremark: staffremark,
                    basic: basic
                }
                console.log(para);
                $.post(url, para, function (result) {
                    console.log(result);
                    // self.location = '/empmanager';
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