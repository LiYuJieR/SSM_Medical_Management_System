<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加失败</title>
</head>

<body>
<script type="text/javascript">
    alert("您已注册过该医生（电话或者email重复），请直接登录");
    window.document.location.href="${pageContext.request.contextPath}/Admin/MainFrame";
</script>

</body>
</html>