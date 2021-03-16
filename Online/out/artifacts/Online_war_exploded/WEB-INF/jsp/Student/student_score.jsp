<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/12/14
  Time: 7:42 下午
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
            <li><a href="${pageContext.request.contextPath}/toPaperList.action">在线考试</a> </li>
            <li class="active"><a href="${pageContext.request.contextPath}/toStudentScoreList.action">成绩查询</a> </li>
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
                <li>
                    <a href="${pageContext.request.contextPath}/toPaperList.action">
                        <i class="glyphicon glyphicon-user"></i>
                        在线考试
                    </a>
                </li>
                <li class="active">
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
<%--右边内容--%>
        <div class="col-md-10">
            <div class="right-title" style="margin-top: 10px">
                <p>当前位置：成绩查询</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" method="get" action="${pageContext.request.contextPath}/toStudentScoreList.action">
                        <div class="form-group">
                            <label>试卷：</label>
                            <select class="form-control" name="paper_id">
                                <option value="">---请选择---</option>
                                <c:forEach items="${papers}" var="paper">
                                    <option value="${paper.id}">${paper.qty_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">查询</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">成绩列表(单位：分)</div>
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>试卷号</th>
                                <th>试卷名</th>
                                <th>单选</th>
                                <th>多选</th>
                                <th>判断</th>
                                <th>填空</th>
                                <th>简答</th>
                                <th>总分</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.rows}" var="row">
                                <tr>
                                    <td>${row.paper_id}</td>
                                    <td>${row.paper.qty_name}</td>
                                    <td>${row.score_sing}</td>
                                    <td>${row.score_muti}</td>
                                    <td>${row.score_jud}</td>
                                    <td>${row.score_fill}</td>
                                    <td>${row.score_ess}</td>
                                    <td>${row.score}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-md-12 text-right">
                            <itheima:page url="${pageContext.request.contextPath}/toStudentScoreList.action"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
</html>
