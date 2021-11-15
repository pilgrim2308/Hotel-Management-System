<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib prefix = "fmt"
uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
      crossorigin="anonymous"
    />
    <!-- jQuery and JS bundle w/ Popper.js -->
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
      crossorigin="anonymous"
    ></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <script>
      $.fn.hasAttr = function (name) {
        return this.attr(name) !== undefined;
      };
      $(document).ready(function () {
        $(".toggle_edit").click(function (e) {
          e.preventDefault();
          if ($(this).prev().hasAttr("disabled")) {
            $(this).prev().removeAttr("disabled");
            $(this).html("Disable Edit");
          } else {
            $(this).prev().attr("disabled", "disabled");
            $(this).html("Enable Edit");
          }
        });
      });
    </script>

    <title>Personal Profile</title>
  </head>

  <body>

     
<nav class="navbar navbar-inverse navbar-dark bg-dark">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hotel Landmark</a>
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

    <div class="container">

      <h2>Edit Personal Details.</h2>

      <div class="container">
        <div class="row">


          <div class="col card p-4 m-1">
            <h3>Current Address</h3>

            <form action="profile" method="post" name="profile" >
            <fieldset disabled>
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                  readonly
                />
               
        

                <div class="form-group">
                
                  <label for="first_name"> first name </label>
                   <input
               
                  type="text"
                  value="${profile.first_name}"
                  readonly
                  id="first_name"
                  name="first_name"
                />
                </div>
                
                <div class="form-group">
                  <label for="last_name"> Last Name </label>
                  <input
              
                  type="text"
                  value="${profile.last_name}"
                  readonly
                  id="last_name"
                  name="last_name"
                />
</div>
                <div class="form-group">
                  <label for="DOB"> DOB </label>
                <input
                  value="${profile.DOB}"
                  readonly
                  id="DOB"
                  name="DOB"
                  type="date"
                />
                </div>
                <div class="form-group">
                  <label for="house_no"> house_no </label>
                  <input
                    id="house_no"
                    name="house_no"
                    class="form-control"
                    type="text"
                    value="${profile.house_no}"
                  />
                </div>
                <div class="form-group">
                  <label for="street"> Street </label>
                  <input
                    id="street"
                    name="street"
                    class="form-control"
                    type="text"
                    value="${profile.street}"
                  />
                </div>
                <div class="form-group">
                  <label for="Pincode"> Pincode </label>
                  <input
                    id="Pincode"
                    name="Pincode"
                    class="form-control"
                    type="number"
                    value="${profile.pincode}"
                  />
                </div>
                <div class="form-group">
                  <label for="city"> city </label>
                  <input
                    id="city"
                    name="city"
                    class="form-control"
                    type="text"
                    value="${profile.city}"
                  />
                </div>
               
             <c:if test="${empty foreign}">
                <button type="submit" class="btn btn-primary">Update</button>
                </c:if>
              </fieldset>
              
             <c:if test="${empty foreign}">
              <button class="my-3 btn btn-danger toggle_edit">
                Enable Edit
              </button>
              </c:if>
            </form>
          </div>
          
      </div>
      
               
             <c:if test="${empty foreign}">
      <div class="row">
         <div class="col card p-4 m-1">
            <h3> Add Phonenumber</h3>

          <form action="profile/addnum" method="post"  >
       
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                  readonly
                />
               
               <div class="form-group">
                
                  <label for="number"> Phone Number </label>
                   <input
                 path="number"
                  type="text"
           		pattern="[0-9]{10}"
              
                  id="number"
                  name="number"
                />
             </div>
             
                <button type="submit" class="btn btn-primary">add</button>
        
            </form>
          </div>
            <div class="col card p-4 m-1">
            <h3> Add Email</h3>

          <form action="profile/addemail" method="post"  >
       
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                  readonly
                />
               
               <div class="form-group">
                
                  <label for="number">  Email </label>
                   <input
                 path="email"
                  type="email"
                  
                  id="email"
                  name="email"
                />
             
               </div>
             
                <button type="submit" class="btn btn-primary">add</button>
       
            </form>
        
          </div>
        
        </div>
          </c:if>
       <div class="container">
       <h2 align="center"> Phone Numbers</h2>
       
        <div class="row">
     <c:forEach items="${nums}" var="num">
     <div class="column">
   		<div class="card">

		
		    <h6><b>Phone Number :</b>   ${num.phone_No} </h6>
		   <form action="profile/removenum" method="post"  >
       
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                  readonly
                />
               
               <div class="form-group">
                
                   <input
                   hidden
                   path="number"
                   type="number"
                   value="${num.phone_No}"
             		  id="number"
                  name="number"
                />
             
               </div>
               
             <c:if test="${empty foreign}">
             
                <button type="submit" class="btn btn-primary">Remove</button>
          </c:if>
            </form>
		    
		 </div>
		</div>
		
				
			    
				</c:forEach>
				
				
				</div>  
				</div>
				
				<div class="container">
				
       <h2 align="center">  Emails</h2>
   <div class="row">
		        
     <c:forEach items="${emails}" var="email">
     <div class="column">
   				<div class="card">

		
		    <h6><b>Email :</b>   ${email.email}</h6>
		   <form action="profile/removeemail" method="post"  >
       
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                  readonly
                />
               
               <div class="form-group">
                
                   <input
                   hidden
                   path="email"
                   type="email"
                   value="${email.email}"
             		  id="email"
                  name="email"
                />
             
               </div>
              
             <c:if test="${empty foreign}">
             
                <button type="submit" class="btn btn-primary">Remove</button>
          </c:if>
            </form>
		    
		    
		 
		  </div>
		</div>
		
				
			    
				</c:forEach>
				
				
				</div>  
				</div>
	<div class="container">
				
	<div class="row">
      <div class="col card p-4 m-1">
            <h3> Bank Detail</h3>

            <form action="profile/bankdetail" method="post" name="bankdetail" >
            <fieldset disabled>
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                  readonly
                />
                    
            
        

                <div class="form-group">
                
                  <label for="Bank_Name"> Bank Name </label>
                   <input
               
                  type="text"
                  value="${bankdetail.bank_Name}"
          
                  id="Bank_Name"
                  name="Bank_Name"
                  required
                />
                <input
               
                  type="hidden"
                  value="${bankdetail.bank_id}"
                  readonly
                  id="Bank_id"
                  name="Bank_id"
                />
              </div>
                
                <div class="form-group">
                  <label for="Account_Number"> Account_Number  </label>
                  <input
              
                  type="text"
                  value="${bankdetail.account_Number}"
               
                  id="Account_Number"
                  name="Account_Number"
                  required
                />
               </div>
                <div class="form-group">
                  <label for="ISFC_Code"> ISFC_Code </label>
                <input
                  type="text"
                  value="${bankdetail.IFSC_Code}"
                
                  id="IFSC_Code"
                  name="IFSC_Code"
                  required
            
                />
           </div>
        
             
             <c:if test="${empty foreign}">
                <button type="submit" class="btn btn-primary">Update</button>
                  </c:if>
              </fieldset>
              
             <c:if test="${empty foreign}">
              <button class="my-3 btn btn-danger toggle_edit">
                Enable Edit
              </button>
              </c:if>
           
            </form>
  	
				</div>
	</div>
				
	</div>
		
        
        
      </div>
    </div>

  

    <c:if test="${not empty response}">
      <script>
        swal("${ response }");
      </script>
    </c:if>
    
  </body>
</html>