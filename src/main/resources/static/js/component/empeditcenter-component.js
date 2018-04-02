Vue.component("empeditcenter-component", {
    template: `
    <div class="content-center">
        <div class="empedit container">
            <hr>
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            基本信息
                        </div>
                        <div class="panel-body">
                            <div>个人基本信息</div>
                            <br>
                            <div class="row">
                                <div class="col-sm-3">
                                    <div id="uploader">
                                        <div class="queueList">
                                            <div id="dndArea" class="placeholder">
                                                <div id="filePicker"></div>
                                                <p>可直接拖动图片</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <form class="form-horizontal">

                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="staffName">
                                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>姓名</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="staffName" placeholder="姓名">
                                            </div>
                                        </div>

                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="idCardNo">身份证号</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="idCardNo" placeholder="身份证号">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="mobileNo">手机号码</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="mobileNo" placeholder="手机号码">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="birthday">出生日期</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="birthday" placeholder="yyyy/mm/dd">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="sex">性别</label>
                                            <div class="col-sm-9">
                                                <label class="radio-inline">
                                                    <input type="radio" name="sex" id="male" checked value="1"> 男
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="sex" id="female" value="2"> 女
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="nativePlace">籍贯</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="nativePlace" placeholder="籍贯">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="livingAddress">现居住地</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="livingAddress" placeholder="现居住地址">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-3">
                                    <form class="form-horizontal">
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="nationality">
                                                民族</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="nationality" placeholder="民族">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="hukouType">户口类型</label>
                                            <div class="col-sm-9">
                                                <select name="" id="hukouType" class="form-control">
                                                    <option value="1">本地城镇</option>
                                                    <option value="2">本地农村</option>
                                                    <option value="3">外埠城镇</option>
                                                    <option value="4">外埠农村</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="marryStatus">婚否</label>
                                            <div class="col-sm-9">
                                                <label class="radio-inline">
                                                    <input type="radio" name="marryStatus" id="" checked value="0"> 未婚
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="marryStatus" id="" value="1"> 已婚
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="politicalStatus">政治面貌</label>
                                            <div class="col-sm-9">
                                                <select name="" id="politicalStatus" class="form-control">
                                                    <option value="1">党员</option>
                                                    <option value="2">团员</option>
                                                    <option value="3">群众</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="highestEducation">学历</label>
                                            <div class="col-sm-9">
                                                <select name="" id="highestEducation" class="form-control">
                                                    <option value="1">本科</option>
                                                    <option value="2">研究生</option>
                                                    <option value="3">专科</option>
                                                    <option value="4">博士生</option>
                                                    <option value="5">其他</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="school">
                                                毕业院校</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="school" placeholder="毕业院校">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="major">专业</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="major" placeholder="专业">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div>公司基本信息</div>
                            <br>
                            <div class="row">
                                <div class="col-sm-3">
                                    <form class="form-horizontal">
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="staffNO">
                                                工号</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="staffNo" placeholder="工号">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="workingState">状态</label>
                                            <div class="col-sm-9">
                                                <select name="" id="workingState" class="form-control">
                                                    <option value="0">离职</option>
                                                    <option selected value="1">在职</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="corporation">公司</label>
                                            <div class="col-sm-9">
                                                <select name="" id="corporation" class="form-control">
                                                    <option value="1">上海兰信医疗科技集团</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="companySite">工作地点</label>
                                            <div class="col-sm-9">
                                                <select name="" id="companySite" class="form-control">
                                                    <option value="1">上海</option>
                                                    <option value="2">青岛</option>
                                                    <option value="3">烟台</option>
                                                    <option value="4">日照</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="positionName">职位</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="positionName" placeholder="职位">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="profile">接收档案</label>
                                            <div class="col-sm-9">
                                                <label class="radio-inline">
                                                    <input type="radio" name="profile" id="" checked value="0"> 否
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="profile" id="" value="1"> 是
                                                </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-3">
                                    <form class="form-horizontal">
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="joinedDate">入职时间</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="joinedDate" placeholder="yyyy/mm/dd">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="contractDate">签合同时间</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="contractDate" placeholder="yyyy/mm/dd">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="positiveDate">转正时间</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="positiveDate" placeholder="yyyy/mm/dd">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="nowWorkingYears">司龄</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="nowWorkingYears" placeholder="司龄">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="contractType">合同形式</label>
                                            <div class="col-sm-9">
                                                <select name="" id="contractType" class="form-control">
                                                    <option value="1">固定期限</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="contractPeriod">合同期（年）</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="contractPeriod" placeholder="劳动合同期">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-3">
                                    <form action="" class="form-horizontal">
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="bank">开户行</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="bank" placeholder="开户行">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="subBank">支行</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="subBank" placeholder="支行">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="cardNo">银行卡号</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="cardNo" placeholder="银行卡号">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="verifier">档案审核人</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="verifier" placeholder="档案审核人">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label" for="staffRemark">备注</label>
                                            <div class="col-sm-9">
                                                <textarea class="form-control" rows="3" id="staffRemark" placeholder="备注"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm text-right">
                                            <div class="btn btn-default">取消</div>
                                            <div class="btn btn-success">保存</div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    `
})