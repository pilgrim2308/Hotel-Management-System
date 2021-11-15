<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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

<h1 align="center"> Customer Dashboard</h1>
 <div align="center" class="jumbotron" >
    <h1 class="display-4">UserName : ${user.username}</h1>
    </div>
 <div class="jumbotron">
 
<a href="profile"><div class="card" ><h2> Profile </h2> </div></a>
 
<a href="booking/"><div class="card" ><h2> Book Your Stay here!! </h2></div></a>

<a href="bookinghistory"> <div class="card" > <h2> Booking History!! </h2></div></a>

<a href="room_s/create/"> <div class="card" ><h2> Create Room Service Request!! </h2></div></a>
<a href="foodorder/"> <div class="card" ><h2> Foody Area!! </h2></div></a>


</div>
	
		
		
		
		<c:if test="${not empty message }">
					<h3>${message}</h3>
	 	 </c:if>
	 	 
	 	 
	 	 
	 	 <div class="container">
	 <div class="jumbotron" align="center">
	 <div class="card">
	    <form:form action="add_feedback" method="post" modelAttribute="feedback_detail">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2 align="center">Feedback Form</h2></td>
                </tr>
         
                 <tr>
                    <td>Booking ID :</td>
                    <td><form:input path="Booking_ID" /></td>
                </tr>
              
                  <tr>
                    <td>Service Rating:</td>
                    <td>
                          1  <form:radiobutton path="Service_Rating" value="1"/> 
                          2  <form:radiobutton path="Service_Rating" value="2"/>  
                          3  <form:radiobutton path="Service_Rating" value="3"/>  
                          4  <form:radiobutton path="Service_Rating" value="4"/>  
                          5  <form:radiobutton path="Service_Rating" value="5"/>  
               		</td>
                </tr>
                <tr>
                     <td>Hotel Rating:</td>
                    <td>
                          1  <form:radiobutton path="Hotel_Rating" value="1"/> 
                          2  <form:radiobutton path="Hotel_Rating" value="2"/>  
                          3  <form:radiobutton path="Hotel_Rating" value="3"/>  
                          4  <form:radiobutton path="Hotel_Rating" value="4"/>  
                          5  <form:radiobutton path="Hotel_Rating" value="5"/>  
               		</td>
                </tr>
                    <tr>
                    <td>Comment :</td>
                    <td><form:input type="text" path="Comments" /></td>
                </tr>
            
                 
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
</div>
	</div>
	</div>

<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>

</body>
</html>