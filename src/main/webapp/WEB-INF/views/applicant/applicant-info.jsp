<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>Şirket Tanımlama</title>

    <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/jquery/css/jquery-ui.css">


    <script src="${contextPath}/resources/jquery/js/jquery-1.12.4.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-ui.js"></script>
    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="../applicant/navbar.jsp"/>
<div class="row">
    <div class="col-lg-5 col-lg-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Bilgilerim</strong>
            </div>

            <div class="panel-body">
                <form:form class="form-horizontal" action="${pageContext.request.contextPath}/applicant/saveApplicant" modelAttribute="applicantInfo">
                    <!-- need to associate this data with book id -->
                    <form:hidden path="id" />
                    <form:hidden path="userId" />
                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Adı</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" disabled="true" class="form-control" path="user.firstname"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Soyadı</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" disabled="true" class="form-control"  path="user.lastname"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Mail</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" disabled="true" class="form-control" path="user.mail"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Telefon</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="tel" path="tel"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Eğitim Durumu</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="educationStatus" path="educationStatus"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Son Eğitim Görülen Kurum</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="theLastSchool" path="theLastSchool"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Tecrübe</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="experience" path="experience"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Sertifikalar</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="certificateInfo" path="certificateInfo"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 col-md-3 col-lg-3 control-label">Genel Bilgi</label>
                        <div class="col-sm-8 col-md-6 col-lg-5">
                            <form:input type="text" class="form-control" id="generalInfo" path="generalInfo"/>
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
