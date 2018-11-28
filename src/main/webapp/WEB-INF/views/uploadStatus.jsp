<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@ page session="true" %>
<head>
    <meta charset="UTF-8">
    <title>Upload Status - ${nomeCliente} </title>
</head>
<body>
<p>Hello, ${nomeCliente} </p>

<h1>Spring Boot - Upload Status</h1>

<div th:if="${message}">
    <h2 th:text="${message}"/>
</div>

</body>
</html>
