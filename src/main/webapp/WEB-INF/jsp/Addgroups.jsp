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
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/addgroups">
         <table>
            <tr>
               <td>Описание</td>
               <td><input type="text" name="description" value="${Groups.description}" /></td>
               <td>Модель</td>
               <td><input type="text" name="model" value="${Groups.model}" /></td>
               <td>Дополнительная информация</td>
               <td><input type="text" name="group_info" value="${Groups.group_info}" /></td>
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
       