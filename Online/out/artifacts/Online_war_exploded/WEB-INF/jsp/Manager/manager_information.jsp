<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/7/28
  Time: 10:55 上午
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/7/22
  Time: 3:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            <li><a href="${pageContext.request.contextPath}/list.action">用户管理</a> </li>
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
                <li>
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
    <%--右侧主要内容--%>
    <div class="col-md-10">
        <div class="right-title" style="margin-top: 10px">
            <p>当前位置：资料编辑</p>
        </div>
        <div>
            <hr>
        </div>
        <div class="row">
            <form id="change_information_form" class="form-horizontal" method="post">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-md-8">
                                    <p style="font-size: 14pt">资料编辑</p>
                                </div>
                                <div class="col-md-3 col-md-offset-1">
                                    <button type="button" class="btn btn-default" onclick="editUser(${USER_SESSION.sno})">显示</button>
                                    <button type="button" class="btn btn-primary" onclick="updateUser()">保存</button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-md-3 col-md-offset-1 control-label">账号：</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" name="sno" id="edit_sno" readonly="readonly" value="${USER_SESSION.sno}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 col-md-offset-1 control-label">姓名：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="name" id="edit_name" placeholder="姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 col-md-offset-1 control-label">号码：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="phone" id="edit_phone" placeholder="手机号码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit_sex" class="col-md-3 col-md-offset-1 control-label">性别：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" name="sex" id="edit_sex">
                                        <option value="">——————请选择——————</option>
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit_identity" class="col-md-3 col-md-offset-1 control-label">身份：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" name="identity" id="edit_identity">
                                        <option value="">——————请选择——————</option>
                                        <option value="学生">学生</option>
                                        <option value="教师">教师</option>
                                        <option value="管理员">管理员</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit_college" class="col-md-3 col-md-offset-1 control-label">学院：</label>
                                <div class="col-sm-6">
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

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
<%--获取用户的个人信息--%>
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
//修改用户个人信息
function updateUser() {
    $.post("${pageContext.request.contextPath}/updateManagerUser.action",$("#change_information_form").serialize(),function(data){
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

