<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title> Dashboard</title>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

<h1 align="center" class="jumbotron"> Employee Dashboard</h1>
 <div align="center">
    <h1 class="display-4">UserName : ${user.username}</h1>
    </div>
 
 <a href="profile"><div class="card" ><h2>Profile</h2> </div></a>
  
<a href="room_s/duties"><div class="card" ><h2> Room Service Duties  </h2></div></a>        

<a href="room_invent/"><div class="card" ><h2> Inventory    !! </h2></div></a>
<a href="salary/"><div class="card" ><h2>Salary</h2> </div></a>

<a href="foodorders/"><div class="card" ><h2> Foodorders   </h2></div></a>

<div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>