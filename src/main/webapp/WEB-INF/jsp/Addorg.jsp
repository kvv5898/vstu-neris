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
      <h3>Добавление новой организации</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/addorg">
         <table>
            
            <tr><td>description</td>
            <td><input type="text" name="description" value="${Org.description}" /></td>
            </tr>
            
            <tr><td>tel</td>
            <td><input type="text" name="tel" value="${Org.tel}" /></td>
            </tr>
            
            <tr><td>address</td>
            <td><input type="text" name="address" value="${Org.address}" /></td>
            </tr>
            
            <tr><td>guarantee</td>
            <td><p><select name="guarantee_id" required>
          <option disabled selected>Выберите гарантию</option>
          <c:forEach items="${guarantee}" var="guarantee">
		  <option value="${guarantee.guarantee_id}">  ${guarantee.date} / ${guarantee.grant_period} / ${guarantee.guarantee_info} / </option>
		  </c:forEach>	
          </select></td>
          <td>
          <form>
          <input type="button" value="Добавить Гарантию" onClick='location.href="${pageContext.request.contextPath}/addguarantee"'>
          </form>
          </td>
            </tr>
            
            <tr><td>organization_info</td>
            <td><input type="text" name="organization_info" value="${Org.organization_info}" /></td>
            </tr>
               
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Применить" />
                   <a href="equipmentoperation">Отмена</a>
               </td>
            </tr>
         </table>
      </form>
      </body>
      </html>
       