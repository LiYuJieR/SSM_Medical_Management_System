
<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加医生</title>
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
                    <small>添加医生信息到数据库</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="${pageContext.request.contextPath}/Admin/AddDoctor" method="post">
                <div class="form-group">
                    <label for="DocName">医生姓名</label>
                    <input type="text" name="username" class="form-control" id="DocName" placeholder="name" required>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="password" required>
                </div>
                <div class="form-group">
                    <label for="phone">电话</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="phone">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="email">
                </div>
                <div class="form-group">
                    <label for="departmentid">部门</label>
                    <select class="form-control" name="departmentid" id="departmentid">
                        <c:forEach var="department" items="${departmentList}">
                        <option value="${department.iddepartment}">${department.namedepartment}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="gradeid">级别</label>
                    <select class="form-control" name="gradeid" id="gradeid">
                        <c:forEach var="grade" items="${gradeList}">
                            <option value="${grade.idDoctorGrade}">${grade.gradeName}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group">
                    <label for="exampleInputdetails">描述</label>
                    <input type="text" name="detail" class="form-control" id="exampleInputdetails" placeholder="detail" required>
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>

    </div>
</div>

</body>
</html>

