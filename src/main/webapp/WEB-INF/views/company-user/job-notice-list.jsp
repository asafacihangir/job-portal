<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>İş İlanlarım</title>

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
        <a class="btn btn-info btn-xs pull-right" href="${contextPath}/job-notices/showFormForAdd" >
            <span class="glyphicon glyphicon-plus-sign"></span>
        </a>
    </div>
    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>İş Tanım</th>
                <th>Şirket</th>
                <th>Pozisyon</th>
                <th>Alınacak Kişi Sayısı</th>
                <th>İstihdam Türü</th>
                <th>Genel Nitelikler</th>
                <th class="text-center">İşlemler</th>
            </tr>
            </thead>
            <tbody>
            <!-- loop over and print our books -->
            <c:forEach items="${jobNotices}" var="jobNotice">

                <!-- construct an "update" link with book id -->
                <c:url var="updateLink" value="${contextPath}/job-notices/showFormForEdit">
                    <c:param name="id" value="${jobNotice.id}" />
                </c:url>

                <!-- construct an "delete" link with book id -->
                <c:url var="deleteLink" value="${contextPath}/job-notices/deleteJobs">
                    <c:param name="id" value="${jobNotice.id}" />
                </c:url>

                <tr>
                    <td>
                        <c:out value="${jobNotice.jobTitle}" />
                    </td>
                    <td>
                        <c:out value="${jobNotice.companyId}" />
                    </td>
                    <td>
                        <c:out value="${jobNotice.position}" />
                    </td>
                    <td>
                        <c:out value="${jobNotice.numOfBeTaken}" />
                    </td>
                    <td>
                        <c:out value="${jobNotice.workType}" />
                    </td>
                    <td>
                        <c:out value="${jobNotice.explanation}" />
                    </td>
                    <td class="text-center">
                        <a href="${updateLink}" class="btn btn-success btn-xs">
                            <span class="glyphicon glyphicon-edit"></span>
                        </a>
                        <a href="${deleteLink}"
                           onclick="return confirm('Bu kitabı silmek istediğinize emin misiz?')"
                           class="btn btn-danger btn-xs">
                            <span class="glyphicon glyphicon-trash"></span>
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
