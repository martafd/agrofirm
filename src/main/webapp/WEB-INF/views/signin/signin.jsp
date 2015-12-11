<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
  <title>Home</title>
</head>
<body>
<%--
<div class="container">
   <div class="constructor">
        <div class="col-xs-3">
            <form class="form-signin" action="/signin" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <div class="form-group">
                    <label class="control-label col-xs-3" for="email" &lt;%&ndash;class="sr-only"&ndash;%&gt;>Email address</label>
                    <div></div>
                    <input type="email" pattern="\S+@[a-z]+.[a-z]+" id="email" class="form-control" name = "email" placeholder="Email address">
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" for="password" &lt;%&ndash;class="sr-only&ndash;%&gt;">Password</label>
                    <input type="password" required id="password" class="form-control" name = "password" placeholder="Password" >
                </div>
                <div class="form-group">
                    <button class="btn btn-lg btn-success &lt;%&ndash;btn-block&ndash;%&gt;" type="submit">Sign in</button>
                </div>
            </form>
        </div>
    </div>
</div>--%>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <form class="form-signin" action="/signin" method="post">
                <fieldset>
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <div class="form-group">
                        <label for="email" class="control-label">Email address:</label></br>
                        <input type="email" id="email" class="form-control" name = "email" required pattern="\S+@[a-z]+.[a-z]+" placeholder="Enter your email address">
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">Password:</label></br>
                        <input type="password" id="password" class="form-control" name = "password" required placeholder="Enter password" >
                    </div>
                    <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>