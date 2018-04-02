var app = new Vue({
    el: "#app",
    data: {
        plist: {
            title: "人力需求管理",
            active: 3
        }
    },
    mounted: function () {
        var _this = this;
        _this.initRequirement();
        _this.bindExport();
    },
    methods: {
        initRequirement: function () {
            var _this = this;
            var $table = $('#requirement');
            $table.bootstrapTable('destroy').bootstrapTable({
                toolbar: "#toolbar",
                search: true,
                showColumns: true,
                columns: [
                    {
                        field: 'addtype', title: '需求类型',
                        formatter: function (value) {
                            // 1 增员；2 补员
                            var addtype = "增员";
                            if (value == 2) {
                                addtype = "补员";
                            }
                            return addtype;
                        }
                    },
                    { field: 'formdate', title: '填表日期' },
                    { field: 'departmentname', title: '申请部门' },
                    { field: 'companysitename', title: '工作地点' },
                    { field: 'suggestsalary', title: '建议薪资' },
                    { field: 'positionname', title: '增补职位' },
                    {
                        field: 'addreason', title: '申请增补理由',
                        formatter: function (value) {
                            // 1 扩大编制；2 补员
                            var addreason = "扩大编制";
                            if (value == 2) {
                                addreason = "辞职补充";
                            }
                            return addreason;
                        }
                    },
                    { field: 'arrivaldate', title: '期望到岗日期' },
                    { field: 'addcount', title: '增补额（人）' },
                    {
                        field: 'sex', title: '性别',
                        formatter: function (value) {
                            // 0 不限；1 男；2 女
                            var sex = "不限";
                            if (value == 1) {
                                sex = "男";
                            } else if (value == 2) {
                                sex = "女";
                            }
                            return sex;
                        }
                    },
                    { field: 'education', title: '学历' },
                    { field: 'appearance', title: '身高/外貌' },
                    {
                        field: 'marrystatus', title: '婚姻',
                        formatter: function (value) {
                            // 0 不限；1 未婚；2 已婚
                            var sex = "不限";
                            if (value == 1) {
                                sex = "未婚";
                            } else if (value == 2) {
                                sex = "已婚";
                            }
                            return sex;
                        }
                    },
                    { field: 'major', title: '专业' },
                    { field: 'others', title: '其他' },
                    { field: 'age', title: '年龄' },
                    { field: 'trait', title: '性格' },
                    { field: 'experience', title: '具备技能及工作经验' },
                    { field: 'duty', title: '岗位职责' },
                    { field: 'proposer', title: '申请人' },
                    { field: 'manager', title: '总经理' },
                    { field: 'director', title: '分管负责人' },
                    { field: 'chairman', title: '董事长' },
                    { field: 'hr', title: '人力资源部门' },
                    {
                        field: 'id',
                        title: '操作',
                        align: 'center',
                        formatter: function (value) {
                            return "<a href='./reqedit?id=" + value + "'>编辑</a>";
                        }
                    }
                ]
            });

            $.get("./requirement/getlist", {}, function (result) {
                $table.bootstrapTable("load", result);
            });
        },
        bindExport: function () {
            $(".reqoperation .export").click(function () {
                // window.location.href = "/staff/downstaff";
            });
        }
    }
})