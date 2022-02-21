<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/11
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加失败</title>
</head>

<body>
<script type="text/javascript">
  alert("您已注册过，请直接登录");
  window.document.location.href="${pageContext.request.contextPath}/Patient/Login";
</script>

</body>
</html>
