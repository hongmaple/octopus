<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/12/14
  Time: 9:06 下午
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
                <p>当前位置：考试管理>试卷管理</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" method="get" action="${pageContext.request.contextPath}/listPaper.action">
                        <div class="form-group">
                            <label>试卷ID：</label>
                            <input type="text" class="form-control" id="id" name="id">
                        </div>
                        <div class="form-group">
                            <label>试卷名称:</label>
                            <input type="text" class="form-control" id="qty_name" name="qty_name">
                        </div>
                        <div class="form-group">
                            <label>考试时长（单位：分钟）:</label>
                            <input type="text" class="form-control" id="qty_time" name="qty_time">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">查询</button>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#newPaperDialog" onclick="clearPaper()">新建</a>
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
                                        <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
                                           data-target="#editPaperDialog" onclick="editPaper(${row.id})">
                                            修改
                                        </a>
                                        <a href="#" class="btn btn-danger btn-xs" onclick="deletePaper(${row.id})">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-md-12 text-right">
                            <itheima:page url="${pageContext.request.contextPath}/listPaper.action"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<%--新建试卷信息的模态框--%>
<div class="modal fade" id="newPaperDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建试卷信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_paper_form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷ID：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="id" id="new_id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷名称：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_name" id="new_name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">考试时长：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_time" id="new_time" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">单选数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_sing" id="new_sing" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">多选数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_muti" id="new_muti" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">判断数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_jud" id="new_jud" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">填空数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_fill" id="new_fill" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">简答数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_ess" id="new_ess" placeholder="请填写数字">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="createPaper()">创建试卷</button>
            </div>
        </div>
    </div>
</div>
<%--修改试卷信息的模态框--%>
<div class="modal fade" id="editPaperDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">修改试卷信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_paper_form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷ID：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="id" id="edit_id" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷名称：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_name" id="edit_name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">考试时长：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_time" id="edit_time" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">单选数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_sing" id="edit_sing" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">多选数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_muti" id="edit_muti" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">判断数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_jud" id="edit_jud" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">填空数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_fill" id="edit_fill" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">简答数量：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_ess" id="edit_ess" placeholder="请填写数字">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updatePaper()">保存修改</button>
            </div>
        </div>
    </div>
</div>
<script>
    //清空新建试卷的数据
    function clearPaper() {
        $("new_id").val("");
        $("new_name").val("");
        $("new_time").val("");
        $("new_sing").val("");
        $("new_muti").val("");
        $("new_jud").val("");
        $("new_fill").val("");
        $("new_ess").val("");
    }
    //新建试卷
    function createPaper() {
        $.post("${pageContext.request.contextPath}/toCreateManagerPaper.action",
            $("#new_paper_form").serialize(),function (data) {
                if (data == "OK") {
                    alert("试卷新建成功！");
                    window.location.reload();
                } else if (data == "FALL1") {
                    alert("请完整填写新建信息！");
                    message(data);
                } else if (data == "FALL2") {
                    alert("新建失败，请检查填写的信息是否有错！");
                    message(data);
                } else if (data == "FALL3"){
                    alert("该试卷ID已经存在，请重新输入ID！");
                    message(data);
                }
            });
    }
    function message(data) {
        $("new_id").val("");
        $("new_name").val(data.qty_name);
        $("new_time").val(data.qty_time);
        $("new_sing").val(data.qty_sing);
        $("new_muti").val(data.qty_muti);
        $("new_jud").val(data.qty_jud);
        $("new_fill").val(data.qty_fill);
        $("new_ess").val(data.qty_ess);
    }
    //删除试卷信息
    function deletePaper(id) {
        if(confirm('确实要删除该客户吗?')) {
            $.post("${pageContext.request.contextPath}/toDeleteManagerPaper.action",{"id":id},
                function(data){
                    if(data =="OK"){
                        alert("试卷删除成功！");
                        window.location.reload();
                    }
                    else{
                        alert("试卷删除失败！");
                        window.location.reload();
                    }
                });
        }
    }
    //更新前显示试卷信息
    function editPaper(id) {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/toFindManagerPaper.action",
            data:{"id":id},
            success:function(data){
                $("#edit_id").val(data.id);
                $("#edit_name").val(data.qty_name);
                $("#edit_time").val(data.qty_time);
                $("#edit_sing").val(data.qty_sing);
                $("#edit_muti").val(data.qty_muti);
                $("#edit_jud").val(data.qty_jud);
                $("#edit_fill").val(data.qty_fill);
                $("#edit_ess").val(data.qty_ess);
            }
        })
    }
    function updatePaper() {
        $.post("${pageContext.request.contextPath}/toUpdateManagerPaper.action",
            $("#edit_paper_form").serialize(),function (data) {
                if (data == "OK"){
                    alert("修改成功！");
                    window.location.reload();
                }
                else{
                    alert("修改失败，请检查是否输入错误信息！");
                    window.location.reload();
                }
            }

        )
    }
</script>
</body>
</html>
