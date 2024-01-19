<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%String degreeParam = request.getParameter("degree");
request.setAttribute("degreeVar",degreeParam);
%>
    <c:choose>
        <c:when test="${degreeVar<-25}">it is frost</c:when>
        <c:when test="${degreeVar<=5}">it is cold</c:when>
        <c:when test="${degreeVar<=25}">it is warm</c:when>
        <c:when test="${degreeVar>25}">it is damn hot</c:when>
        <c:otherwise>WHere is my temperature?</c:otherwise>
    </c:choose>
</body>
</html>