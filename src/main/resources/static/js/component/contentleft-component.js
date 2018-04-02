Vue.component("contentleft-component", {
    template: `
    <div class="content-left">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3>{{plist.title}}</h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <a v-for="(item,index) in listlink" :href="item.url" class="list-group-item" :class="{ active: index==plist.active }">
                        {{item.txt}}
                    </a>
                </div>
            </div>
        </div>
    </div>
    `,
    props: {
        plist: ""
    },
    data: function () {
        return {
            listlink: [
                { url: "./organization", txt: "组织架构" },
                { url: "./empmanager", txt: "人员花名册" },
                { url: "./empedit", txt: "人员添加" },
                { url: "./reqmanager", txt: "人力需求管理" },
                { url: "./reqedit", txt: "需求添加" },
                { url: "./recmanager", txt: "面试管理" },
                { url: "./recedit", txt: "面试管理" },
                { url: "./salary", txt: "工资计算" },
                { url: "./salarydepartment", txt: "部门工资计算" },
            ]
        }
    }
})