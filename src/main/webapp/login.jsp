<%--
  Created by IntelliJ IDEA.
  User: dastepps
  Date: 2018-12-10
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test='${param.user.equals("admin")}'>
    <c:if test='${param.pass.equals("password")}'>
        <c:redirect url="/profile.jsp"/>
    </c:if>
</c:if>

<html>
<jsp:include page="partials/bootstrap-head.jsp">
    <jsp:param name="title" value="Log In, Please" />
</jsp:include>
    <body class="blueish">
        <jsp:include page="partials/navbar-boot.jsp"/>

        <div class="main container rounded mt-5">
            <form action="login.jsp" method="post">

                <div class="input-group pt-3 my-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Username</span>
                    </div>
                    <input type="text" name="user" class="form-control" aria-label="Text input for username">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Password</span>
                    </div>
                    <input type="password" name="pass" class="form-control" aria-label="Text input for password">
                </div>
                <button class="btn btn-success mb-3" type="submit">Let's-a Go!</button>
            </form>
        </div>

        <jsp:include page="partials/footer-boot.jsp" />
        <jsp:include page="partials/boostrap-script.jsp" />
    </body>
</html>
