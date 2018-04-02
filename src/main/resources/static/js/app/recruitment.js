var app = new Vue({
    el: "#app",
    data: {
        plist: {
            title: "面试管理",
            active: 5
        },
        requirementData: [],
        positionnames: [],
        departmentid: 0,
        positionname: "",
        recruitmentData: []
    },
    mounted: function () {
        var _this = this;
        _this.initButton();
        _this.initRequirement();
        _this.initRecruitment();
    },
    watch: {
        positionname: function (val) {
            var _this = this;
            var para1 = {
                departmentid: _this.departmentid,
                positionname: val
            };
            // 通过部门，职位获取需求id
            $.get("./requirement/search", para1, function (result) {
                // 通过获取的需求id来检索需求
                var para2 = {
                    requirementids: $.Enumerable.From(result).Select("$.id").ToArray().join(",")
                };
                var $table = $('#recruitment');
                $.get("./recruitment/all", para2, function (result) {
                    $table.bootstrapTable("load", result);
                });
            });
        }
    },
    methods: {
        initButton: function () {
            $("#toolbar .add").click(function () {
                $('#interviewee').modal('show');
            });
            $("#interviewee edit").click(function () {
                var url = "",
                    para = {
                        requirementid: 0,
                        interviewee: $('#intervieweename').val()
                    };
                $.post(url, para, function (result) {
                    $('#interviewee').modal('hide');
                    // $table.bootstrapTable("refresh", { url: "/department/all", pageNumber: 1 });
                });
            });
        },
        // 需求
        initRequirement: function () {
            var _this = this;
            $.get("./requirement/getlist", {}, function (result) {
                _this.requirementData = result;
            });
        },
        initRecruitment: function () {
            var _this = this;
            var $table = $('#recruitment');
            $table.bootstrapTable('destroy').bootstrapTable({
                toolbar: "#toolbar",
                search: true,
                showColumns: true,
                columns: [
                    {
                        field: 'interviewee', title: '面试对象'
                    }, {
                        field: 'step', title: '当前进度',
                        formatter: function (value) {
                            var array = [];
                            array[0] = '<span class="label label-default">一面</span>',
                                array[1] = '<span class="label label-default">二面</span>',
                                array[2] = '<span class="label label-default">三面</span>',
                                array[3] = '<span class="label label-default">终面</span>',
                                array[4] = '<span class="label label-default">offer</span>',
                                array[5] = '<span class="label label-default">onboard</span>';
                            switch (+value) {
                                case 0:
                                    break;
                                case 1:
                                    array[0] = '<span class="label label-danger">一面</span>';
                                    break;
                                case 2:
                                    array[1] = '<span class="label label-danger">二面</span>';
                                    break;
                                case 3:
                                    array[2] = '<span class="label label-danger">三面</span>';
                                    break;
                                case 4:
                                    array[3] = '<span class="label label-danger">终面</span>';
                                    break;
                                case 5:
                                    array[4] = '<span class="label label-danger">offer</span>';
                                    break;
                                case 6:
                                    array[5] = '<span class="label label-danger">onboard</span>';
                                    break;
                            }
                            return array.join("->");
                        }
                    }, {
                        field: 'id',
                        title: '操作',
                        align: 'center',
                        formatter: function (value) {
                            return "<a href='./recedit?id=" + value + "'>编辑</a>";
                        }
                    }
                ]
            });
        },
        cb_orgSelect: function (val) {
            var _this = this;
            _this.departmentid = val;
            _this.positionnames = $.Enumerable.From(_this.requirementData).Where("$.departmentid==" + val).ToArray();
        }
    }
})