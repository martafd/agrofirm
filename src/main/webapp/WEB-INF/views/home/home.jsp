<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />" type="text/javascript"></script>
</head>
<body>
<div>
    <jsp:include page="../fragments/header.jsp"/>
</div>
<div class="container">
    <div class="constructor">
            <p>Private limited company «Agrofirm-Elit» was created on the basis of the association
                "Ukrainian seeds and vegetables", by delegating the production and saling  vegetable
                seeds and grains to ensure the most demanding producers and a host of high quality
                seeds at affordable prices.</p>
        <img src="../../resources/images/4.jpg" height="200" width="340" class="leftimg"/>
        <%--<img src="../../resources/images/5.jpg" height="200" width="340" class="leftimg"/>
        <img src="../../resources/images/3.jpg" height="200" width="340" class="leftimg"/>--%>
        </br></br>Agriculture has no boundaries in development, so we're working and multiply our
        achievements, we constantly train our employees, organize practice and young professionals encourage their work.</br></br>
        <img src="../../resources/images/5.jpg" height="200" width="340" class="rightimg"/>
        </br></br>
        </br>
        Today, our partners are leading breeding centers of Ukraine (Institute of Vegetables
        and Melon-Growing grid and its experimental stations) and Europe: France (GSN, Semences, Clause Tezier),
        Germany (Satimex Quedlinburg, NL Chrestensen, Benary),Poland (Polan, Rolimpex, Malopolska Hodowla Roslin), Hungary, the Netherlands and Italy.
       </br></br>
        </br>


               <%-- <c:forEach items="${content}" var="row">
                    <p>${row.content}</p>
                </c:forEach>--%>
        </div>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
