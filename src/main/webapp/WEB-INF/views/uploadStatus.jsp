<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Upload Status - <%= request.getParameter("first_name")%> </title>
</head>
<body>
<p>Hello, <%= request.getParameter("first_name")%> <% session.getAttribute("name") %> </p>

<h1>Spring Boot - Upload Status</h1>

<div th:if="${message}">
    <h2 th:text="${message}"/>
</div>

</body>
</html>
