<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.util.List"%>
<%@ page import="Pegas.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html>
<head>
<title>First JSP</title>
</head>
<body>
<h2>Hello World!</h2>
<p><a href="/java_Servlet_repeat/second">second</a>
<a href="/java_Servlet_repeat/start">start</a>
<a href="/java_Servlet_repeat/first.html">first_html</a>
<a href="/java_Servlet_repeat/fourth">fourth</a>
<a href="/java_Servlet_repeat/index1.jsp">jspIndex1</a>
</p>
<p>
<%response.getWriter().write("First message");
out.print("right here, after header");
%>
</p>
<%=request.getRequestURI()%>
</br>
<%=LocalDateTime.now()%>
</br>
<%List<User>users = (List)request.getAttribute("users");
User fUser = users.get(0);%>
<b><%=fUser.getName()%></b>
<i><%=fUser.getCountry()%></i>
<u><%=fUser.getAge()%></u>
<table>
<%for(User user:users){%>
<tr>
    <td><i><%=user.getName()%></i></td>
    <td><%if(user.getCountry().equals("Vietnam")){%>
        <b><%=user.getCountry()%></b>
    <%}else{%>
        <i><%=user.getCountry()%></i>
    <%}%></td>
    <td><i><%=user.getAge()%></i></td>
</tr>
<%}%>
</table>
</body>
</html>
