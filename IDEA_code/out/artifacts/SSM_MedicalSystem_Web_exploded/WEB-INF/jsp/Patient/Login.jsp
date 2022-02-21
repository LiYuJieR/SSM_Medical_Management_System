<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/11
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者登录</title>
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
                    <small>患者登录</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="${pageContext.request.contextPath}/Patient/LoginValid" method="post">
                <div class="form-group">
                    <label for="account">账号</label>
                    <input type="text" name="account" class="form-control" id="account" placeholder="电话" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword">密码</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword" placeholder="密码" required>
                </div>
                <div class="form-group">
                    <label for="verifyCode">验证码</label>
                    <input type="text" name="verifyCode" class="form-control" id="verifyCode" placeholder="验证码" required>
                    <img src="${pageContext.request.contextPath}/Verify/Code">
                </div>



                <button type="submit" class="btn btn-default">提交</button>
                <a href="${pageContext.request.contextPath}/Patient/ToRegister" class="btn btn-default">注册</a>
            </form>

        </div>



    </div>
</div>

</body>
</html>

