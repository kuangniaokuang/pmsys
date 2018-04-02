var app = new Vue({
    el: "#app",
    data: {
        plist: {
            ptitle: "部门工资",
            active: 8
        },
        salaryPara: null,
        salaryData: null,
        $table: null
    },
    mounted: function () {
        var _this = this;
        _this.$table = $('#salary');
        _this.initSalary();
        _this.initButton();
    },
    methods: {
        initSalary: function () {
            var _this = this;
            _this.$table.bootstrapTable('destroy').bootstrapTable({
                toolbar: "#toolbar",
                search: true,
                showColumns: true,
                uniqueId: "staffno",
                showExport: true,
                columns: [
                    { field: 'departmentname', title: '部门名' },
                    { field: 'basic', title: '基本工资' },
                    { field: 'performance', title: '绩效工资' },
                    { field: 'seniority', title: '工龄工资' },
                    { field: 'subsidies', title: '其他补贴' },
                    { field: 'meal', title: '餐补' },
                    { field: 'others', title: '其他加项 ' },
                    { field: 'absenceday', title: '缺勤' },
                    { field: 'deductions', title: '其他扣除' },
                    { field: 'paytotal', title: '应发合计' },
                    { field: 'oldage', title: '养老' },
                    { field: 'unemployment', title: '失业' },
                    { field: 'medical', title: '医疗' },
                    { field: 'housing', title: '公积金' },
                    { field: 'tax', title: '个人所得税' },
                    { field: 'deductiontotal', title: '扣除合计' },
                    { field: 'takehome', title: '实发工资' }
                ]
            });
        },
        getSalaryData: function (para) {
            var _this = this;
            $.ajax({
                url: "./salary/getsalarydepartmentlistbyyearmonth",
                data: para,
                traditional: true,
                success: function (result) {
                    _this.salaryData = result;
                    _this.$table.bootstrapTable("load", result);
                }
            });
        },
        initButton: function () {
            var _this = this;
            $("#toolbar .salaryShow").click(function () {
                var yearmonth = $("#yearmonth").val();
                _this.salaryPara = {
                    yearmonth: yearmonth
                };
                _this.getSalaryData(_this.salaryPara);
            });
            $(".salaryoperation .export").click(function () {
                window.location.href = "./salary/downsalary";
            });
        }
    }
})