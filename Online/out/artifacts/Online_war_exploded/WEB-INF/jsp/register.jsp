<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎使用睿智考试网</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/register_style.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/jquery-3.5.1/jquery-3.5.1.min.js"></script>
	<script src=".${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="col-md-12 headfontsize">
				<h1 class="headh1content">
					睿智考试网站
				</h1>
				<h2 class="headh2content">
					在这里，你将能够巩固你的知识<br>
					拓展你的视野，成绩将更上一层楼
				</h2>
			</div>
		</div>
		<div class="col-md-4 col-md-offset-2" id="myAlert">
			<div class="col-md-12">
				<div class="alert alert-info" role="alert">
					<strong>温馨提示：</strong>${msg3 }
				</div>
			</div>
		</div>
		<div class="col-md-4 col-md-offset-2" id="register">
			<div class="col-md-10 col-md-offset-1">
				<center><h3>用户注册</h3></center>
				<form role="form" method="post" id="reg" action="${pageContext.request.contextPath}/register.action">
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/user.png" id="user">
						<label>账号：</label>
						<input type="text" class="form-control" id="sno" name="sno" placeholder="请输入12位工号或者学号">
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/user_add.png" id="i2">
						<label>姓名：</label>
						<input type="text" class="form-control" id="name" name="name" placeholder="请输入汉字" value="">
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/key.png" id="key">
						<label>密码：</label>
						<input type="password" class="form-control" id="password" name="password">
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/update.png">
						<label>确认密码：</label>
						<input type="password" class="form-control" id="tpass" name="tpass">
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/user_edit.png">
						<label>手机号码：</label>
						<input type="password" class="form-control" id="phone" name="phone">
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/sort.png" id="i6">
						<label>性别：</label>
						<input type="radio" name="sex" value="男" checked>男
						<input type="radio" name="sex" value="女">女
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/title.png" id="i5">
						<label>身份：</label>
						<input type="radio" name="identity" value="教师">教师
						<input type="radio" name="identity" value="学生" checked>学生
					</div>
					<div class="form-group">
						<img src="${pageContext.request.contextPath}/images/home.png">
						<label for="coll">学院:</label>
						<select class="form-control" name="college" id="coll">
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
					<div class="buttons">
						<a href="${pageContext.request.contextPath }/register.action"><input type="submit" class="btn btn-primary" role="button" id="sub" value="确定" ></a>
						<a href="${pageContext.request.contextPath }/toLogin.action"><input type="button" class="btn btn-primary" role="button" id="return" value="返回" ></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>