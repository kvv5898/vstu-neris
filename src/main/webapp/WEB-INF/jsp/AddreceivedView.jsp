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
	<p>Поступившее оборудование</p>
	<table border="1">
		<c:forEach var="add" items="${add}">
			<tr>
				<td>${add.equipment_id}</td>
				<td>${add.sn}</td>
				<td>${add.group_id}</td>
				<td>${add.organization_id}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>