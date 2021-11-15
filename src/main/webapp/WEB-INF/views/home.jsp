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

<div class="jumbotron"><h1 align="center">Welcome to Hotel Landmark</h1></div>

<div class="jumbotron dark">
<h2 align="center"> About us</h2>
<p align="center">Landmark Hotel is a 3-star hotel in saharanpur with various fine quality services. 
It is situated at a distance of less than 500 meters from both railway station and the bus stand and . 
It has a wide range of rooms , halls and a fine dine restaurant . 
It is known for it’s quality environment and awesome food.
 This hotel opened recently and is planning to bring much more facilities for its customers and staff. </p>
 
 <!-- Jumbotron -->
<div class="jumbotron" align="center">
<hr>
  <img src="/Images/landmark.jpeg" />

  <img src="/Images/landmarkrec.jpeg" />
  <hr>
  </div>

</div>
<!-- Jumbotron -->
 
 </div>

<div class="jumbotron">
<h2 align="center"> Feedbacks</h2>
<div class="overflow-auto">
   <c:forEach items="${feedbacks}" var="feedback">
   				
   	
   				<div class="card">

		
		    <h4><b>User   : ${feedback.cust_ID}</b></h4>
		    
		    <p>Service Rating :  ${feedback.service_Rating }  Rating</p>
		    
		    <p>Hotel Rating :  ${feedback.hotel_Rating }  Rating</p>
		    <p>Comment ::    ${feedback.comments}</p>
		   
		
		  </div>	
   				
   				
	</c:forEach>

</div>
</div>
<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>