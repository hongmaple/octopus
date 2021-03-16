<%--
  Created by IntelliJ IDEA.
  User: maweihong
  Date: 2020/8/2
  Time: 10:38 上午
  To change this template use File | Settings | File Templates.
--%>
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
            <li class="active"><a href="#">成绩管理</a> </li>
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
                <li class="active">
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
<%--右边主要内容--%>
        <div class="col-md-10">
            <div class="right-title" style="margin-top: 10px">
                <p>当前位置：系统管理>成绩管理</p>
            </div>
            <div>
                <hr>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" method="get" action="${pageContext.request.contextPath}/toManagerScoreList.action">
                        <div class="form-group">
                            <label>学号：</label>
                            <input type="text" class="form-control" id="user_sno" name="user_sno">
                        </div>
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
            <div>
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#newScoreDialog" onclick="clearScore()">新建</a>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">成绩列表(单位：分)</div>
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>学院</th>
                                <th>试卷号</th>
                                <th>试卷名</th>
                                <th>单选</th>
                                <th>多选</th>
                                <th>判断</th>
                                <th>填空</th>
                                <th>简答</th>
                                <th>总分</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.rows}" var="row">
                                <tr>
                                    <td>${row.score_id}</td>
                                    <td>${row.user_sno}</td>
                                    <td>${row.user.name}</td>
                                    <td>${row.user.college}</td>
                                    <td>${row.paper_id}</td>
                                    <td>${row.paper.qty_name}</td>
                                    <td>${row.score_sing}</td>
                                    <td>${row.score_muti}</td>
                                    <td>${row.score_jud}</td>
                                    <td>${row.score_fill}</td>
                                    <td>${row.score_ess}</td>
                                    <td>${row.score}</td>
                                    <td>
                                        <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
                                           data-target="#editScoreDialog" onclick="editScore(${row.score_id})">
                                            修改
                                        </a>
                                        <a href="#" class="btn btn-danger btn-xs" onclick="deleteScore(${row.score_id})">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="col-md-12 text-right">
                            <itheima:page url="${pageContext.request.contextPath}/toManagerScoreList.action"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<%--修改成绩的模态框--%>
<div class="modal fade" id="editScoreDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">修改学生成绩信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_score_form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">成绩ID：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_id" id="edit_id" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生学号：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="user_sno" id="edit_sno" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生姓名：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="name" id="edit_name" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生学院：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="college" id="edit_college" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷ID：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="paper_id" id="edit_paper_id" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷名称：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="qty_name" id="edit_qty_name" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">单选成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_sing" id="edit_sing" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">多选成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_muti" id="edit_muti" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">判断成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_jud" id="edit_jud" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">填空成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_fill" id="edit_fill" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">简答成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_ess" id="edit_ess" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">总分：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score" id="edit_score" readonly="readonly">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateScore()">保存修改</button>
            </div>
        </div>
    </div>
</div>
<%--新建成绩信息的模态框--%>
<div class="modal fade" id="newScoreDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新建成绩信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_score_form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生学号：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="user_sno" id="new_sno">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">试卷ID：</label>
                        <div class="col-sm-9">
                            <select class="form-control" name="paper_id">
                                <option value="">---请选择---</option>
                               <c:forEach items="${papers}" var="paper">
                                   <option value="${paper.id}">${paper.qty_name}</option>
                               </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">单选成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_sing" id="new_sing" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">多选成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_muti" id="new_muti" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">判断成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_jud" id="new_jud" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">填空成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_fill" id="new_fill" placeholder="请填写数字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">简答成绩：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="score_ess" id="new_ess" placeholder="请填写数字">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="createScore()">创建试卷</button>
            </div>
        </div>
    </div>
</div>
<script>
<%--    删除成绩--%>
    function deleteScore(score_id) {
        if (confirm("确定要删除该学生的成绩吗?")){
            $.post("${pageContext.request.contextPath}/toDeleteManagerScore.action",{"score_id":score_id},
            function (data) {
                if (data == "OK"){
                    alert("成绩删除成功！");
                    window.location.reload();
                }else{
                    alert("成绩删除失败！");
                    window.location.reload();
                }
            });
        }
    }
 // 更新前显示成绩信息
  function editScore(score_id) {
      $.ajax({
          type:"get",
          url:"${pageContext.request.contextPath}/toFindScoreById.action",
          data:{"score_id":score_id},
          success:function(data){
              $("#edit_id").val(data.score_id);
              $("#edit_sno").val(data.user_sno);
              $("#edit_name").val(data.user.name);
              $("#edit_college").val(data.user.college);
              $("#edit_paper_id").val(data.paper_id);
              $("#edit_qty_name").val(data.paper.qty_name);
              $("#edit_sing").val(data.score_sing);
              $("#edit_muti").val(data.score_muti);
              $("#edit_jud").val(data.score_jud);
              $("#edit_fill").val(data.score_fill);
              $("#edit_ess").val(data.score_ess);
              $("#edit_score").val(data.score);
          }
      })
  }
//  更新成绩
function updateScore() {
    $.post("${pageContext.request.contextPath}/toUpdateManagerScore.action",
        $("#edit_score_form").serialize(),function (data) {
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
//清空新建成绩的数据
function clearScore() {
    $("new_sno").val("");
    $("new_sing").val("");
    $("new_muti").val("");
    $("new_jud").val("");
    $("new_fill").val("");
    $("new_ess").val("");
}
//新建成绩
function createScore() {
    $.post("${pageContext.request.contextPath}/toCreateManagerScore.action",
        $("#new_score_form").serialize(),function (data) {
            if (data == "OK") {
                alert("成绩新建成功！");
                window.location.reload();
            } else if (data == "FALL1") {
                alert("请完整填写新建信息！");
                message(data);

            } else if (data == "FALL2") {
                alert("该学生不存在，请检查学生学号是否正确！");
                message(data);
            } else if (data == "FALL3"){
                alert("新建失败，请检查填写的信息是否有错！");
                message(data);
            } else if (data == "FALL4"){
                alert("该学生已参加过考试，成绩已存在！");
                message(data);
            }
        });
}
function message(data) {
    $("new_sno").val("");
    $("new_sing").val(data.score_sing);
    $("new_muti").val(data.score_muti);
    $("new_jud").val(data.score_jud);
    $("new_fill").val(data.score_jud);
    $("new_ess").val(data.score_ess);
}
</script>
</body>
</html>
