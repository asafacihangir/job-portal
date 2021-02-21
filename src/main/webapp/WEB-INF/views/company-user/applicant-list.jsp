<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>Başvuranlar Listesi</title>

    <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/jquery/css/jquery-ui.css">


    <script src="${contextPath}/resources/jquery/js/jquery-1.12.4.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-ui.js"></script>
    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>


<jsp:include page="../company-user/navbar.jsp"/>

<div class="container table-responsive">
    <div class="row">
        <table class="table table-bordered">
            <caption>
                <c:out value="${jobNotice.company.title}" />-<c:out value="${jobNotice.position}" />
            </caption>
            <thead>
            <tr>
                <th>Adı</th>
                <th>Soyadı</th>
                <th>Tel</th>
                <th>Mail</th>
                <th>Eğitim Durumu</th>
                <th>Tecrübe</th>
                <th class="text-center">Profili Görüntüle</th>
            </tr>
            </thead>
            <tbody>
            <!-- loop over and print our books -->
            <c:forEach items="${applicants}" var="applicant">

                <!-- construct an "update" link with book id -->
                <c:url var="showProfileLink" value="${contextPath}/company/applicant/showProfile">
                    <c:param name="id" value="${applicant.id}" />
                </c:url>

                <!-- construct an "delete" link with book id -->
                <c:url var="deleteLink" value="${contextPath}/deleteBook">
                    <c:param name="companyId" value="${company.id}" />
                </c:url>

                <tr>
                    <td>
                        <c:out value="${applicant.user.firstname}" />
                    </td>
                    <td>
                        <c:out value="${applicant.user.lastname}" />
                    </td>
                    <td>
                        <c:out value="${applicant.tel}" />
                    </td>
                    <td>
                        <c:out value="${applicant.user.mail}" />
                    </td>
                    <td>
                        <c:out value="${applicant.educationStatus}" />
                    </td>
                    <td>
                        <c:out value="${applicant.experience}" />
                    </td>
                    <td class="text-center">
                        <a href="${showProfileLink}" class="btn btn-primary btn-lg">
                            <span class="glyphicon glyphicon-edit"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
