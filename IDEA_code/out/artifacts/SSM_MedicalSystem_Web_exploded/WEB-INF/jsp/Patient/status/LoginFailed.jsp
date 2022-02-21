<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/10
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>

<body>
    <script type="text/javascript">
        alert("用户名或密码错误");
        window.document.location.href="${pageContext.request.contextPath}/Patient/Login";
    </script>

</body>
</html>
