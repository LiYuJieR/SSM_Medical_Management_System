<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/11
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者注册</title>
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
    </style>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>患者注册</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="${pageContext.request.contextPath}/Patient/Register" method="post">
                <div class="form-group">
                    <label for="Name">姓名</label>
                    <input type="text" name="name" class="form-control" id="Name" placeholder="name" required>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="password" required>
                </div>
                <div class="form-group">
                    <label for="gender">性别</label>
                    <select class="form-control" name="Patientgender" id="gender">
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="text" name="age" class="form-control" id="age" placeholder="age" required>
                </div>
                <div class="form-group">
                    <label for="phone">电话</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="phone" required>
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>

    </div>
</div>

</body>
</html>

