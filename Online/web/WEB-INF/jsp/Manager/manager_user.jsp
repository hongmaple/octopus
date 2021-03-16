<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/" %>
<html>
<head>
    <title>睿智在线考试网管理员端</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/manager_main.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/jquery-3.5.1/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<%--    顶部导航栏--%>
<div class="navbar-inverse navbar-static-top" role="navigation" id="top-menu">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand" id="title">睿智在线考试网管理员端</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/toManagerMain.action">首页</a> </li>
            <li class="active"><a href="${pageContext.request.contextPath}/list.action">用户管理</a> </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    考试管理
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/listPaper.action">试卷管理</a> </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/listQuestion.action">题库管理</a> </li>
                </ul>
            </li>
            <li><a href="#">成绩管理</a> </li>
            <li><a href="#">模拟考试</a> </li>
        </ul>
        <div class="navbar-right" id="myUserList">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="myUser">
                    <span>您好，</span>
                    <span id="uu"> ${USER_SESSION.name}</span>
                    <span>管理员</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/toManagerInformation.action">资料编辑</a> </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/toManagerChange.action">修改密码</a> </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/logout.action">退出登录</a> </li>
                </ul>
            </li>
        </div>
    </div>
</div>

<div class="row">
    <%--左边导航栏    --%>
    <div class="col-md-2" >
        <div id="left-menu">
            <div class="p">
                <div>
                    <img src="${pageContext.request.contextPath}/images/protrait.png" class="img-circle" id="protrait">
                </div>
                <div class="pratrait-title">
                    <h4>${USER_SESSION.name}</h4>
                </div>

            </div>

            <ul id="main-nav" class="nav nav-tabs nav-stacked">
                <li>
                    <a href="${pageContext.request.contextPath}/toManagerMain.action" >
                        <i class="glyphicon glyphicon-th-large"></i>
                        首页
                    </a>
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/list.action">
                        <i class="glyphicon glyphicon-user"></i>
                        用户管理
                    </a>
                </li>
                <li>
                    <a href="#papermanager" class="nav-header collapsed" data-toggle="collapse">
                        <i class="glyphicon glyphicon-eye-open"></i>
                        考试管理
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul id="papermanager" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <li><a href="${pageContext.request.contextPath}/listPaper.action"><i class="glyphicon glyphicon-credit-card">试卷管理</i> </a> </li>
                        <li><a href="${pageContext.request.contextPath}/listQuestion.action"><i class="glyphicon glyphicon-globe">题库管理</i> </a> </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-calendar"></i>
                        成绩管理
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-adjust"></i>
                        模拟考试
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toManagerAbout.action">
                        <i class="glyphicon glyphicon-fire"></i>
                        关于系统
                    </a>
                </li>
            </ul>
        </div>
    </div>
<%-- 右边主要内容   --%>
        <div class="col-md-10">
            <div class="right-title" style="margin-top: 10px">
                <p>当前位置：系统管理>用户管理</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" method="get" action="${pageContext.request.contextPath}/list.action">
                        <div class="form-group">
                            <label>账号：</label>
                            <input type="text" class="form-control" id="sno" name="sno">
                        </div>
                        <div class="form-group">
                            <label>姓名：</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        <div class="form-group">
                            <label for="iden">身份：</label>
                            <select class="form-control" name="identity" id="iden">
                                <option value="">——————请选择——————</option>
                                <option value="学生">学生</option>
                                <option value="教师">教师</option>
                                <option value="管理员">管理员</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="coll">学院：</label>
                            <select class="form-control" name="college" id="coll">
                                <option value="">——————请选择——————</option>
                                <option value="教务处">教务处</option>
                                <option value="外语学院">外语学院</option>
                                <option value="海运学院">海运学院</option>
                                <option value="海运学院">轮机工程学院</option>
                                <option value="艺术设计学院">艺术设计学院</option>
                                <option value="海运学院">航务工程学院</option>
                                <option value="航运经贸学院">航运经贸学院</option>
                                <option value="船舶与海洋工程学院">船舶与海洋工程学院</option>
                                <option value="港口与航运管理学院">港口与航运管理学院</option>
                                <option value="信息与通信工程学院">信息与通信工程学院</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">查询</button>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#newUserDialog" onclick="clearUser()">新建</a>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">用户信息列表</div>
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>账号</th>
                                    <th>姓名</th>
                                    <th>密码</th>
                                    <th>电话</th>
                                    <th>身份</th>
                                    <th>性别</th>
                                    <th>学院</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${page.rows}" var="row">
                                    <tr>
                                        <td>${row.sno}</td>
                                        <td>${row.name}</td>
                                        <td>${row.password}</td>
                                        <td>${row.phone}</td>
                                        <td>${row.identity}</td>
                                        <td>${row.sex}</td>
                                        <td>${row.college}</td>
                                        <td>
                                            <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
                                               data-target="#editUserDialog" onclick="editUser(${row.sno})">
                                                修改
                                            </a>
                                            <a href="#" class="btn btn-danger btn-xs" onclick="deleteUser(${row.sno})">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-md-12 text-right">
                            <itheima:page url="${pageContext.request.contextPath}/list.action"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<%--添加用户的模态框--%>
<div class="modal fade" id="newUserDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_user_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">账号：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sno" id="new_sno" placeholder="工号或者学号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" id="new_name" placeholder="姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="password" id="new_password" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">号码：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="phone" id="new_phone" placeholder="手机号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_sex" class="col-sm-2 control-label">性别：</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="sex" id="new_sex">
                                <option value="">——————请选择——————</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_identity" class="col-sm-2 control-label">身份：</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="identity" id="new_identity">
                                <option value="">——————请选择——————</option>
                                <option value="学生">学生</option>
                                <option value="教师">教师</option>
                                <option value="管理员">管理员</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_college" class="col-sm-2 control-label">学院：</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="college" id="new_college">
                                <option value="">——————请选择——————</option>
                                <option value="教务处">教务处</option>
                                <option value="外语学院">外语学院</option>
                                <option value="海运学院">海运学院</option>
                                <option value="海运学院">轮机工程学院</option>
                                <option value="艺术设计学院">艺术设计学院</option>
                                <option value="海运学院">航务工程学院</option>
                                <option value="航运经贸学院">航运经贸学院</option>
                                <option value="船舶与海洋工程学院">船舶与海洋工程学院</option>
                                <option value="港口与航运管理学院">港口与航运管理学院</option>
                                <option value="信息与通信工程学院">信息与通信工程学院</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="createUser()">创建用户</button>
            </div>
        </div>
    </div>
</div>
<%--修改信息的模态框--%>
<div class="modal fade" id="editUserDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_user_form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">账号：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sno" id="edit_sno" placeholder="工号或者学号" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" id="edit_name" placeholder="姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="password" id="edit_password" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">号码：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="phone" id="edit_phone" placeholder="手机号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_sex" class="col-sm-2 control-label">性别：</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="sex" id="edit_sex">
                                <option value="">——————请选择——————</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_identity" class="col-sm-2 control-label">身份：</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="identity" id="edit_identity">
                                <option value="">——————请选择——————</option>
                                <option value="学生">学生</option>
                                <option value="教师">教师</option>
                                <option value="管理员">管理员</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_college" class="col-sm-2 control-label">学院：</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="college" id="edit_college">
                                <option value="">——————请选择——————</option>
                                <option value="教务处">教务处</option>
                                <option value="外语学院">外语学院</option>
                                <option value="海运学院">海运学院</option>
                                <option value="海运学院">轮机工程学院</option>
                                <option value="艺术设计学院">艺术设计学院</option>
                                <option value="海运学院">航务工程学院</option>
                                <option value="航运经贸学院">航运经贸学院</option>
                                <option value="船舶与海洋工程学院">船舶与海洋工程学院</option>
                                <option value="港口与航运管理学院">港口与航运管理学院</option>
                                <option value="信息与通信工程学院">信息与通信工程学院</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateUser()">保存修改</button>
            </div>
        </div>
    </div>
</div>
<script>
// 删除用户
    function deleteUser(sno) {
        if(confirm('确实要删除该客户吗?')) {
            $.post("${pageContext.request.contextPath}/deleteUser.action",{"sno":sno},
                function(data){
                    if(data =="OK"){
                        alert("客户删除成功！");
                        window.location.reload();
                    }
                    else{
                        alert("删除客户失败！");
                        window.location.reload();
                    }
                });
        }
    }
    //清空新建用户的数据
    function clearUser() {
        $("new_sno").val("");
        $("new_name").val("");
        $("new_password").val("");
        $("new_phone").val("");
        $("new_sex").val("");
        $("new_identity").val("");
        $("new_college").val("");

    }
    //新建用户
    function createUser() {
        $.post("${pageContext.request.contextPath}/createManagerUser.action",
            $("#new_user_form").serialize(),function (data) {
                if(data == "OK"){
                    alert("用户创建成功！");
                    window.location.reload();
                }
                else if(data == "FALL1"){
                    alert("请完整输入新建用户的信息！");
                    message(data);
                }
                else if(data == "FALL2"){
                    alert("账号必须为数字类型的工号或者学号！");
                    message(data);
                }
                else if(data == "FALL3"){
                    alert("该用户已经存在！");
                    message(data);
                }
                else if(data == "FALL"){
                    alert("用户创建失败！");
                    window.location.reload();
                }
            }
        )
    }
    //通过sno获取修改的用户信息
    function editUser(sno) {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/findManagerUserBySno.action",
            data:{"sno":sno},
            success:function (data) {
                $("#edit_sno").val(data.sno);
                $("#edit_name").val(data.name);
                $("#edit_phone").val(data.phone);
                $("#edit_password").val(data.password);
                $("#edit_identity").val(data.identity);
                $("#edit_sex").val(data.sex);
                $("#edit_college").val(data.college);
            }
        })
    }
    function message(data) {
        $("#new_sno").val(data.sno);
        $("#new_name").val(data.name);
        $("#new_phone").val(data.phone);
        $("#new_password").val(data.password);
        $("#new_identity").val(data.identity);
        $("#new_sex").val(data.sex);
        $("#new_college").val(data.college);
    }
    //执行修改用户信息
    function updateUser() {
        $.post("${pageContext.request.contextPath}/updateManagerUser.action",$("#edit_user_form").serialize(),function(data){
            if(data == "OK"){
                alert("用户信息更新成功！");
                window.location.reload();
            }else{
                alert("用户信息更新失败！");
                window.location.reload();
            }
        });
    }
</script>
</body>
</html>