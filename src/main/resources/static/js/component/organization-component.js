Vue.component("organizationComponent", {
    template: `
    <div id="corporation" class="dropdown">
        <div class="dropdown-toggle form-control" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            请选择部门
            <span class="caret pull-right"></span>
        </div>
        <div id="organization" class="dropdown-menu"></div>
    </div>
    `,
    props:{
    },
    mounted: function () {
        this.initOrganization();
    },
    methods: {
        initOrganization: function () {
            var _this = this;
            var $tree = $("#organization");
            $.get("./master/departments", {}, function (result) {
                // 改为可以选中
                var departments = $.parseJSON(JSON.stringify(result).replace(/false/g, "true"));
                $tree.treeview({
                    levels: 99,//展开的层次
                    expandIcon: "",
                    collapseIcon: "",
                    onNodeSelected: function () {
                        var selected = $("#organization").treeview("getSelected")[0];
                        if (selected != undefined) {
                            $("#corporation .dropdown-toggle").text(selected.text);
                            _this.$emit("orgselect", selected.value);
                        }
                    },
                    onNodeUnselected: function () {
                        $("#corporation .dropdown-toggle").text("请选择部门");
                    },
                    data: departments
                });
            });
        }
    }
})