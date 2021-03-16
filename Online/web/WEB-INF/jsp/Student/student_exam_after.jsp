<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/12/20
  Time: 2:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/" %>
<html>
<head>
    <title>睿智在线考试网学生端</title>
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
            <a href="#" class="navbar-brand" id="title">睿智在线考试学生端</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/toStudentFirst.action">首页</a> </li>
            <li><a href="${pageContext.request.contextPath}/toManagerInformation.action">个人信息管理</a> </li>
            <li class="active"><a href="${pageContext.request.contextPath}/toPaperList.action">在线考试</a> </li>
            <li><a href="#">成绩查询</a> </li>
            <li><a href="${pageContext.request.contextPath}/toManagerAbout.action">关于系统</a> </li>
        </ul>
        <div class="navbar-right" id="myUserList">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="myUser">
                    <span>您好，</span>
                    <span id="uu"> ${USER_SESSION.name}</span>
                    <span>同学</span>
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
                    <a href="${pageContext.request.contextPath}/toStudentFirst.action" >
                        <i class="glyphicon glyphicon-th-large"></i>
                        首页
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toManagerInformation.action">
                        <i class="glyphicon glyphicon-credit-card"></i>
                        个人信息管理
                    </a>
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/toPaperList.action">
                        <i class="glyphicon glyphicon-user"></i>
                        在线考试
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-calendar"></i>
                        成绩查询
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toManagerAbout.action">
                        <i class="glyphicon glyphicon-adjust"></i>
                        关于系统
                    </a>
                </li>
            </ul>
        </div>
    </div>
        <div class="col-md-10">
            <div class="right-title" style="margin-top: 10px">
                <p>当前位置：在线考试>成绩单</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">成绩单</h2>
                        </div>
                        <div class="panel-body">
                            <p>单选成绩：${score.score_sing}</p>
                            <p>多选成绩：${score.score_muti}</p>
                            <p>判断成绩：${score.score_jud}</p>
                            <p>填空成绩：${score.score_fill}</p>
                            <p>简答成绩：${score.score_ess}</p>
                            <p>总成绩：${score.score}</p>
                        </div>
                        <div class="panel-footer">
                            <p>祝愿您的成绩更上一层楼！</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
</html>
