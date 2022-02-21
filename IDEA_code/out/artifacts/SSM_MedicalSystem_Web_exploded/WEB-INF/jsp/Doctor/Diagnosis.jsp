<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/13
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>病人接诊单</title>
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
                    <small>${patient.name}病人接诊表</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <tr>
                    <td class="column">病人姓名</td>
                    <td>${patient.name}</td>
                </tr>
                <tr>
                    <td class="column">性别</td>
                    <c:choose>
                        <c:when test="${patient.gender==male}">
                            <td>男</td>
                        </c:when>
                        <c:otherwise>
                            <td>女</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
                <tr>
                    <td class="column">年龄</td>
                    <td>${patient.age}</td>
                </tr>
                <tr>
                    <td class="column">联系方式</td>
                    <td>${patient.phone}</td>
                </tr>
            </table>
            <form action="${pageContext.request.contextPath}/Doctor/AddOrderAndDetail/${DocId}/${PatientId}" method="post">
                <div class="form-group">
                    <label for="病情详述">病情详述</label>
                    <input type="textarea" name="patientDetail" class="form-control" id="病情详述" required value="${patient.detail}">
                </div>

                <div class="form-group">
                    <label>添加检查项目</label>
                    <c:forEach var="examination" items="${medicalExaminations}">
                        <input type="checkbox" name="exams" value="${examination.id}"/>${examination.name}
                    </c:forEach>
                </div>


                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>