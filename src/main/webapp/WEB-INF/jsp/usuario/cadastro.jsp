<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="../../css/styles.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>AT JAVA</title>
    <style>
        .jumbotron {
            background-color: rgb(197 26 26 / 0%);
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div class="jumbotron text-center">
    <div style="font-family: Calibri;font-weight: bold;font-size: 53px;color: #32464e;text-align: center;margin-left: -162px;">
        Criar Conta
    </div>
</div>
<div class="container">
    <form action="/usuario/incluir" style="margin-left: 350px" method="post">
        <div class="form-group">
            <input type="text" class="form-control" style="width: 300px;border-radius: 10px"
                   placeholder="Insira o seu nome" name="nome" required>
        </div>
        <div class="form-group">
            <input type="email" class="form-control" style="width: 300px;border-radius: 10px"
                   placeholder="Insira o seu e-mail" name="email" required>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" style="width: 300px;border-radius: 10px"
                   placeholder="Insira a sua senha" name="senha" required>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn btn-info">Cadastrar</button>
        </div>
        <div class="btn-group">
            <a href="${voltar}" class="btn btn-default" role="button">Voltar</a>
        </div>
    </form>
</div>
</body>
</html>