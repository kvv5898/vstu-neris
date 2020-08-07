<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>

.header {
            left: 0;
            top: 0;
            width: 100%;
        }

.footer {
            position: fixed;
            /* Фиксированное положение */
            right: 0;
            bottom: 0;
            /* Левый нижний угол */
            width: 100%;
        }
        
   .center {
	position: absolute;
	text-align: center;
	animation: blink 2s infinite;
	text-align: center;
	color: red;
}

@keyframes blink {from { opacity:0;
	
}

to {
	opacity: 2;
}
}
</style>
  <head>
  <title>Error</title>
  </head>
  <body>
 <div class="header">
        <jsp:include page="_header.jsp"></jsp:include>
        <br>
        </div>
	<div class="center">
		<P>ERROR</P>
	</div>
	 <div class="footer">
        <jsp:include page="_footer.jsp"></jsp:include>
    </div>
   </body>
</html>