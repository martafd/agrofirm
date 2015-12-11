<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 06.11.15
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>

</head>
<body>

<div class="container">
    <div class="constructor">
        <div class="alert alert-success">
            <h2>Adding new employee</h2>
            </br>
            <form class="form-horizontal" action="/add-worker" method="post">
                <div class="form-group">
                    <label class="control-label col-xs-3">Name&Surname</label>
                    <div class="col-xs-9">
                        <input type="text" aria-describedby="name-format" pattern="[A-Za-z]+\s[A-Za-z]+" class="form-control" name="nameSurname" maxlength="50" required placeholder="Enter new employee's name and surname">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Qualification</label>
                    <div class="col-xs-9">
                        <input type="text" pattern="[A-Za-z]+" class="form-control" name="qualification" maxlength="50" required placeholder="Enter new employee's qualification">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Amount of working hours</label>
                    <div class="col-xs-9">
                        <input type="number" min="4" max="12" step="1" class="form-control" name="workHours" required  placeholder="Enter amount of working hours">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Hourly wage rates</label>
                    <div class="col-xs-9">
                        <input type="number" min="20" max="300" class="form-control" name="moneyPerHour" required placeholder="Enter hourly wage rates">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-10">
                        <input type="submit" class="btn btn-success" value="Add new employee">
                    </div>
                </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
