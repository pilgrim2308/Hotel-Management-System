<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title> Hotel Landmark</title>
<style>
.alert {
  opacity: 1;
  transition: opacity 0.6s; /* 600ms to fade out */
}
</style>

<script>
// Get all elements with class="closebtn"
var close = document.getElementsByClassName("closebtn");
var i;

// Loop through all close buttons
for (i = 0; i < close.length; i++) {
  // When someone clicks on a close button
  close[i].onclick = function(){

    // Get the parent of <span class="closebtn"> (<div class="alert">)
    var div = this.parentElement;

    // Set the opacity of div to 0 (transparent)
    div.style.opacity = "0";

    // Hide the div after 600ms (the same amount of milliseconds it takes to fade out)
    setTimeout(function(){ div.style.display = "none"; }, 600);
  }
}
</script>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

<h1 align="center"> Admin Dashboard</h1>

 <div align="center" class="jumbotron">
    <h1>UserName : ${user.username}</h1>
    </div>
  <div  class="jumbotron">

  
<a href="profile"><div class="card"><h2> Profile  </h2></div> </a>  
<a href="registeremployee"> <div class="card"><h2> Add new Employee  </h2> </div></a>        
<a href="employee_info"> <div class="card"> <h2> all employee info !! </h2> </div></a>    
<a href="room_s/"> <div class="card"><h2> Room Service board !! </h2> </div></a>
<a href="booking/"><div class="card"> <h2> Bookings board !! </h2> </div></a>

<a href="room_invent/"><div class="card"><h2> Inventory    !! </h2></div></a>

<a href="/employee/"><div class="card"><h2> Employee Dashboard   !! </h2></div></a>
</div>
 <div class="jumbotron" align="center">
	 
	    <form:form action="salary/" method="post" modelAttribute="salarypayment">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2 align="center">Salary Payment</h2></td>
                </tr>
         
                 <tr>
                    <td>employee ID :</td>
                    <td><form:select path="customer_id" >
                        <c:forEach items="${emps}" var="emp">
   
                    <form:option value="${emp.employee_id}"/>
                    </c:forEach>
                   
                   </form:select> 
                    
                    </td>
                  
                </tr>
              
                
                <tr>
                     <td>Amount :</td>
                     <td><form:input path="amount" type="number" min="0" /></td>
                     
                </tr>
                 
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>

	</div>
	
	
	 <div class="jumbotron" align="center">
	 <c:if test="${not empty message}">
	<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                        <Strong>${message }</Strong>
   </div>
   </c:if>
	 
	    <form action="custprofile" method="get" >
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2 align="center">Customer profile</h2></td>
                </tr>
        
              
                
                <tr>
                     <td>customer ID :</td>
                     <td><input path="cust" name="cust" type="text" required/></td>
                     
                </tr>
                 
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>

	</div>
	
	

  <div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>