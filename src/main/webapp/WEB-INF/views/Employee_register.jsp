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

<h1 align="center">Employee registration page</h1>
<div align="center">
<c:if test="${not empty message}">
<h2> ${message}</h2>
</c:if>

<c:if test="${not empty matter}">
<h2> ${matter}</h2>
</c:if>
        <form:form action="registeremployee" method="post" modelAttribute="employeedetail">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Registration Details</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="employee_id" required="required" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" required="required" /></td>
                </tr>
                  <tr>
                    <td>First Name:</td>
                    <td><form:input path="first_name" required="required" /></td>
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
                    <td>gender:</td>
                    <td>
                          Male <form:radiobutton path="gender" value="Male"/>  
      					  Female <form:radiobutton path="gender" value="Female"/>  
               		</td>
                </tr>
                 <tr>
                    <td>Role :</td>
                    <td>
                          Employee<form:radiobutton path="role" value="employee"/>  
      					  Admin <form:radiobutton path="role" value="admin"/>  
               		</td>
                </tr>
               
                 <tr>
                    <td>street:</td>
                    <td><form:input path="street" required="required" /></td>
                </tr>
               
                 <tr>
                    <td>city:</td>
                    <td><form:input path="city" required="required" /></td>
                </tr>
               
                 <tr>
                    <td>Pincode:</td>
                    <td><form:input type="number" path="pincode" required="required" min="0"/></td>
                </tr>
                 <tr>
                    <td>Date of Birth:</td>
                    <td><form:input type="date" path="DOB" required="required" /></td>
                </tr>
               
               
            
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register Employee" /></td>
                </tr>
            </table>
        </form:form>
    </div>
   
</body>
</html>