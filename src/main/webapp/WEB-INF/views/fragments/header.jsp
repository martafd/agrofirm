<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>
<body>
<div class="container">

    <div class="row">
        <img src="../../resources/images/1.jpg" height="180" width="1170" />
        <div class="navbar navbar-default navbar-inverse">
            <div class="container">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/">Home</a></li>
                        <li><a href="/workers">Employees</a></li>
                        <%--<li><a href="/rss">Feeds</a></li>--%>
                        <%--<li class="dropdown">
                            <a class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Forum<span class="caret"></span></a>--%>
                            <%--<ul class="dropdown-menu">--%>
                                <li><a href="/production">Production</a></li>
                                <%--<li><a href="/production-ajax">With AJAX</a></li>--%>
                           <%-- </ul>--%>
                        <%--</li>--%>
                        <li><a href="/price">Planned cost</a></li>
                    </ul>
                    <div class="pull-right">
                        <%--<a href="/logout"/>">Logout</a>--%>
                        <sec:authorize access="!isAuthenticated()">
                            <ul class="nav navbar-nav navbar-right">
                                <%--<li><a href="/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
                                <li><a href="/signin"><span class="glyphicon glyphicon-log-in"></span> Sign in</a></li>
                            </ul>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a>Hello <sec:authentication property="principal.username"/>!</a></li>
                                <li><a href="/signout"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
                            </ul>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
