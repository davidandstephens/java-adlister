<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="User logged out!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>User was logged out. Goodbye!</h1>
</div>
<script>
    setTimeout("document.location.href='/login'",5000);
</script>
</body>
</html>
