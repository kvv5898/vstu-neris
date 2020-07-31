<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
   <%@include file='styles/div.css' %>
  input {
	text-align: center;
}
</style>
  <head>
     <meta charset="UTF-8">
     <title>Add guarantee step2</title>
  </head>
  
 <body>
 <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
            </div>
            <div class="error">
    <p style="color: red;">${error}</p>
</div>
 
<form method="POST" action="${pageContext.request.contextPath}/Addguarstep2">
<p><input type="hidden" readonly="readonly" name="sn" value="${sn}"></p>
<p><input type="hidden" readonly="readonly" name="group_id" value="${group_id}"/>
<input type="hidden" readonly="readonly" name="group_info" value="${group_info}"/></p>
<input type="hidden" readonly="readonly" name="org_organization_id" value="${org_organization_id}"/></p>


          
       
<strong style="color: ${color}">${org_name} - &#10004</strong>
<p>Выберите или укажите № договора на гарантийные обязательства:</p>
       
        <p> <input type="text" list="validity" name="validity" value="" style="border-color: ${color}">
               <datalist id="validity">
                <c:forEach items="${validity}" var="validity">
		  <option value="${validity.contract}">${validity.contract} - ${validity.org_name} / ${validity.date} / ${validity.month} / ${validity.validity_info}</option>
		  </c:forEach>	
               </datalist>
         </p>
          
 <input type="submit" value="Далее" name="submit" />
   </form>
   
  
            <div class="footer">
        <jsp:include page="_footer.jsp"></jsp:include>
    </div>
   </body>
</html>