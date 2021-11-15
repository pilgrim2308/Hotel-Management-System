<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

<h1 align="center"> Salary Info</h1>


		<c:if test="${not empty message }">
					<h3>${message}</h3>
	 	 </c:if>
	 	 
	 	<div class="row">
	 	
     <c:forEach items="${salaries}" var="salary">
     <div class="column">
   				<div class="card">
		
		<h3>Payment ID: ${salary.payment_id } </h3>
		<h4> Employee ID: ${salary.customer_id }</h4>
		<p> Amount : ${salary.amount }    Date : ${salary.date } </p>
		
		</div>
		</div>
				
			    
				</c:forEach>
				
				
					</div>   
	 

<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>