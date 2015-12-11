<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h2>Expenses during production</h2>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Month</th>
                <th>Expenses during manufacturing operations</th>
                <%--<th>Вид технологічної операції</th>
                <th>Культура рослиництва</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${statisticsList}" var="statisticsUnit">
                <tr>
                    <td>${statisticsUnit.month}</td>
                    <td>${statisticsUnit.spendMoney}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
      <%--  <c:forEach items="${page}" var="unit">
            <h3>Answer</h3>
            ${unit.answer}
            <h3>Question</h3>
            ${unit.question}
        </c:forEach>--%>
    </div>
</div>
<div>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>
</html>
