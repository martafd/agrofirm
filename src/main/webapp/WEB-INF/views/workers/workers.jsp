<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%--        <c:forEach items="${content}" var="row">
            <p>${row.content}</p>
        </c:forEach>--%>


        <%--    вивід робітників--%>

    <div class="container">
    <%--<h2>Hover Rows</h2>--%>

        <h2>Our employees</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name&Surname</th>
            <th>Qualification</th>
            <th>Amount of working hours</th>
            <th>Hourly wage rates</th>
            <sec:authorize access="hasRole('ROLE_USER')">
                <th>Edit</th>
                <th>Delete</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${workers}" var="worker">
            <tr>
                <%--<td><a href="/forum/${post.id}">${post.name}</a></td>--%>
                    <td>${worker.nameSurname}</td>
                    <td>${worker.qualification}</td>
                    <td>${worker.workHours}</td>
                    <td>${worker.moneyPerHour}</td>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <td><a class="btn btn-warning" href="/edit-worker/${worker.id}">Edit</a> </td>
                        <td><a class="btn btn-danger" href="/delete-worker/${worker.id}">Delete</a> </td>
                    </sec:authorize>
            </tr>
        </c:forEach>
        <sec:authorize access="hasRole('ROLE_USER')">
            <a class="btn btn-success" data-toggle="modal" href="/add-worker">Add new employee</a>
        </sec:authorize>
        </tbody>
    </table>
      </div>
    <div class="container">
<%--        <div class="constructor">
        <div class="jumbotron" style="margin-top: 20px;">
            <button>AJAX DEMO</button>
            <p id = "test">qq</p>
        </div> --%>
            <%--  групування по кваліфікації--%>
        </div>
        <h2>Salary due to qualification</h2>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Qualification</th>
                <th>Salary</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${salaryStatisticsList}" var="salaryStatistics">
                <tr>
                    <td>${salaryStatistics.qualification}</td>
                    <td>${salaryStatistics.avgMoneyPerHour}</td>
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
