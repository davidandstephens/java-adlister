<%--
  Created by IntelliJ IDEA.
  User: dastepps
  Date: 2018-12-10
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <jsp:include page="partials/bootstrap-head.jsp">
        <jsp:param name="title" value="Profile" />
    </jsp:include>
    <body class="blueish">
        <jsp:include page="partials/navbar-boot.jsp"/>
        <div class="row">
            <div class="col-10"></div>

            <div class="col-2">
                <img src="img/yellow-monster-but-upside-down.png" alt="a yellow monster boy" class="bigger-monster mt-5 ml-2 animated slideInDown delay-3s">
            </div>
        </div>

        <div class="main container rounded mt-5">
            <p>Welcome Mr. President...</p>
        </div>

        <img src="img/yellow-monster-but-rotated.png" alt="a yellow monster boy" class="biggerer-monster mt-5 ml-2 animated rotateInUpRight delay-4s">
        <img src="img/yellow-monster.png" alt="a yellow monster boy" class="biggest-monster mt-5 ml-2 animated zoomIn delay-5s">

        <img src="img/yellow-monster.png" alt="a yellow monster boy" class="monster mb-4 fixed-bottom ml-2 animated flipInX delay-2s">
        <jsp:include page="partials/footer-boot.jsp" />
        <jsp:include page="partials/boostrap-script.jsp" />
    </body>
</html>
