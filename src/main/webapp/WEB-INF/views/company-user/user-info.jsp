<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>Yeni Kullanıcı</title>

    <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/jquery/css/jquery-ui.css">


    <script src="${contextPath}/resources/jquery/js/jquery-1.12.4.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-ui.js"></script>
    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="../company-user/navbar.jsp"/>
<div class="row">
    <div class="col-lg-5 col-lg-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Kullanıcı Detayları</strong>
            </div>

            <div class="panel-body">
                <form:form class="form-horizontal" action="${pageContext.request.contextPath}/updateUser" modelAttribute="currentUser">
                    <!-- need to associate this data with book id -->
                    <form:hidden path="id" />
                    <form:hidden path="username"/>
                    <form:hidden path="userType"/>
                    <form:hidden path="activated"/>


                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Kullanıcı Adı</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" disabled="true" class="form-control" id="username" path="username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Parola </label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="password" path="password"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Adı</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="firstname" path="firstname"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Soyadı</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="lastname" path="lastname"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Mail</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="mail" path="mail"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Kullanıcı Tipi</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:select path="userType" class="form-control" required="true" disabled="true">
                                <form:options items = "${userTypes}" />
                            </form:select>


                        </div>
                    </div>
                    <br/>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-md-offset-3 col-lg-offset-3 col-sm-8 col-md-9 col-lg-9">
                            <button type="submit" class="btn btn-primary">Kaydet</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
