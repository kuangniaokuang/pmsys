var app = new Vue({
    el: "#app",
    data: {
        plist: {
            ptitle: "人员花名册",
            active: 1
        },
        employeeData: null
    },
    mounted: function () {
        var _this = this;
        _this.initMasterData();
        _this.initEmployee();
        _this.bindExport();
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
        initEmployee: function () {
            var _this = this;
            var $table = $('#employee');
            $table.bootstrapTable('destroy').bootstrapTable({
                toolbar: "#toolbar",
                search: true,
                showColumns: true,
                // fixedColumns: true,
                // fixedNumber: 1,
                columns: [
                    { field: 'staffno', title: '工号' },
                    { field: 'staffname', title: '姓名' },
                    { field: 'positionname', title: '职位名' },
                    { field: 'birthday', title: '生日' },
                    { field: 'mobileno', title: '联系方式' },
                    { field: 'idcardno', title: '身份证号' },
                    { field: 'insideno', title: '内线座机' },
                    { field: 'outsideno', title: '外线座机' },
                    {
                        field: 'id',
                        title: '操作',
                        align: 'center',
                        formatter: function (value) {
                            return "<a href='./empedit?id=" + value + "'>编辑</a>";
                        }
                    }
                ]
            });

            $.get("./staff/getstafflist", {}, function (result) {
                _this.employeeData = result;
                $table.bootstrapTable("load", result);
            });
        },
        initMasterData: function () {
            var _this = this;
            var $tree = $("#organization"), $table = $('#employee');
            $.get("./master/departments", {}, function (result) {
                $tree.treeview({
                    showCheckbox: true,
                    levels: 99,//展开的层次
                    onNodeChecked: function (event, node) { //选中节点
                        var selectNodes = _this.getChildNodeIdArr(node); //获取所有子节点
                        if (selectNodes) { //子节点不为空，则选中所有子节点
                            $tree.treeview('checkNode', [selectNodes, { silent: true }]);
                        }
                        var parentNode = $tree.treeview("getNode", node.parentId);
                        _this.setParentNodeCheck($tree, node);
                        var departs = $.Enumerable.From($tree.treeview("getChecked")).Select("$.value").ToArray();
                        var data = $.Enumerable.From(_this.employeeData).Join(departs, "Number($.departmentid)", "", "o,i=>o").ToArray();
                        $table.bootstrapTable("load", data);
                    },
                    onNodeUnchecked: function (event, node) { //取消选中节点
                        var selectNodes = _this.getChildNodeIdArr(node); //获取所有子节点
                        if (selectNodes) { //子节点不为空，则取消选中所有子节点
                            $tree.treeview('uncheckNode', [selectNodes, { silent: true }]);
                        }
                        // 取消父节点
                        if (node.parentId != undefined) {
                            var parentNode = $tree.treeview("getNode", node.parentId);
                            $tree.treeview('uncheckNode', [parentNode, { silent: true }]);
                        }
                        var departs = $.Enumerable.From($tree.treeview("getChecked")).Select("$.value").ToArray();
                        if (departs.length == 0) {
                            $table.bootstrapTable("load", _this.employeeData);
                        } else {
                            var data = $.Enumerable.From(_this.employeeData).Join(departs, "Number($.departmentid)", "", "o,i=>o").ToArray()
                            $table.bootstrapTable("load", data);
                        }

                    },
                    data: result
                });
            });
        },
        bindExport: function () {
            $(".empoperation .export").click(function () {
                window.location.href = "./staff/downstaff";
            });
        }
    }
})