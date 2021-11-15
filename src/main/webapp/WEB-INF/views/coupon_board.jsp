<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title> Landmark Hotel</title>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

<div class="jumbotron"><h1>Coupon Store</h1>

<form:form action="/admin/coupon/add" method="post" modelAttribute="coupon">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Create Coupon !!</h2></td>
                </tr>
                <tr>
                    <td>Name :</td>
                    <td><form:input path="Name" required="required" /></td>
                </tr>
                <tr>
                    <td>Description::</td>
                    <td><form:input path="Description" required="required" /></td>
                </tr>  
                   <tr>
                    <td>Amount :</td>
                    <td><form:input path="Discount_amount" equired="required" type="number" min="0" /></td>
                </tr>
                <tr>
                    <td>Expiry ::</td>
                    <td><form:input path="Expire_Date" equired="required"  type="date" min="${today }"/></td>
                </tr>     
                  <tr>
                    <td>Customer ID (if required) ::</td>
                    <td><form:input path="Cust_ID" /></td>
                </tr>                     
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="add room"></input></td>
                </tr>
            </table>
    </form:form>
</div>
<div class="jumbotron">
<h2 align="center"> Coupons</h2>

<div class="row">
   <c:forEach items="${coupons}" var="coupon">
   				
   	<div class="column">
   				<div class="card">

		
		    <h4><b>name   : ${coupon.name}</b></h4>
		    <p> Description : ${coupon.description }</p>
		    <p> Discount : ${coupon.discount_amount }</p>
		    
		    <p> Expire Date : ${coupon.expire_Date }</p>
	
		   
		
		  </div>	
   				
   			</div>	
	</c:forEach>

</div>
</div>

<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>