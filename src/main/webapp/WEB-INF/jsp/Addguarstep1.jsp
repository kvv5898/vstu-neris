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
     <title>Add guarantee step1</title>
  </head>
  
 <body>
 <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
            </div>
            <div class="error">
    <p style="color: red;">${error}</p>
</div>
 
<form method="POST" action="${pageContext.request.contextPath}/Addguarstep1">
<p><input type="hidden" readonly="readonly" name="sn" value="${sn}"></p>
<p><input type="hidden" readonly="readonly" name="group_id" value="${group_id}"/>
<input type="hidden" readonly="readonly" name="group_info" value="${group_info}"/></p>



          
       
<strong>Выберите или укажите название организации</strong>
       
        <p> <input type="text" list="org" name="org" value="" style="border-color: ${color}">
               <datalist id="org">
                <c:forEach items="${org}" var="org">
		  <option value="${org.org_name}">${org.organization_id} - ${org.org_name} / ${org.address} / ${org.organization_info}</option>
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