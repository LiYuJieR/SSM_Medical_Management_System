<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/15
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改个人信息</title>
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
                    <small>更改个人信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="${pageContext.request.contextPath}/Patient/ChangePhoneAndPassword/${patientId}" method="post">
                <div class="form-group">
                    <label for="password">原密码</label>
                    <input type="password" name="password" class="form-control" id="password" required>
                </div>
                <div class="form-group">
                    <label for="newPassword">新密码</label>
                    <input type="password" name="newPassword" class="form-control" id="newPassword" required>
                </div>
                <div class="form-group">
                    <label for="newPhone">电话号码</label>
                    <input type="text" name="newPhone" class="form-control" id="newPhone" required value="${patient.phone}">
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>

    </div>
</div>

</body>
</html>

