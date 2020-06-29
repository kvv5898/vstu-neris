<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <title>Home page</title>
  <style>
.center {
	position: absolute;
	width: 100%;
	top: 50%;
	text-align: center;
	animation: blink 2s infinite;
	text-align: center;
}

@
keyframes blink {from { opacity:0;
	
}

to {
	opacity: 2;
}
}
</style>
  </head>
  <ul>               
    
    <li><a href="${pageContext.request.contextPath}/auth">Информация о подключениях</a></li>
    <li><a href="${pageContext.request.contextPath}/insertequipment">insertequipment</a></li>
    <li><a href="${pageContext.request.contextPath}/exit">Выход</a></li>
    
         
</ul>
  
   
  
  
  <body>
	<div class="center">
		<P>Welcome to the site "Network Equipment Registration information System"</P>
	</div>
</html>