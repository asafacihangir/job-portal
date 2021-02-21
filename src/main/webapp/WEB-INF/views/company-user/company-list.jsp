<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>Şirket Listesi</title>

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
        <a class="btn btn-info btn-xs pull-right" href="${contextPath}/company/showFormForAdd" >
            <span class="glyphicon glyphicon-plus-sign"></span>
        </a>
    </div>
    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Ünvanı</th>
                <th>Address</th>
                <th>Tel</th>
                <th>Mail</th>
                <th>Tasarımcı Sayısı</th>
                <th class="text-center">Operations</th>
            </tr>
            </thead>
            <tbody>
            <!-- loop over and print our books -->
            <c:forEach items="${companies}" var="company">

                <!-- construct an "update" link with book id -->
                <c:url var="updateLink" value="${contextPath}/company/showFormForEdit">
                    <c:param name="companyId" value="${company.id}" />
                </c:url>

                <!-- construct an "delete" link with book id -->
                <c:url var="deleteLink" value="${contextPath}/deleteBook">
                    <c:param name="companyId" value="${company.id}" />
                </c:url>

                <tr>
                    <td>
                        <c:out value="${company.title}" />
                    </td>
                    <td>
                        <c:out value="${company.address}" />
                    </td>
                    <td>
                        <c:out value="${company.tel}" />
                    </td>
                    <td>
                        <c:out value="${company.email}" />
                    </td>
                    <td>
                        <c:out value="${company.numOfDesigner}" />
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
