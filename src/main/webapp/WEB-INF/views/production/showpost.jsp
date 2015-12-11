<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/mystyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>
<body>
<div>
  <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container">
  <h1>${post.title}</h1>
</div>
    <div class="container">
      <div class="row">
          <div class="col-md-3">
            <h4>${post.author}</h4>
            <p>${post.date}</p>
          </div>
          <div class="col-md-7 col-border">
            <p>${post.body}</p>
          </div>
          <div class="col-md-2 col-border">
            <p>This is place for likes / unlikes</p>
          </div>
      </div>
    </div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
