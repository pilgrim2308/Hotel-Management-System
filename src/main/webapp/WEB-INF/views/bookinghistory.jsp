<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>


   				 <h1 align="center">Booking History</h1>
   				 <hr>
   				
     <c:forEach items="${bookings}" var="booking">
    
     <div class="card">
   				 <table align="center">
   				
			        <tr>
			            <th>Booking ID : </th>
			            
			        	<td><h4 >${booking.booking_id}</h4></td>

			        </tr>
			        <tr>
			              <th>Start Date: </th>
			            <td><p> ${booking.start_date} </p></td>
			              <th>End Date: </th>
			            <td><p> ${booking.end_date} </p></td>
			            
			            <th>Payment Status: </th>
			            <td><p> ${booking.payment_status} </p></td>
			        </tr>
			           <tr>
			            <th>Number of members: </th>
			            <td><p>${booking.no_of_members}</p></td>
			        </tr>
			    </table>
			     <a href="invoice/${booking.booking_id }">
				<p>	Invoices</p>
					</a>
			    <hr>
			</div>
		
				</c:forEach>
	
	<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
	

</body>
</html>