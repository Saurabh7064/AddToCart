 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<center>

		<div style="color: teal; font-size: 30px">Hibernate list</div>

		<c:if test="${!empty hibernateDTO}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					
					<td>First Name</td>
					 
				</tr>
				<c:forEach items="${hibernateDTO}" var="user">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						
						<td><c:out value="${user.name}" />
						</td>
						 
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<a href="form">Click Here to add new User</a>
	</center>
