<!DOCTYPE HTML>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<html>
<head>
    <title>Dimensions - ${nomeCliente} </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p>Hello, ${nomeCliente} </p>

Form ${arquivoPDF.arquivoPDF.name}
<form:form method="POST" action="/dimensions" modelAttribute="retangulo">
    Nome: <input type="text" name="nomeRegiao">
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