<%--
  Created by IntelliJ IDEA.
  User: 宇
  Date: 2022/2/12
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加失败</title>
</head>

<body>
<script type="text/javascript">
    alert("挂号失败");
    window.document.location.href="${pageContext.request.contextPath}/Patient/MainFrame/${Pid}";
</script>

</body>
</html>

