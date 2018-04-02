var app = new Vue({
    el: "#app",
    data: {
        plist: {
            ptitle: "工资计算用",
            active: 7
        },
        salaryPara: null,
        salaryData: null,
        $table: null,
        $tree: null
    },
    mounted: function () {
        var _this = this;
        _this.$table = $('#salary'), _this.$tree = $("#organization");
        _this.initMasterData();
        _this.initSalary();
        _this.initButton();
    },
    methods: {
        getChildNodeIdArr: function (node) {
            var _this = this;
            var ts = [];
            if (node.nodes) {
                for (x in node.nodes) {
                    ts.push(node.nodes[x].nodeId);
                    if (node.nodes[x].nodes) {
                        var getNodeDieDai = _this.getChildNodeIdArr(node.nodes[x]);
                        for (j in getNodeDieDai) {
                            ts.push(getNodeDieDai[j]);
                        }
                    }
                }
            } else {
                ts.push(node.nodeId);
            }
            return ts;
        },
        setParentNodeCheck: function (tree, node) {
            var _this = this;
            var parentNode = tree.treeview("getNode", node.parentId);
            if (parentNode.nodes) {
                var checkedCount = 0;
                for (x in parentNode.nodes) {
                    if (parentNode.nodes[x].state.checked) {
                        checkedCount++;
                    } else {
                        break;
                    }
                }
                if (checkedCount === parentNode.nodes.length) {
                    tree.treeview("checkNode", parentNode.nodeId);
                    _this.setParentNodeCheck(tree, parentNode);
                }
            }
        },
        initSalary: function () {
            var _this = this;
            _this.$table.bootstrapTable('destroy').bootstrapTable({
                toolbar: "#toolbar",
                search: true,
                showColumns: true,
                uniqueId: "staffno",
                showExport: true,
                columns: [
                    { field: 'staffno', title: '工号' },
                    { field: 'staffname', title: '姓名' },
                    { field: 'departmentname', title: '部门名' },
                    { field: 'basic', title: '基本工资' },
                    { field: 'performance', title: '绩效工资', class: "enabled performance" },
                    { field: 'seniority', title: '工龄工资', class: "enabled seniority" },
                    { field: 'subsidies', title: '其他补贴', class: "enabled subsidies" },
                    { field: 'meal', title: '餐补', class: "enabled meal" },
                    { field: 'others', title: '其他加项 ', class: "enabled others" },
                    { field: 'absencedays', title: '缺勤', class: "enabled absencedays" },
                    { field: 'deductions', title: '其他扣除', class: "enabled deductions" },
                    { field: 'paytotal', title: '应发合计' },
                    { field: 'oldage', title: '养老' },
                    { field: 'unemployment', title: '失业' },
                    { field: 'medical', title: '医疗' },
                    { field: 'housing', title: '公积金' },
                    { field: 'tax', title: '个人所得税' },
                    { field: 'deductiontotal', title: '扣除合计' },
                    { field: 'takehome', title: '实发工资' }
                ],
                onPostBody: function () {
                    _this.$table.editableTableWidget({ editor: $('<input type="Number">') });
                }
            });
        },
        initMasterData: function () {
            var _this = this;
            $.get("./master/departments", {}, function (result) {
                _this.$tree.treeview({
                    showCheckbox: true,
                    levels: 99,//展开的层次
                    onNodeChecked: function (event, node) { //选中节点
                        var selectNodes = _this.getChildNodeIdArr(node); //获取所有子节点
                        if (selectNodes) { //子节点不为空，则选中所有子节点
                            _this.$tree.treeview('checkNode', [selectNodes, { silent: true }]);
                        }
                        var parentNode = _this.$tree.treeview("getNode", node.parentId);
                        _this.setParentNodeCheck(_this.$tree, node);
                    },
                    onNodeUnchecked: function (event, node) { //取消选中节点
                        var selectNodes = _this.getChildNodeIdArr(node); //获取所有子节点
                        if (selectNodes) { //子节点不为空，则取消选中所有子节点
                            _this.$tree.treeview('uncheckNode', [selectNodes, { silent: true }]);
                        }
                        // 取消父节点
                        if (node.parentId != undefined) {
                            var parentNode = _this.$tree.treeview("getNode", node.parentId);
                            _this.$tree.treeview('uncheckNode', [parentNode, { silent: true }]);
                        }
                    },
                    data: result
                });
            });
        },
        getSalaryData: function (para) {
            var _this = this;
            $.ajax({
                url: "./salary/getstaffsalary",
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
                var departmentids = $.Enumerable.From(_this.$tree.treeview("getChecked")).Select("$.value").ToArray();
                var yearmonth = $("#yearmonth").val();
                if (departmentids.length <= 0) {
                    // 没有选中部门
                    return;
                }
                _this.salaryPara = {
                    departmentids: departmentids,
                    yearmonth: yearmonth
                };
                _this.getSalaryData(_this.salaryPara);
            });
            $("#toolbar .salarySave").click(function () {
                if (_this.salaryData == null || _this.salaryData.length <= 0) {
                    // 没有显示工资表
                    return;
                }
                var editArray = [];
                var items = ["performance", "seniority", "subsidies", "meal", "others", "absencedays", "deductions"];
                _this.$table.find("tbody tr").each(function () {
                    var $tr = $(this);
                    var uniqueid = $tr.attr("data-uniqueid");
                    var row = _this.$table.bootstrapTable("getRowByUniqueId", uniqueid);
                    if ($tr.find("td.edited").length > 0) {
                        for (var i = 0, length = items.length; i < length; i++) {
                            var item = items[i];
                            if ($tr.find("." + item).hasClass("edited")) {
                                row[item] = +$tr.find("." + item).text();
                            }
                        }
                        if (row["yearmonth"] == null) {
                            row["yearmonth"] = _this.salaryPara["yearmonth"];
                        }
                        editArray.push(row);
                        return true;
                    }
                    if (row["id"] == null) {
                        row["yearmonth"] = _this.salaryPara["yearmonth"];
                        editArray.push(row);
                    }
                });

                var para = {
                    salarymodels: JSON.stringify(editArray)
                };
                $.post("./salary/save", para, function (result) {
                    _this.getSalaryData(_this.salaryPara);
                });
            });
            $(".salaryoperation .export").click(function () {
                window.location.href = "./salary/downsalary";
            });
        }
    }
})