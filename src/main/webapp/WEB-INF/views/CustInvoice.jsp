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

<h1 align="center">Invoice</h1>
<div align="center">
<c:if test="${not empty message}">
<h2> ${message}</h2>
</c:if>

<c:if test="${not empty matter}">
<h2> ${matter}</h2>
</c:if>
   	<div>
   	<table align="center">
   	<tr><td><h2>Invoice ID: ${invoice.invoice_id }</h2></td></tr>
   	<tr> <td>Customer ID:  ${invoice.customer_id }</td>  </tr>
   	 	<tr> <td> Payment ID: ${invoice.payment_id}</td>  </tr>
   	 	 	<tr> <td> Price :  ${invoice.amount }</td><td>  Date: ${invoice.date} </td>  </tr>
   	
   	</table>
   	
     
    </div>
    <div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>