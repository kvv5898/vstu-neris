<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>History discounts</title>
<style type="text/css">
<%@include file='styles/menu.css' %>
</style>
</head>
<body>

	<table border="3" align="center">
		<th width="150">

			<ul id="menu">
				<li><a href="#">Меню</a>
					<ul class="sub-menu">
						<li><a href="${pageContext.request.contextPath}/home">Главная</a></li>
						<li><a href="${pageContext.request.contextPath}/equipmentreceived">Добовление оборудования</a></li>
						<li><a href="${pageContext.request.contextPath}/addgroups">Добовление группы</a></li>
						<li><a href="${pageContext.request.contextPath}/addorg">Добовление организации</a></li>
						<li><a href="${pageContext.request.contextPath}/addorg">Добовление гарантийных обязательств</a></li>
						<li><a href="${pageContext.request.contextPath}/exit">Выход</a></li>

					</ul></li>

			</ul>
		</th>
		<th width="800">
			<p title="Network equipment register information system">NERIS</p>
		</th>
		<th width="150">
				</th>
	</table>
</body>
</html>