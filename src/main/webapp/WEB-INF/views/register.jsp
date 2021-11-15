<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="/css/style.css" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="d-flex flex-column min-vh-100">


<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

<div align="center" style="height:100%;">
<c:if test="${not empty message}">
<h2> ${message}</h2>
</c:if>

<c:if test="${not empty matter}">
<h2> ${matter}</h2>
</c:if>
        <form:form action="register" method="post" modelAttribute="User" name="myForm"  >
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2> Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="Cust_ID" required="required"  /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" required="required" /></td>
                </tr>
                  <tr>
                    <td>First Name:</td>
                    <td><form:input path="first_name" required="required"  /></td>
                </tr>
               
                 <tr>
                    <td>Last_name:</td>
                    <td><form:input path="last_name" required="required" /></td>
                </tr>
                  <tr>
                    <td>House no.:</td>
                    <td><form:input path="house_no" required="required" /></td>
                </tr>
               
               
                 <tr>
                    <td>street:</td>
                    <td><form:input path="Street" required="required" /></td>
                </tr>
               
                 <tr>
                    <td>city:</td>
                    <td><form:input path="city" required="required" id="city" name="city"/></td>
                </tr>
               
                 <tr>
                    <td>Pincode:</td>
                    <td><form:input type="text" path="Pincode" required="required" name="zip" id="zip" pattern="[0-9]{6}"/></td>
                </tr>
                 <tr>
                    <td>Date of Birth:</td>
                    <td><form:input type="date" path="DOB" required="required" /></td>
                </tr>
               
               
            
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
   
</body>
</html>