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


	 <h1> Foody place</h1>
	 	 <h3 align="center"> Foody Menu</h3>
   				<div class="row">
     <c:forEach items="${products}" var="product">
     <div class="column">
   				<div class="card">

		
		    <h4><b>${product.name}</b></h4>
		    <p>${product.description}</p>
		     <p>Price: ${product.price}  <a href="${pageContext.request.contextPath }/customer/foodorder/add/${product.food_item_id}&${product.price}">Add</a> 
							<a href="${pageContext.request.contextPath }/customer/foodorder/remove/${product.food_item_id}">Remove</a>  </p>
		
		  </div>
		</div>
		
				
			    
				</c:forEach>
				
				
					</div>  
			
			<c:if test="${not empty food_order_list }">
			<h2 align="center">Your Order</h2>
					<c:set var="total" value="0"></c:set>
			
			
				     <c:forEach items="${food_order_list}" var="item">
				     <c:set var="total"
				value="${total + item.price}"></c:set>
   				 <table>
   				
			        <tr>
			            <th>ID: </th>
			            <td><p >${item.food_item_id}<p/></td>
			              <th>Quantity : </th>
			            <td><p> ${item.quantity} <p/></td>
			                <th> price : </th>
			            <td><p> ${item.price} <p/></td>
			        </tr>
			        <hr>
			    </table>
			
				</c:forEach>
				<h4 align="center"> Total Price: ${total} (without gst)</h4>
			
			<c:if test="${not empty message}">
			<h2 align="center" style="color=red;">${message }</h2>
			</c:if>	
		
		  <form action="createorder" method="post" >
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Order details </h2></td>
                </tr>
             <tr>
                    <td> Room No:</td>
              
                    <td><select path="room_id" name="room_id" required>
                        <c:forEach items="${roominfo}" var="room">
   
                    <option value="${room.ROOM_ID}">  ${room.ROOM_ID}  </option>
                    </c:forEach>
                   
                   </select> 
                    
                    </td>
                  
                </tr>
                 
                <input  type="hidden" path="total" name="total" value="${total}"  /></td>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" name="pay" path="pay" value="pay_now" /></td>
                    
                    <td colspan="2" align="center"><input type="submit" name="pay" path="pay" value="pay_later" /></td>
                </tr>
            </table>
        </form>		
			</c:if>	
		
			
		<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>