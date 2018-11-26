<!DOCTYPE HTML>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<html>
<head>
    <title>Dimensions - <%= request.getParameter("first_name")%> </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p>Hello, <%= session.getAttribute("name")%> </p>

<c:if test="${message}">
    ${message}
</c:if>

Form
<form:form method="POST" action="/dimensions" modelAttribute="retangulo">
    Nome: <input type="text" name="nome">
    <br/>
    X: <input type="text" name="x">
    <br/>
    Y: <input type="text" name="y"/>
    <br/>
    Altura: <input type="text" name="altura"/>
    <br/>
    Largura: <input type="text" name="largura"/>
    <br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>