<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>UploadCenter - ${name}</title>
</head>
<body>

<h1>Spring Boot file upload example</h1>
<%
    session.setAttribute("name", request.getParameter("name"));
%>
<%=
     request.getParameter("name")
%>


<form method="POST" action="/upload" enctype="multipart/form-data">
    <p>Hello, <input type="text" name="nomeCliente"/> </p>
    <input type="file" name="file"/><br/><br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>