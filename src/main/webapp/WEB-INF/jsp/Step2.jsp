<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
   <%@include file='styles/div.css' %>
</style>
  <head>
     <meta charset="UTF-8">
     <title>Insert Equipment Step2</title>
  </head>
  
 <body>
 <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
            </div>
            <div class="error">
    <p style="color: red;">${error}</p>
    <p style="color: red;">${errorgr}</p>
    <p style="color: red;">${errorguar}</p>
</div>
 
<form method="POST" action="${pageContext.request.contextPath}/Step2">
<p><strong>Серийный номер</strong> - <input style="text-align: center;" type="text" name="sn" readonly="readonly" value="${sn}"> <strong style="color: green;"> - &#10004;</strong></p>

<table>
<tr>
          <td>
          <p><select name="gr" required style="border-color:  ${color};">
          <option disabled selected>Выберите группу</option>
          <c:forEach items="${gr}" var="gr">
		  <option value="${gr.group_id}"> ${gr.description} / ${gr.model} / ${gr.group_info}/</option>
		  </c:forEach>	
          </select></p>
          </td>
          </tr>
</table>
 <input type="submit" value="Далее" name="submit" />
 <input type="reset"/>
 <input type="submit" value="Добавить новую группу" name="Addgroups">
   </form>
   
  
            <div class="footer">
        <jsp:include page="_footer.jsp"></jsp:include>
    </div>
   </body>
</html>