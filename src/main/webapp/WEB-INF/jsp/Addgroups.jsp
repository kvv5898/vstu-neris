<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Add Groups</title>
   </head>
   <body>
      <h3>Добавление новой группы</h3>
      <p style="color: red;">${error}</p>
      
      
      <form method="POST" action="${pageContext.request.contextPath}/Addgroups">
      <p><strong>Серийный номер - </strong><input style="text-align: center;" type="text" readonly="readonly" name="sn" value="${sn}"> <strong style="color: green;"> - &#10004;</strong></p> 
         <table>
            <tr>
               <td><strong style="color: ${desccolor}">Описание</strong><font color="red">*</font></td>
               
               <c:choose>
   <c:when test = "${description == '2'}">
   <td><p><input type="text" value="123" ></p></td></c:when>
   <c:otherwise><td><p><input type="text" list="description" name="description">
               <datalist id="description" >
                <c:forEach items="${description}" var="desc">
		  <option value="${desc}"></option>
		  </c:forEach>	
               </datalist>
               </p></td></c:otherwise>
   </c:choose>
              
               <td><strong style="color: ${modelcolor}">Модель</strong><font color="red">*</font></td>
               <td><p><input type="text" list="model" name="model">
               <datalist id="model">
               <c:forEach items="${model}" var="model">
		  <option value="${model}"></option>
		  </c:forEach>	
               </datalist>
               </p></td>
               <td><strong style="color: ${group_infocolor}">Дополнительная информация</strong><font color="red">*</font></td>
               <td><p><input type="text" list="group_info" name="group_info">
               <datalist id="group_info">
                <c:forEach items="${group_info}" var="group_info">
		  <option value="${group_info}"></option>
		  </c:forEach>	
               </datalist>
               </p></td>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Добавить" name="submit" onclick="msg()" />
                   <input type="reset"/>
                   <input type="submit" value="Назад" name="back">
               </td>
            </tr>
         </table>
      </form>
      <br>
      <font color="red">*</font> - <strong>Поля обязательно для заполнения</strong>
      </body>
      </html>
       