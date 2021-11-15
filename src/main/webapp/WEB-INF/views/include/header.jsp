<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Hotel Landmark</title>


 <link rel="stylesheet" href="/css/style.css" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
<body class="d-flex flex-column min-vh-100">


<nav class="navbar navbar-inverse navbar-dark bg-dark">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Hotel Landmark</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>

    </ul>
    <sec:authorize var="loggedIn" access="isAuthenticated()" />
<c:choose>
    <c:when test="${loggedIn}">
    
    <button class="btn btn-primary navbar-btn"  onclick="window.location.href='/welcome';">Dashboard</button>
      
    <button class="btn btn-danger navbar-btn"  onclick="window.location.href='/logout';">Logout</button>
    </c:when>
    <c:otherwise>
      
    <button class="btn  btn-primary navbar-btn"  onclick="window.location.href='/register';">Register</button>
    
    <button class="btn  btn-primary navbar-btn"  onclick="window.location.href='/login';">Login</button>
    </c:otherwise>
</c:choose>
   
  </div>
</nav>


</body>
</html>


</body>
</html>