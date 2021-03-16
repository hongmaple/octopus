<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/12/14
  Time: 8:24 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>睿智在线考试网教师端</title>
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
            <a href="#" class="navbar-brand" id="title">睿智在线考试网教师端</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/toTeacher.action">首页</a> </li>
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
            <li><a href="${pageContext.request.contextPath}/toManagerScoreList.action">成绩管理</a> </li>
            <li><a href="#">模拟考试</a> </li>
        </ul>
        <div class="navbar-right" id="myUserList">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="myUser">
                    <span>您好，</span>
                    <span id="uu"> ${USER_SESSION.name}</span>
                    <span>老师</span>
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
                <li class="active">
                    <a href="${pageContext.request.contextPath}/toTeacher.action" >
                        <i class="glyphicon glyphicon-th-large"></i>
                        首页
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
                    <a href="${pageContext.request.contextPath}/toManagerScoreList.action">
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
                <p>当前位置：修改密码</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="row">
                <form id="change_password_form" class="form-horizontal" method="post">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-md-9">
                                        <p style="font-size: 14pt">修改密码</p>
                                    </div>
                                    <div class="col-md-2 col-md-offset-1">
                                        <button type="button" class="btn btn-primary" onclick="updatePassword()">保存</button>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 col-md-offset-1 control-label">账号：</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="sno" id="sno" readonly="readonly" value="${USER_SESSION.sno}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 col-md-offset-1 control-label">新密码：</label>
                                    <div class="col-md-6">
                                        <input type="password" class="form-control" name="password" id="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 col-md-offset-1 control-label">确认密码：</label>
                                    <div class="col-md-6">
                                        <input type="password" class="form-control" name="tpass" id="tpass">
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
    function updatePassword() {
        $.post("${pageContext.request.contextPath}/toUpdatePassword.action",$("#change_password_form").serialize(),function(data){
            if(data == "OK"){
                alert("密码修改成功！");
                window.location.reload();
            }
            else if (data == "FALL1"){
                alert("请完整输入信息！");
                window.location.reload();
            }
            else if (data == "FALL2"){
                alert("两次输入的密码不一致！");
                window.location.reload();
            }
            else if (data == "FALL3"){
                alert("修改失败！");
                window.location.reload();
            }
        });
    }
</script>
</body>
</html>
