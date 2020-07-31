<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
   <%@include file='styles/div.css' %>
   .center {
	position: absolute;
	width: 100%;
	top: 50%;
	text-align: center;
	animation: blink 2s infinite;
	text-align: center;
}

@keyframes blink {from { opacity:0;
	
}

to {
	opacity: 2;
}
}
</style>
  <head>
  <title>Home page</title>
  </head>
  <body>
 <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
            </div>
  <ul>               
    
    <li><a href="${pageContext.request.contextPath}/auth">Информация о подключениях</a></li>
    <li><a href="${pageContext.request.contextPath}/Step1">Добавить оборудование</a></li>
    <li><a href="${pageContext.request.contextPath}/exit">Выход</a></li>
    
         
</ul>
  
   
  
  
  <body>
	<div class="center">
		<P>Welcome to the site "Network Equipment Registration information System"</P>
	</div>
	 <div class="footer">
        <jsp:include page="_footer.jsp"></jsp:include>
    </div>
   </body>
</html>