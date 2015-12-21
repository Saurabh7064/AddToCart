 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 
	<center>

		<div style="color: teal; font-size: 30px">Hibernate | Registration Form</div>



 		<form:form id="registerForm" modelAttribute="hibernateDTO" method="post"
			action="register">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				 <tr>
					<td></td>
					<td><input type="submit" value="Register" />
					</td>
				</tr>
			</table>
		</form:form>


		<a href="list">Click Here to see User List</a>
	</center>
 
 
