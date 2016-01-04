<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>

</head>
<body>

	<div class="container">


		<!-- Static navbar -->
		<div class="navbar navbar-inverse" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/" />">ADDTOKART</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' : ''}"><a
							href='<spring:url value="/" />'>Home</a></li>
						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'UserRegistration' ? 'active' : ''}"><a
								href="registerform"><span class="glyphicon glyphicon-th"></span>Register</a></li>
							<li class="${current == 'login' ? 'active' : ''}"><a
								href="login"><span class="glyphicon glyphicon-th"></span>Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'UsersList' ? 'active' : ''}"><a
								href="listusers"><span class="glyphicon glyphicon-user"></span>Users
									List</a></li>
									<li class="${current == 'products' ? 'active' : ''}"><a
								href="productlist"><span class="glyphicon glyphicon-user"></span>products</a></li>
							<li><a href="<spring:url value="logout" />">Logout</a></li>
						</security:authorize>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>


		<tiles:insertAttribute name="body" />

		<br> <br>

		<tiles:insertAttribute name="footer" />


	</div>

</body>
</html>