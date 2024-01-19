<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%String pageName= request.getParameter("pageName");
request.setAttribute("pageNameVar",pageName);
%>
<h3>This is subpart of ${pageNameVar}</h3>
</body>
</html>