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
     <title>Insert Equipment</title>
  </head>
  
 <body>
 <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
            </div>
            <div class="error">
    <p style="color: red;">${errorguar}</p>
</div>
 
<form method="POST" action="${pageContext.request.contextPath}/Step4">
<p><strong>Серийный номер - </strong><input style="text-align: center;" type="text" readonly="readonly" name="sn" value="${sn}"> <strong style="color: green;"> - &#10004;</strong></p>
<p><strong>Группа - </strong><input type="text" readonly="readonly" name="group_id" value="${group_id}" size="5"/>
<input type="text" readonly="readonly" name="group_info" size="${sizegr}" value="${group_info}"/>
<strong style="color: green;"> - &#10004;</strong></p>
<p><strong>Гарантийные обязательства - </strong><input type="text" readonly="readonly" name="guarantee_id" value="${guarantee_id}" size="5"/>
<input type="text" readonly="readonly" name="guarantee_info" size="${sizeguar}" value="${guarantee_info}"/>
<strong style="color: green;"> - &#10004;</strong></p>
 <input type="submit" value="Добавить" />
   </form>
   <form>
   <br>
          <input type="button" value="Назад" onClick='location.href="${pageContext.request.contextPath}/Step3"'>
          <input type="button" value="Показать поступившее оборудование" onClick='location.href="${pageContext.request.contextPath}/equipmentreceived"'>
          </form>
   </body>
</html>