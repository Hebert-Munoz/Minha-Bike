<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bike Web</title>
<link
	href="<c:url value="/resources//bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" />

</head>
<body>

	<c:import url="/WEB-INF/views/menubar.jsp" />

	<br/>

	<div class="container">

		Nome:
		<h3>${bicicleta.nome}</h3>

		Descrição :
		<h3>${bicicleta.descricao}</h3>

		Nota
		<h3>${bicicleta.nota}</h3>

		<h3>Peças :</h3>

		<table class="table">
			<tr>
				<th>Cambio</th>
				<th>Guidão</th>
				<th>Quadro</th>
				<th>Banco</th>
				<th>Rodas</th>
			</tr>
			<tr>
				<td><a href="detalhepeca?id=${bicicleta.cambio.id}">${bicicleta.cambio.nome}</a>
				</td>
				<td><a href="detalhepeca?id=${bicicleta.guidao.id}">${bicicleta.guidao.nome}</a>
				</td>
				<td><a href="detalhepeca?id=${bicicleta.quadro.id}">${bicicleta.quadro.nome}</a>
				</td>
				<td><a href="detalhepeca?id=${bicicleta.banco.id}">${bicicleta.banco.nome}</a>
				</td>
				<td><a href="detalhepeca?id=${bicicleta.rodas.id}">${bicicleta.rodas.nome}</a>
				</td>
			</tr>
		</table>
		
		<br/> <br/> <a href="home">Voltar</a> <br/> <br/>
		</div>
</body>
</html>