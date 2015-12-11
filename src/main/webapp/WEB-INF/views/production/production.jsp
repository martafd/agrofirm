<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page contentType="text/html; charset=Windows-1251" language="java"%>
<%@ page contentType="text/html;charset=cp1251" language="java" %>--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>
<body>
<div>
    <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container">
    <div class="constructor">
        <div class="container">
            <%--<h2>Hover Rows</h2>--%>

                <h2>Culture of plant</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Culture of plant</th>
                    <th>Sort of plant</th>
                    <th>Field #</th>
                    <th>Area</th>
                    <%--<sec:authorize access="hasRole('ROLE_USER')">
                        <th>Edit</th>
                        <th>Delete</th>
                    </sec:authorize>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${plants}" var="plant">
                    <tr>
                        <td>${plant.culture}</td>
                        <td>${plant.sort}</td>
                        <td>${plant.fieldNumber}</td>
                        <td>${plant.fieldArea}</td>
                        <%--<sec:authorize access="hasRole('ROLE_USER')">
                            <td><a class="btn btn-warning" href="/edit-worker/${worker.id}">Edit</a> </td>
                            <td><a class="btn btn-danger" href="/delete-worker/${worker.id}">Delete</a> </td>
                        </sec:authorize>--%>
                    </tr>
                </c:forEach>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a class="btn btn-success" data-toggle="modal" href="/add-culture">Add new culture</a>
                </sec:authorize>
                </tbody>
            </table>
                <h2>Production</h2>
                <%--<table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Місяць</th>
                        <th>Технологічна опереція</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td><a href="/forum/${post.id}">${post.name}</a></td>
                            <td>${post.sort}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>--%>
                </br>

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Culture</th>
                        <th>Technological operations</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cultureStatisticsList}" var="cultureStatistics">
                        <tr>
                            <td>${cultureStatistics.culture}</td>
                            <td>${cultureStatistics.techOperation}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

        </div>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
