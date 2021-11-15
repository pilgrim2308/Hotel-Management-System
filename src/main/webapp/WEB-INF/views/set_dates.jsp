<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function validateForm() {
	  var x = document.forms["myForm"]["start_date"].value;

	  var y = document.forms["myForm"]["end_date"].value;
	  if (x >=y) {
	    alert("end date must be greater than start date");
	    return false;
	  }
	}
</script>
</head>
<body>
<div id="header">
    <jsp:include page="include/header.jsp" />
</div>

<div align="center">

        <form:form  name="myForm" action="set_dates" method="post" modelAttribute="bookdetail"  onsubmit="return validateForm()">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Please Enter the required dates</h2></td>
                </tr>
              
                 <tr>
                    <td>Start date:</td>
                    <td><form:input type="date" name="start_date" path="start_date" id="startdate" min="${today}" required="required"/></td>
                </tr>
               
             
                 <tr>
                    <td>end date:</td>
                    <td><form:input type="date" name ="end_date" path="end_date" id="enddate"  min="${today}" required="required"/></td>
                </tr>
               
               
            
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>