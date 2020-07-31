<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New View</title>

</head>
<body>
<p style="color: red;">${errorString}</p>
	<p>Поступившее оборудование</p>
	<table border="1">
	<th>ID оборудования</th>
	<th>Серийный номер</th>
	<th>Группа</th>
	<th>Организация</th>
	<th>Гарантийный кантракт</th>
		<c:forEach var="add" items="${add}">
			<tr>
				<td>${add.equipment_id}</td>
				<td>${add.sn}</td>
				<td>${add.group_info}</td>
				<td>${add.org_name}</td>
				<td>${add.contract}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="Домой" onClick='location.href="${pageContext.request.contextPath}/home"'>
</body>
</html>