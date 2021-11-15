<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Room Service</title>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

	 <h1>Rooms Services</h1>
   				
     <c:forEach items="${roomservices}" var="roomservice">
   				 <table>
   				
			        <tr>
			            <th>ID: </th>
			            <td><p >${roomservice.service_ID}<p/></td>
			        </tr>
			        <tr>
			            <th>Room No. : </th>
			            <td><p> ${roomservice.ROOM_ID} <p/></td>
			               <th>Status : </th>
			            <td><p> ${roomservice.status} <p/></td>
			        </tr>
			           <tr>
			            <th>Demands: </th>
			            <td><p>${roomservice.demands}</p></td>
			            
			               <th>Request Time:</th>
			               <td><p>${roomservice.time}</p></td>
			        </tr>
			        <tr>
			        	<td align="center">
					<a href="${pageContext.request.contextPath }/employee/room_s/done/${roomservice.service_ID}">Done</a>
						</td>
					</tr>
			        <hr>
			    </table>
			
				</c:forEach>
		<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>