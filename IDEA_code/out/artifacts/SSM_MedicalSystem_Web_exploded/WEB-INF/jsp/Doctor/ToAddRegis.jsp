<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增挂号信息</title>
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
                    <small>新增挂号信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="${pageContext.request.contextPath}/Doctor/AddRegis" method="post">
                <input type="hidden" name="Did" value=${Docid} />
                <div class="form-group">
                    <label for="BeginDay">开始日期</label>
                    <input type="date" name="day" class="form-control" id="BeginDay" required>
                </div>
                <div class="form-group">
                    <label for="beginTime">开始时间</label>
                    <input type="time" name="beginTime" class="form-control" id="beginTime" required>
                </div>
                <div class="form-group">
                    <label for="endTime">结束时间</label>
                    <input type="time" name="endTime" class="form-control" id="endTime" required>
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>

    </div>
</div>

</body>
</html>
