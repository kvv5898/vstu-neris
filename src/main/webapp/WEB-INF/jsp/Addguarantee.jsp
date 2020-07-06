<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Add Guarantee</title>
   </head>
   <body>
      <h3>Добавление новой гарантии</h3>
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/addguarantee">
         <table>
            <tr>
               <td>Дата</td>
               <td><input type="date" name="date" value="${Guarantee.date}" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"/></td>
               <td>Период</td>
               <td><input type="text" name="grant_period" value="${Guarantee.grant_period}" /></td>
               <td>Дополнительная информация</td>
               <td><input type="text" name="guarantee_info" value="${Guarantee.guarantee_info}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Применить" />
                   <a href="addorg">Отмена</a>
               </td>
            </tr>
         </table>
      </form>
      </body>
      </html>
       