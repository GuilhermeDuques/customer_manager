<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>AT JAVA</title>
    <style>
        .jumbotron {
            background-color: rgb(197 26 26 / 0%);
            color: black;
        }
    </style>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom: 0">
    <h1>Clientes</h1>
</div>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container" style="margin-top: 50px">
    <h3>Cadastrar seus clientes</h3>

    <%--@elvariable id="cliente" type="java"--%>
    <form:form action="/cliente/salvar" method="post" modelAttribute="cliente">
        <div class="form-group">
            ID: ${cliente.id}
            <form:hidden path="id" class="form-control"/>
        </div>
        <div class="form-group">
            Nome:
            <form:input path="nome" class="form-control"/>
        </div>
        <div class="form-group">
            Telefone:
            <form:input path="telefone" class="form-control"/>
        </div>
        <div class="form-group">
            CPF:
            <form:input path="cpf" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" id="submit" class="btn-primary" value="Salvar">
        </div>
    </form:form>
</div>
<br>
<div class="container">
    <h3>Lista de Clientes</h3>
    <c:if test="${not empty lista}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Telefone</th>
                <th>CPF</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${lista}">
                <tr>
                    <td>${c.nome}</td>
                    <td>${c.telefone}</td>
                    <td>${c.cpf}</td>
                    <td><a href="/cliente/alterar?id=${c.id}">Alterar</a></td>
                    <td><a href="/cliente/${c.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${not empty erro}">
        <div class="alert alert-danger">
            <strong>Erro!</strong> ${erro}
        </div>
    </c:if>
    <c:if test="${empty lista}">
        <br>
        <p>Nenhum cliente cadastrado.</p>
        <br>
    </c:if>
</div>
</body>
</html>