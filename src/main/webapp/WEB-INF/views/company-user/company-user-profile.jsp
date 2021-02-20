
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>Admin Profil</title>


    <%--Css Libraries--%>
    <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/jquery/css/jquery-ui.css">
    <link  rel="stylesheet" href="${contextPath}/resources/validator/bootstrapValidator.css">


    <%--Js Libraries--%>
    <script src="${contextPath}/resources/jquery/js/jquery-1.12.4.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-ui.js"></script>
    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

    <%--Validator Libraries--%>
    <script src="${contextPath}/resources/validator/bootstrapValidator.js"></script>
    <script src="${contextPath}/resources/validator/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/jquery.validate.min.js"></script>


</head>
<body>
<jsp:include page="../company-user/navbar.jsp"/>
</body>
</html>
