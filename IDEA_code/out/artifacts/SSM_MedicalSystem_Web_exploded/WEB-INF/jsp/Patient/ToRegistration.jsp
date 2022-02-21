<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/11
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>自助挂号</title>
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
                    <small>可挂号</small>
                </h1>
                <form action="${pageContext.request.contextPath}/Patient/RegistrationTrans/${patientId}" method="post">
                    <div class="form-group">
                        <label for="departmentid">部门</label>
                        <select class="form-control" name="departmentid" id="departmentid">
                                <option value="0">全部</option>
                            <c:forEach var="department" items="${departments}">
                                <option value="${department.iddepartment}">${department.namedepartment}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>科室</th>
                    <th>医生姓名</th>
                    <th>级别</th>
                    <th>日期</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="registration" items="${registrations}" varStatus="vs">
                    <tr>
                        <td>${doctorusers.get(vs.index).departmentid}</td>
                        <td>${doctorusers.get(vs.index).username}</td>
                        <td>${doctorusers.get(vs.index).gradeid}</td>
                        <td>${registration.day}</td>
                        <td>${registration.beginTime}</td>
                        <td>${registration.endTime}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Patient/Regist/${registration.id}/${patientId}">挂号</a>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Patient/Exit">退出登录</a>
        </div>

    </div>
</div>

</body>
</html>