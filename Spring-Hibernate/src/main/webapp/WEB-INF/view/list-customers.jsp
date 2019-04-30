<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customer List</title>
		
		<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"  type="text/css"/>
	</head>	
	
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM-Customer Relationship Management</h2>
			</div>
		</div>
		<div id="container">
							
			<div id="content">
			<input type="button" value="Add Customer" onclick="window.location.href='ShowAddForm'; return false;" class="add-button"/>
			   <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
				<table>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<!--Loop and print all Customers-->
					<c:forEach var="tempCustomers" items="${customers}">
					
					<!--construct an Update link with customer id-->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomers.id}"></c:param>
					</c:url>
					
					<!--construct a Delete link with customer id-->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomers.id}"></c:param>
					</c:url>
					
						<tr>
							<td>${tempCustomers.firstName} </td>
							<td>${tempCustomers.lastName}</td>
							<td>${tempCustomers.email}</td>
							<td><a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete ${tempCustomers.firstName} ?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</body>
</html>
