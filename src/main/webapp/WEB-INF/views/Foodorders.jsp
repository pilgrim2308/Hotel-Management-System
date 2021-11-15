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

<div class="jumbotron">
<h2 align="center"> Food Order</h2>
 <hr>
<div class="jumbotron">
		  <form action="order_no" method="post" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Order details </h2></td>
                </tr>
                <tr>
                    <td>Order No:</td>
                    <td><input type="number" path="order_no" name="order_no" required /></td>
   
                
                <tr>
                    <td colspan="2" align="center"><input type="submit"value="find" /></td>
                    
                </tr>
            </table>
        </form>		
         <hr>
         <form action="bydate" method="post" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Order details </h2></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><input path="date" name="date" type="date" required /></td>
   
                
                <tr>
                    <td colspan="2" align="center"><input type="submit"value="find" /></td>
                    
                </tr>
            </table>
        </form>		
</div>
 <hr>
 
<h2 align="center">  Orders</h2>
		<c:forEach items="${orders}" var="food_order">
			<h2 align="center">Order No. ${food_order.order_No }</h2>
			<h4 align="center"> Current Status : ${food_order.status } </h4>
			
			<h4 align="center"> Room  : ${food_order.ROOM_ID } </h4>
				
			
			
				     <c:forEach items="${food_order.items}" var="item">
				     <c:set var="total"
				value="${total + item.price}"></c:set>
   				 <table align="center">
   				
			        <tr>
			            <th>ID: </th>
			            <td>${item.food_item_id}</td>
			              <th>Quantity : </th>
			            <td> ${item.quantity}</td>
			                <th> price : </th>
			            <td>${item.price} </td>
			        </tr>
			       
			    </table>
			
				</c:forEach>
				<h4 align="center"> Total Price: ${food_order.total_Price} (without gst)  <br> 
				<a href="${pageContext.request.contextPath }/employee/foodorders/${food_order.order_No}"> Complete</a> </h4>
				 <hr>
		</c:forEach>
	</div>	
	<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>