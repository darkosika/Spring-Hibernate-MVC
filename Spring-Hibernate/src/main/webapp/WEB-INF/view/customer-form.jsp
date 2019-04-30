<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<body>



<div id=wrapper>

 <div id="header">
     <h2>UPDATE CUSTOMER</h2>
 </div>
  
 <div id="container">
 <form:form action="SaveCustomer" modelAttribute="customer" method="POST">
  	<!-- This part important otherwise id can not taken -->
  	<form:hidden path="id" />
  	
	<table>
		<tbody>
		  <tr>
		  <td><label>FirstName:</label></td>
		  <td><form:input path="firstName"/></td> 
		  </tr>
		  <tr>
		  <td><label>LastName:</label></td>
		  <td><form:input path="lastName"/></td> 
		  </tr>
		  <tr>
		  <td><label>Email:</label></td>
		  <td><form:input path="email"/></td> 
		  </tr>
		  <tr>
		  <td><label></label></td>
		  <td><input type="submit" value="Save"/></td> 
		  </tr>
		</tbody>
	</table>

 </form:form>
 </div>
 
</div>


</body>
</html>
