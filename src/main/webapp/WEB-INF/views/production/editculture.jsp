<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 08.12.15
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
  <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>
<body>
<div class="container">
  <div class="constructor">
    <div class="alert alert-warning">
      <h2>Changing information about culture</h2></br>
      <div class="form-horizontal" action="/edit-culture/${plant.id}" method="post">
        <div class="form-group">
          <label class="control-label col-xs-3">Culture</label>
          <div class="col-xs-9">
            <input type="text" maxlength="10" class="form-control" pattern="[A-Za-z]+" name="name" placeholder="${plant.cultureName}">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">Sort</label>
          <div class="col-xs-9">
            <input type="text" maxlength="10" class="form-control" name="sort" placeholder="${plant.sortName}">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-xs-3">Field #</label>
          <div class="col-xs-9" style="font-size: 15px;">
          <%--  <input type="number" min="4" max="12" step="1" class="form-control"
          name="workHours" placeholder="${worker.workHours}">
          </div>
        </div>--%>

            <select name="field">
              <c:forEach items="${fields}" var="field">
                <option value="${field.id}">Field #${field.id}</option>
              </c:forEach>
            </select>
          </div>
        </div>


        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-10">
            <input type="submit" class="btn btn-warning" value="Change information">
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

