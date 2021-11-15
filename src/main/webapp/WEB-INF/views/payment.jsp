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

<h1 align="center" > Payment </h1>
<div align="center">
<c:if test="${not empty message}">
<h2> ${message}</h2>
</c:if>

<c:if test="${not empty matter}">
<h2>${matter}</h2>
</c:if>
<div class="jumbotron">
<h1>Available coupons</h1>
<div class="row">
   <c:forEach items="${coupons}" var="coupon">
   				
   	<div class="column">
   				<div class="card">

		
		    <h4><b>name   : ${coupon.name}</b></h4>
		    <p> Description : ${coupon.description }</p>
		    <p> Discount : ${coupon.discount_amount }</p>
		    
		    <p> Expire Date : ${coupon.expire_Date }</p>
		    
		   <a href="${pageContext.request.contextPath }/customer/${page_type}/applycoupon/${coupon.coupan_ID}">Apply</a>
	
		   
		
		  </div>	
   				
   			</div>	
	</c:forEach>

</div>
</div>

<div class="jumbotron">

<h4> Total Price : ${total_price}</h4>
        <form action="generate_invoice" method="post">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Payment Page</h2></td>
                </tr>
                <tr>
                    <td>Card No:</td>
                    <td><input path="card_no" required="required" /></td>
                </tr>
                   <tr>
                    <td>CVV:</td>
                    <td><input path="cvv" required="required" type="text" name="cvv" pattern="[0-9]{3}" maxlength="3"/></td>
                </tr>
                <tr>
                    <td>pin:</td>
                      <td><input path="pin" required="required" min="0" type="text" name="pin" pattern="[0-9]{4}" maxlength="4"/></td>
                    <td><password path="password" /></td>
                    
                    
                     <input type="hidden" value="${total_price}">
                </tr>
               
            
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="pay" /></td>
                </tr>
            </table>
        </form>
        </div>
    </div>
    <div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>