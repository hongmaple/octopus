<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/11/29
  Time: 3:47 下午
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
<%-- 右侧主要内容--%>
        <div class="col-md-10">
            <div class="right-title" style="margin-top: 10px">
                <p>当前位置：在线考试</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">试卷信息列表</div>
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>试卷名</th>
                                <th>考试时长(分钟)</th>
                                <th>单选题数量</th>
                                <th>多选题数量</th>
                                <th>判断题数量</th>
                                <th>填空题数量</th>
                                <th>简答题数量</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.rows}" var="row">
                                <tr>
                                    <td>${row.id}</td>
                                    <td>${row.qty_name}</td>
                                    <td>${row.qty_time}</td>
                                    <td>${row.qty_sing}</td>
                                    <td>${row.qty_muti}</td>
                                    <td>${row.qty_jud}</td>
                                    <td>${row.qty_fill}</td>
                                    <td>${row.qty_ess}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${FLAG == 0}">
                                                <a href="#" class="btn btn-primary btn-xs" onclick="editExam(${row.id},${USER_SESSION.sno})">
                                                    进入考试
                                                </a>
                                            </c:when>
<%--                                            <c:when test="${FLAG == 1}">--%>
<%--                                                <a href="#" class="btn btn-danger btn-xs" data-toggle="modal"--%>
<%--                                                   data-target="#editPaperDialog" onclick="editPaper(${row.id},${USER_SESSION.sno})">--%>
<%--                                                    已完成考试--%>
<%--                                                </a>--%>
<%--                                            </c:when>--%>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-md-12 text-right">
                            <itheima:page url="${pageContext.request.contextPath}/toPaperList.action"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<script>
    function editExam(id,sno) {
        <%--$.ajax({--%>
        <%--    type:"get",--%>
        <%--    url:"${pageContext.request.contextPath}/toStudentExam.action",--%>
        <%--    data:{"id":id}--%>
        <%--})--%>
        window.location.href="http://localhost:8080/Online/toStudentExam.action?id=" + id + "&user_sno=" + sno;
    }
</script>
</body>
</html>
