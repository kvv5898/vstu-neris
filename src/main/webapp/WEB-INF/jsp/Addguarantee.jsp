<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Add Guarantee</title>
    
    <script src="http://code.jquery.com/jquery-2.2.4.js" 
                type="text/javascript"></script>
        <script src="js/org-ajax.js" type="text/javascript"></script>
    
    <style>
        .header {
            left: 0;
            top: 0;
            width: 100%;
        }
        
        .error {
            
            height: 20px;
            width: 100%;
           }
        
        .org {
            overflow: scroll;
            float: left;
            height: 200px;
            border: 1px solid purple;
            max-width: 49%;
        }

        .validity {
            overflow: scroll;
            float: right;
            height: 200px;
            border: 1px solid purple;
            max-width: 49%;
        }
        
        .addorg {
           
            float: left;
            max-width: 49%;
        }
        
        .addvalidity {
           
            float: right;
            max-width: 49%;
        }

        .footer {
            position: fixed;
            /* Фиксированное положение */
            right: 0;
            bottom: 0;
            /* Левый нижний угол */
            width: 100%;
        }

 table {
 width: 100%;
 display:content;
 table-layout:fixed;
 }
 
  thead th {
            position: -webkit-sticky;
            /* for Safari */
            position: sticky;
            top: 0;
            background: gray;

        }
        
        .filterInput{
    margin: 0;
    padding: 0;
    width: 98%;
    border: 1px;
    border-style: solid;    
}
        
    </style>
</head>

<body>
    <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
            </div>
                       
    <strong>Ответ javax </strong>: 
                    <sapn id="rez">  </sapn>
                       <br>
                    <table id="table">
  <thead>
    <tr>
      <th>ID</th>
                <th>Дата</th>
                <th>Гарантийный срок</th>
                <th>Наименование организации</th>
                <th>Контракт</th>
                <th>Дополнительная информация</th>
    </tr>
  </thead>
  <tbody></tbody>
</table>                <br/>
    
    <div class="error">
    <p style="color: red;">${errororg}</p>
    <p style="color: red;">${errorvalidity}</p>
</div>

    <div class="org">
        <table border="1">
         <caption><strong>Выбор/Добавление организации</strong></caption>   
     <thead>
                <th>ID</th>
                <th>Название</th>
                <th>Контактный телефон</th>
                <th>Адрес</th>
                <th>Дополнительная информация</th>
       </thead>     
            <c:forEach items="${org}" var="org">
                <tr class="info" id="${org.org_info}" >
                    <td></td>
                    <td>${org.org_info}</td>
                    <td>${org.tel}</td>
                    <td>${org.address}</td>
                    <td>${org.organization_info}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="validity">
        <table border="1" >
            <caption><strong>Выбор/Добавление гарантийных условий</strong></caption>
             <thead>
                <th>ID</th>
                <th>Дата</th>
                <th>Гарантийный срок</th>
                <th>Наименование организации</th>
                <th>Контракт</th>
                <th>Дополнительная информация</th>
           </thead>   
            <c:forEach items="${validity}" var="validity">
            <c:choose>
            <c:when test="${us == validity.org_info}">
                <tr>
                    <td>
                        <p><input type="checkbox" name="b" value="${validity.validity_id}"></p>
                    </td>
                    <td>${validity.date}</td>
                    <td>${validity.month}</td>
                    <td>${validity.org_info}</td>
                    <td>${validity.contract}</td>
                    <td>${validity.validity_info}</td>
                </tr>
                </c:when>
                </c:choose>
            </c:forEach>
        </table>
    </div>
    <div class="addorg">
<form method="POST" action="${pageContext.request.contextPath}/addguarantee">
        <table>
        <tr>
               <td><input type="submit" name="ORG" value="Добавить" class="filterInput"></td>
               <td><input type="text" name="description" class="filterInput"></td>
               <td><input type="text" name="tel" class="filterInput"></td>
               <td><input type="text" name="address" class="filterInput"></td>
               <td><input type="text" name="organization_info" class="filterInput"></td>
               </tr>
               </table>
            </form>
</div>

<div class="addvalidity">
<form method="POST" action="${pageContext.request.contextPath}/addguarantee">
        <table>
        <tr>
               <td><input type="submit" name="VALIDITY" value="Добавить" class="filterInput"></td>
               <td><input type="date" name="date" value="${Guarantee.date}" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" class="filterInput"></td>
               <td><input type="text" name="month" class="filterInput"></td>
               <td><input type="text" name="contract" class="filterInput"></td>
               <td><input type="text" name="validity_info" class="filterInput"></td>
</tr>
               </table>
            </form>
</div>
    <div class="footer">
        <jsp:include page="_footer.jsp"></jsp:include>
    </div>
</body>

</html>