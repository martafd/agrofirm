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
    <title></title>
</head>
<body>
<div class="container">
    <div class="constructor">
        <div class="alert alert-success">
            <h2>Adding new culture</h2>

            <form class="form-horizontal" action="/add-culture" method="post">
                <div class="form-group">
                    <label class="control-label col-xs-3">Culture</label>
                    <div class="col-xs-9">
                        <input type="text" maxlength="10" pattern="[A-Za-z]+" required class="form-control" name="cultureName" placeholder="Enter kind of culture">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Sort</label>
                    <div class="col-xs-9">
                        <input type="text" maxlength="10" required class="form-control" name="sortName" placeholder="Enter sort of culture">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3">Field #</label>
                    <div class="col-xs-9" style="font-size: 15px;">
                        <select name="field">
                            <c:forEach items="${fields}" var="field">
                                <option value="${field.id}">Field #${field.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-10">
                        </br><input type="submit" class="btn btn-success" value="Add culture">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
