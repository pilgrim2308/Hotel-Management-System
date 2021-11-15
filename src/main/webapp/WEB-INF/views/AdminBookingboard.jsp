<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Room Service</title>
 <link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>
<div class="container-fluid">
		<div class="row">
   	<div class="col-sm-9">

	 	 <h3 align="center"> Bookings </h3>
	 	 
	 	 
   				<div class="row">
   	
     <c:forEach items="${bookings}" var="booking">

      <div class="column">
      <a href="${pageContext.request.contextPath }/admin/booking/${booking.booking_id}" >
      
   				<div class="card">

		
		    <h4><b>Booking ID: ${booking.booking_id}</b> </h4><h4> Customer ID : ${booking.customer_id}  </h4>
		    <p>${booking.no_of_members}</p>
		     <p> Start Date: ${booking.start_date}    End Date: ${booking.end_date}</p>
		      
		     <p> Check In : ${booking.checkin}    Check Out : ${booking.checkout}</p>
		     
		
		  </div>
		     
		   </a> 	
		   		    
	
				
				</div>
</c:forEach>
</div>

			
			<c:if test="${not empty bookingdetail}">
			
				 
				 <h2 align="center">free rooms List</h2>
				 <div class="row">
		  
		  
		      
		     <c:forEach items="${free_rooms}" var="room">

				<div class="column">
      
   				<div class="card">

		
		    <h4><b>Room No: ${room.room_no}</b> </h4>
		    <p> No. of Beds  ${room.no_of_Beds}</p>
		     <p> AC  : ${room.air_Conditioned}   </p>
		     
		     <p> priviledge Level : ${room.priviledge_Level}    price:   ${room.price}</p>
		      
		     <p>
     				 <a href="${pageContext.request.contextPath }/admin/booking/add/${room.room_no}" ><b>Add</b> </a>
     				 
     				 </p>
		     
		     
		
		  </div>
		  </div>
		</c:forEach>
		</div>
		 
			
			
			
			<br>
			
			
			<div align="center" class="jumbotron bg-dark">
			<h1> Booking details</h1>
		
		    <h4><b>Booking ID: ${bookingdetail.booking_id} </h4><h4> Customer ID : ${bookingdetail.customer_id}  </b></h4>
		    <p>${bookingdetail.no_of_members}</p>
		     <p> Start Date: ${bookingdetail.start_date}    End Date: ${bookingdetail.end_date}</p>
		      
		     <p> Check In : ${bookingdetail.checkin}    Check Out : ${bookingdetail.checkout}</p>
		     
		 <div>
		   <h2> Rooms types to be alloted </h2>
		       <c:forEach items="${roomtypes}" var="room">

		
      
   				<div class="card">

		
		    <h4><b>Booking ID: ${room.booking_id}</b> </h4><h4> priviledge level : ${room.priviledge_level}  </h4>
		    <p> Total count : ${room.count}</p>
		      
		     
		
		  		</div>
		     	
			
			</c:forEach>
			</div>
	<button class="btn  btn-primary navbar-btn"  onclick="window.location.href='/admin/booking/invoice/${bookingdetail.booking_id}';"> Receipts</button>
       
	 <button class="btn  btn-primary navbar-btn"  onclick="window.location.href='/admin/booking/cleardues/${bookingdetail.booking_id}';">clear Dues</button>
       
		 
    <button class="btn  btn-primary navbar-btn"  onclick="window.location.href='/admin/booking/checkout/${bookingdetail.booking_id}';">Checkout</button>
       
		   </div>
		  
	
		   		    
	
			
		  
	
		  
		  
		  
		
		  
		  <div>
		  <h2>Alloted rooms List</h2>
		  <div class="row">
		  <c:forEach items="${booked_rooms}" var="room">

				<div class="column">
      
   				<div class="card">

		
		    <h4><b>Room No: ${room.room_no}</b> </h4>
		    <p> No. of Beds  ${room.no_of_Beds}</p>
		     <p> AC  : ${room.air_Conditioned}  </p>
		     
		     <p> priviledge Level : ${room.priviledge_Level}    price:   ${room.price}</p>
		      
		     <p>
     				 
     				 <a href="${pageContext.request.contextPath }/admin/booking/remove/${room.room_no}" ><b> Remove </b></a>
     				 </p>
		     
		     
		
		  </div>
		  </div>
		  
	   	</c:forEach>
	   	</div>
		  </div>
			
			
			
			  <div>
		  <h2>Pending Bills</h2>
		  <c:forEach items="${pendingbills}" var="bill">

				<div class="column">
      
   				<div class="card">

		
		    <h4><b>Bill No: ${bill.bill_No}</b> </h4>
		    <p> Amount:  ${bill.price}</p>
		     <p> Corresponding Foodorder Num  : ${bill.order_No}  </p>
		        <p> Coupon ID(if used) : ${bill.coupan_ID}  </p>
		   
		     
		     
		
		  </div>
		  </div>
	   	</c:forEach>
		  </div>
		  
		  
		  
			
		 </c:if>
		 
		 </div>
	
  
  
  
	
			<div class="col-sm-3">
		
		  <form action="findbydate" method="get" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Booking by Date </h2></td>
                </tr>
                <tr>
                    <td> Date:</td>
                    <td><input path="date" name="date" type="date" required  /></td>
         
                <tr>
                    <td colspan="2" align="center"><input type="submit"  value="get bookings" /></td>
                </tr>
            </table>
           </form>	
           		  <form action="findbycust" method="get" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Booking by Customer ID </h2></td>
                </tr>
                <tr>
                    <td> Cust ID :</td>
                    <td><input path="cust_id" name="cust_id"  required /></td>
         
                <tr>
                    <td colspan="2" align="center"><input type="submit"  value="get bookings" /></td>
                </tr>
            </table>
           </form>		
           
           
               <form action="findbyRoomNo" method="get" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Booking by Room No</h2></td>
                </tr>
                <tr>
                    <td> Room No :</td>
                     <td><select path="room_id" name="room_id" >
                        <c:forEach items="${bookedroom}" var="room">
   
                    <option value="${room.room_no}"> ${room.room_no}</option>
                    </c:forEach>
                   
                   </select> 
                   
                <tr>
                    <td colspan="2" align="center"><input type="submit"  value="get bookings" /></td>
                </tr>
            </table>
           </form>		
                <form action="findbyID" method="get" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Booking by Booking ID</h2></td>
                </tr>
                <tr>
                    <td> Booking ID :</td>
                    <td><input path="booking_id" name="booking_id"  required /></td>
         
                <tr>
                    <td colspan="2" align="center"><input type="submit"  value="get bookings" /></td>
                </tr>
            </table>
           </form>	
           
      </div>
      </div>
           	
	</div>

		
	<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>		
		

</body>
</html>