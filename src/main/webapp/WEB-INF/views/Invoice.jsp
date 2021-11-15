<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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

<h1 align="center"> Invoices</h1>

		 <c:if test="${not empty message }">
					<h3>${message}</h3>
	 	 </c:if>
	<div class="row">
     <c:forEach items="${payments}" var="invoice">
     <div class="column">
   				<div class="card">

		
		    <h4><b>${invoice.payment_id}</b></h4>
		    
		    <p> Status :  ${invoice.status} </p>
		    <p> Amount :  ${invoice.amount}   Mode of Payment :   ${invoice.modeofpayment }</p>
		     <p>Date : ${invoice.date}   Time : ${invoice.time}  </p>
		
		     <p>Bill No. : ${invoice.bill_no}   </p>
		  </div>
		</div>
		
				
			    
				</c:forEach>
				
				
				</div>  

<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>