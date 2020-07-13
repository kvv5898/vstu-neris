<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Insert Equipment</title>
  </head>
  
 <body>
 <p style="color: red;">${errorgr}</p>
 <br>
 <p style="color: red;">${errorguar}</p>
 
<form method="POST" action="${pageContext.request.contextPath}/equipmentoperation">    
   <table>
   
          <tr>
          <td><input type="text" name="SN" placeholder="Укажите SN" /></td>
          </tr>
          
          <tr>
          <td>
          <p><select name="GR" required>
          <option disabled selected>Выберите группу</option>
          <c:forEach items="${gr}" var="gr">
		  <option value="${gr.group_id}"> ${gr.description} / ${gr.model} / ${gr.group_info}/ </option>
		  </c:forEach>	
          </select>
          </td>
          <td>
          <form>
          <input type="button" value="Добавить Группу" onClick='location.href="${pageContext.request.contextPath}/addgroups"'>
          </form>
          </td>
          </tr>
          
          <tr>
          <td>
          <p><select name="GUAR" required>
          <option disabled selected>Выберите гарантийные обязательства</option>
          <c:forEach items="${guar}" var="guar"> description, month,contract
		  <option value="${guar.guarantee_id}"> ${guar.org_info} / ${guar.month} / ${guar.contract}</option>
		  </c:forEach>
          </select>
          </td>
          
          <td>
          <form>
          <input type="button" value="Добавить гарантийные обязательства" onClick='location.href="${pageContext.request.contextPath}/addguarantee"'>
          </form>
          </td>
          </tr>
  </table>
  <input type="submit" value="Добавить" />
   </form>
   <form>
   <br>
          <input type="button" value="Назад" onClick='location.href="${pageContext.request.contextPath}/home"'>
          <input type="button" value="Показать поступившее оборудование" onClick='location.href="${pageContext.request.contextPath}/equipmentreceived"'>
          </form>
   </body>
</html>