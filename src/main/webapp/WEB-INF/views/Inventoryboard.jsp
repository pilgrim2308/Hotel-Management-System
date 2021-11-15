<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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

	 	 <h3 align="center"> Inventory Board</h3>
	 	 
					
					<c:if test="${not empty message }">
					<h3>${message}</h3>
	 	 </c:if>
	 	 
			
			
	<div class="jumbotron">
					 <form:form action="addproduct" method="post"  modelAttribute="product">
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> add product details </h2></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" required="required" /></td>
                       <td>Desc:</td>
                    <td><form:input path="description" required="required"  /></td>
                       <td>price:</td>
                    <td><form:input path="price" type="number" required="required" /></td>
                      
                       <td>quantity:</td>
                    <td><form:input path="quantity" type="number" required="required" /></td>
                    <tr>
                        <td>current incharge:</td>
                    <td><form:input path="current_incharge"  /></td>
                    </tr>
                   <tr>
                   
                 
          
                    <td colspan="2" align="center"><input type="submit" value="submit" /></td>
                    
                </tr>
            </table>
        </form:form>		
					</div>

	 	 
	 	 
	 	 
	 	 
   				<div class="row">
   				<h1 align="center">	Inventory Products</h1>
 <c:forEach items="${items}" var="item">
     <div class="column">
   				<div class="card">

		  <p>ID :${  item.product_ID}</p>
		    <h4><b>${item.name}</b></h4>
		    <p>Desc:${ item.description}</p>
		    <p> Quantity : ${item.quantity }</p>
		    
		     <p>Price: ${item.price}  <a href="${pageContext.request.contextPath }/employee/room_invent/inc/${item.product_ID}"> <i class="fa fa-plus"></i></a> 
							<a href="${pageContext.request.contextPath }/employee/room_invent/dec/${item.product_ID}"> <i class="fa fa-minus"></i> </a>  </p>
							
							
							<sec:authorize access="hasRole('admin')">


							<a href="${pageContext.request.contextPath }/employee/room_invent/remove/${item.product_ID}"> Remove Product </a> 
							</sec:authorize>
		
		  </div>
		</div>
</c:forEach>
				
				
				
				
				
					</div>  
					
					<div class="jumbotron">
					 <form action="getbyroom" method="post" >
           
           
            <table border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><h2> Room details </h2></td>
                </tr>
                <tr>
                    <td>Room No:</td>
                    <td><input path="room_id" name="room_id"  /></td>
                 
          
                    <td colspan="2" align="center"><input type="submit" value="submit" /></td>
                    
                </tr>
            </table>
        </form>		
					</div>
					<div>
					
					
					<c:if test="${not empty roomno }">
					
   				<h3 align="center"> Room NO ::: ${roomno }</h3>
				<div class="row">
     <c:forEach items="${room_items}" var="item">
     <div class="column">
   				<div class="card">

		
		    <h4><b>${item.product_ID}</b></h4>
		    <p>${item.quantity}</p>
		     <p> <a href="${pageContext.request.contextPath }/employee/room_invent/inc_rmi/${item.product_ID}">Add</a> 
				 <a href="${pageContext.request.contextPath }/employee/room_invent/dec_rmi/${item.product_ID}">Remove</a>  </p>
		
		  </div>
		</div>
		
				
			    
				</c:forEach>
				
				
				
				
					</div>  
					
					</c:if>
					
					
					</div>
					<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>