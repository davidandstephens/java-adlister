<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dastepps
  Date: 2018-12-11
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Ad Listings" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/partials/navbar.jsp" />
    <div class="container">
        <c:forEach items="${ads}" var="ad">
            <div>
                <h2>Title: ${ad.title}</h2>
                <h5>User: ${ad.userId}</h5>
                <p>Description: ${ad.description}</p>
                <br>
            </div>
        </c:forEach>
    </div>

</body>
</html>
