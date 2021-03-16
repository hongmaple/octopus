<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/8/4
  Time: 7:59 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li class="active"><a href="${pageContext.request.contextPath}/toStudentFirst.action">首页</a> </li>
            <li><a href="${pageContext.request.contextPath}/toManagerInformation.action">个人信息管理</a> </li>
            <li><a href="${pageContext.request.contextPath}/toPaperList.action">在线考试</a> </li>
            <li><a href="${pageContext.request.contextPath}/toStudentScoreList.action">成绩查询</a> </li>
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
                <li class="active">
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
                <li>
                    <a href="${pageContext.request.contextPath}/toPaperList.action">
                        <i class="glyphicon glyphicon-user"></i>
                        在线考试
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toStudentScoreList.action">
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
    <%--右边主要内容--%>
    <div class="col-md-10">
        <div class="right-title" style="margin-top: 10px">
            <p>当前位置：首页</p>
        </div>
        <div>
            <hr>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">温馨提示</h2>
                    </div>
                    <div class="panel-body">
                        <h3 class="h3">欢迎使用睿智在线考试系统</h3>
                        <h3 class="h3">请诚信考试！！！</h3>
                    </div>
                    <div class="panel-footer">
                        <p>抄袭可耻，诚信可贵</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
