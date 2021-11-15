<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div class="container">

   				 <h1>Available Rooms</h1>
   		<div class="row">	
     <c:forEach items="${rooms}" var="room">
     	<div class="card">
   				 <table>
   				
			        <tr>
			            <th>Priv: </th>
			            <td><p >${room.priviledge_level}<p/></td>
			        </tr>
			        <tr>
			            <th>count: </th>
			            <td><p> ${room.total_count} <p/></td>
			        </tr>
			           <tr>
			            <th>Air conditioned: </th>
			            <td><p>${room.ac}</p></td>
			               <th> Room charges per day:</th>
			            <td><p>${room.price}</p></td>
			        </tr>
			    </table>
			     <img src="/Images/${room.photo_url }" />
  
			</div>
				</c:forEach>
	</div>	
</div>
<div class="container">	
	<div class="jumbotron">
	  <h2>Your rooms :)</h2>
	     <c:forEach items="${rooms_list}" var="room">
   				 <table>
   				
			        <tr>
			      
			            <th>Priv: </th>
			            <td><p >${room.priviledge_level}<p/></td>
			       
			            <th>count: </th>
			            <td><p> ${room.count} <p/></td>
			        </tr>
			    </table>
			  
				</c:forEach>
				</div>
			
	</div>
	<br>
	<div class="container">
	<c:if test="${not empty fullm}">
	<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                        <Strong>${fullm }</Strong>
   </div>
   </c:if>
	<div class="card">
	<form:form action="addroom" method="post" modelAttribute="roombook">
	<h2>Please add rooms here!!</h2>
            <table >
               <tr>
               
                    <td>priviledge_level:</td>
                    
                 <td>   <form:select path="priviledge_level" >
                      <c:forEach items="${rooms}" var="room">
   
                    <form:option path="priviledge_level" type="number" value="${room.priviledge_level}"/>
                    </c:forEach>
                    </form:select>
                    </td>
                 </tr>
               
                <tr>
                    <td>count::</td>
                    <td><form:input path="count" min="0" required="required" /></td>
                </tr>                     
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="add room"></input></td>
                </tr>
            </table>
    </form:form>
	
	</div>
	<div class="card">
	
	
	<form:form action="make" method="post" modelAttribute="bookdetail">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Please enter your booking details here!!</h2></td>
                </tr>
                <tr>
                    <td>No of members:</td>
                    <td><form:input path="no_of_members" type="number" /></td>
                </tr>
                <tr>
                    <td>Purpose of visit:</td>
                    <td><form:input path="purpose_of_visit" /></td>
                </tr>
                        
                <tr>
                    <td colspan="2" align="center"><input type="submit"  /></td>
                </tr>
            </table>
        </form:form>
        </div>
        </div>
        <div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>

</html>