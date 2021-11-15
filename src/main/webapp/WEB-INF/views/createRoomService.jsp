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

<h1  align="center"> Request Room Service here !!</h1>
<div align="center">

        <form:form action="" method="post" modelAttribute="roomservicedetail">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2> Please enter these details</h2></td>
                </tr>
                      <tr>
                    <td> Your Requirements:</td>
                    <td><form:input path="demands" /></td>
                </tr>
                 <tr>
                    <td> Room No:</td>
                    <td>
                    <form:select path="ROOM_ID" >
                        <c:forEach items="${roominfo}" var="room">
   
                    <form:option value="${room.ROOM_ID}"/>
                    </c:forEach>
                   
                   </form:select> 
                    
                    </td>
                  
                </tr>
                            
            
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
        <c:if test="${not empty response}">
        <h4>${response}</h4>
        </c:if>
    </div>
    <div id="footer">
    <jsp:include page="include/footer.jsp" />
</div>
</body>
</html>