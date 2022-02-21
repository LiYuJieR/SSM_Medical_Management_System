<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/8
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员主界面</title>
    <!--Bootstrap-->
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        h1{
            width: 250px;
            height: 48px;
            margin: 100px auto;
            text-align: center;
            line-height: 48px;

        }
        h3{
            width: 180px;
            height: 38px;
            margin: 100px auto;
            float: left;
            text-align: center;
            line-height: 38px;
            background: darkblue;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>所有医生</small>
                </h1>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/Admin/ToAddDoctor">医生注册</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}">退出登录</a>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>医生编号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>部门</th>
                    <th>级别</th>
                    <th>介绍</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="doc" items="${doctorlist}" varStatus="vs">
                    <tr>
                        <td>${doc.iddoctoruser}</td>
                        <td>${doc.username}</td>
                        <td>${doc.phone}</td>
                        <td>${doc.email}</td>
                        <td>${departmentlist.get(vs.index)}</td>
                        <td>${gradelist.get(vs.index)}</td>
                        <td>${doc.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Admin/ToUpdateDoctor/${doc.iddoctoruser}">修改</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Admin/DeleteDoctor/${doc.iddoctoruser}">删除</a>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
</div>

</body>
</html>

