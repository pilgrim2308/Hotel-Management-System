<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

 <c:forEach items="${employees}" var="employee">
   				 <table align="center">
   				
			        <tr>
			            <th> Employee username : </th>
			            
			        	<td><h4 >${employee.username}</h4></td>

			        </tr>
			      <tr>
			      <td>  <a href="${pageContext.request.contextPath }/admin/salary/${employee.username}">Salary Info</a> </td>
			     </tr>
			    </table>
			    <hr>
			
				</c:forEach>
				<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>