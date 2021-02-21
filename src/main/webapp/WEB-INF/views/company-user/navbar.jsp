
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">İş Başvuru Sistemi</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="${contextPath}/company/main">Anasayfa</a>
                </li>
                <li>
                    <a href="${contextPath}/company/company-list">Şirket Bilgileri</a>
                </li>
                <li>
                    <a href="${contextPath}/company/job-notices">İş İlanlarım</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <c:out value="${currentUser.username}" />
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu animated fadeInUp">
                        <li>
                            <a href="${contextPath}/company/showUserInfo">Kullanıcı Bilgileri</a>
                        </li>
                        <li>
                            <a href="<c:url value="/logout" />">Çıkış Yap</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

