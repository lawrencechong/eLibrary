<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="../layout/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<!-- Semantic UI CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<!-- Semantic UI JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="<c:url value="/resources/js/script.js" />"> </script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>

	<tilesx:useAttribute name="current" />

	<div class="container"> <div class="navbar navbar-default" role="navigation"> </div> </div>



	<div class="ui top fixed blue menu">
		<a class="item" href="/"> <img src="<c:url value='/resources/images/icon.png'/>" alt="icon"
	height="35" width="35"></a> 
			
		<a class="item" href="/admin/users">Users</a>
		<a class="item" href="/admin/books">Books</a>	


			<div class="right menu">
			
			<!-- Display either user's name or register/login buttons -->

			<a class="item"><i id="notif-icon" class="alarm outline icon"></i></a>


			<security:authorize access="isAuthenticated()">
				<div class="ui dropdown item">
					<img class="ui avatar image"
						src="https://signup.na.leagueoflegends.com/theme/signup_new_theme/img/logo-lol-smaller.png"> Signed in as: ${currentUser.name} <i
						class="dropdown icon"></i>
					<div class="dropdown-menu">
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<a class="item" href="<spring:url value="/admin" />">Admin Dashboard</a>
						</security:authorize>
						<a class="item" href="<spring:url value="/account" />">My Account</a> 
						<a class="item" href="<spring:url value="/logout" />">Logout</a>
					</div>
				</div>
			</security:authorize>

		</div>
	</div>



	<tiles:insertAttribute name="body" />

	<br>
	<br>

	<center>
		<tiles:insertAttribute name="footer" />
	</center>
</body>
</html>