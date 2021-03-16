<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/12/14
  Time: 9:12 下午
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
            <li><a href="${pageContext.request.contextPath}/toTeacher.action">首页</a> </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    考试管理
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/listPaper.action">试卷管理</a> </li>
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
                <li>
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
                        <li class="active"><a href="${pageContext.request.contextPath}/listPaper.action"><i class="glyphicon glyphicon-credit-card">试卷管理</i> </a> </li>
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
        <%--右边主要内容--%>
        <div class="col-md-10">
            <div class="right-title" style="margin-top: 10px">
                <p>当前位置：考试管理>题库管理</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" method="get" action="${pageContext.request.contextPath}/listQuestion.action">
                        <div class="form-group">
                            <label>题号：</label>
                            <input type="text" class="form-control" id="number" name="number">
                        </div>
                        <div class="form-group">
                            <label>题目：</label>
                            <input type="text" class="form-control" name="title">
                        </div>
                        <div class="form-group">
                            <label>题目类型：</label>
                            <select class="form-control" name="type" id="type">
                                <option value="">——————请选择——————</option>
                                <option value="单选题">单选题</option>
                                <option value="多选题">多选题</option>
                                <option value="填空题">填空题</option>
                                <option value="简答题">简答题</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>分值：</label>
                            <input type="text" class="form-control" name="score">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">查询</button>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#newQuestionDialog" onclick="clearQuestion()">新建</a>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">题库列表</div>
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>题号</th>
                                <th>题目类型</th>
                                <th>题目内容</th>
                                <th>选项内容</th>
                                <th>分值</th>
                                <th>答案</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.rows}" var="row">
                                <tr>
                                    <td>${row.number}</td>
                                    <td>${row.type}</td>
                                    <td>${row.title}</td>
                                    <td>${row.sel}</td>
                                    <td>${row.score}</td>
                                    <td>${row.answer}</td>
                                    <td>
                                        <a href="#" class="btn btn-danger btn-xs" onclick="deleteQuestion(${row.number})">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-md-12 text-right">
                            <itheima:page url="${pageContext.request.contextPath}/listQuestion.action"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<%--新建题目信息的模态框--%>
<div class="modal fade" id="newQuestionDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建题目信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_question_form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">题目类型：</label>
                        <div class="col-sm-9">
                            <select class="form-control" name="type" id="new_type">
                                <option value="">——————请选择——————</option>
                                <option value="单选题">单选题</option>
                                <option value="多选题">多选题</option>
                                <option value="填空题">填空题</option>
                                <option value="判断题">判断题</option>
                                <option value="简答题">简答题</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">题目内容：</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" name="title" id="new_title"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">选项（选择题必填）：</label>
                        <br>
                        <div class="col-sm-9">
                            <label>选项A</label>
                            <input type="text" class="form-control" name="sel" id="new_select1">
                            <label>选项B</label>
                            <input type="text" class="form-control" name="sel" id="new_select2">
                            <label>选项C</label>
                            <input type="text" class="form-control" name="sel" id="new_select3">
                            <label>选项D</label>
                            <input type="text" class="form-control" name="sel" id="new_select4">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">分值：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score" id="new_score" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">答案/得分点：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="answer" id="new_answer">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="createQuestion()">创建试卷</button>
            </div>
        </div>
    </div>
</div>
<script>
    //删除试卷信息
    function deleteQuestion(number) {
        if(confirm('确实要删除该题目吗?')) {
            $.post("${pageContext.request.contextPath}/toDeleteManagerQuestion.action",{"number":number},
                function(data){
                    if(data =="OK"){
                        alert("删除成功！");
                        window.location.reload();
                    }
                    else{
                        alert("试卷删除失败！");
                        window.location.reload();
                    }
                });
        }
    }
    //清空新建题目的数据
    function clearQuestion() {
        $("new_type").val("");
        $("new_title").val("");
        $("new_select1").val("");
        $("new_select2").val("");
        $("new_select3").val("");
        $("new_select4").val("");
        $("new_score").val("");
        $("new_answer").val("");
    }
    //新建题目
    function createQuestion() {
        $.post("${pageContext.request.contextPath}/toCreateManagerQuestion.action",
            $("#new_question_form").serialize(),function (data) {
                if (data == "OK") {
                    alert("题目新建成功！");
                    window.location.reload();
                } else if (data == "FALL1") {
                    alert("请完整填写新建信息！");
                    window.location.reload();
                } else if (data == "FALL2") {
                    alert("新建失败，请检查填写的信息是否有错！");
                    window.location.reload();
                }
            });
    }
</script>
</body>
</html>
