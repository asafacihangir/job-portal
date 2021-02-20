<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <script src="${contextPath}/resources/jquery/js/jquery.min.js"></script>

    <style>
        .loginPanel {
            width: 320px;
            margin-top: 100px;
            margin-left: auto;
            margin-right: auto;
        }

    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="loginPanel">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">Giriş Paneli</div>
                </div>
                <div class="panel-body">
                    <form method="post" action="${pageContext.request.contextPath}/login">
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-user"></i>
                            </span>
                            <input id="username" type="text" class="form-control" name="username"
                                   placeholder="Kullanıcı Adı"/>
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-lock"></i>
                            </span>
                            <input id="password" type="password" class="form-control"
                                   name="password" placeholder="Şifre"/>
                        </div>
                        <button type="submit" class="btn btn-success btn-block">Giriş</button>
                        <br/>

                        <a href="${pageContext.request.contextPath}/showCreateNewUser">Yeni Kullanıcı Oluştur</a>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
