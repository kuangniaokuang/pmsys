Vue.component("header-component",{
    template:`
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="javascript:;">
                    <img alt="Brand" src="imgs/logo.png">
                </a>
                <div class="navbar-title">上海兰信医疗人事管理</div>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="javascript:;">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            <span class="h3">首页</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>
                            <span class="h3">系统简介</span>
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <span class="h3">Cora Welcome!</span>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="javascript:;">Action</a>
                            </li>
                            <li>
                                <a href="javascript:;">Another action</a>
                            </li>
                            <li>
                                <a href="javascript:;">Something else here</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="javascript:;">退出</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    `

});