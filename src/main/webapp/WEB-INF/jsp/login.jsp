<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<div id="auth-container" class="ui form"
	style="margin-left: 125px; margin-top: 85px; margin-right: 200px">
	<h4 class="ui dividing header">Log In</h4>

	<div class="ui form segment" id="auth">

		<form class="form-signin" role="form"
			action="<spring:url value="/j_spring_security_check" />"
			method="POST">
			
			<div class="field">
				<label>Email</label>
				<div class="ui left icon input">
					<i class="user icon"></i> <input type="text" name="j_username"
						class="form-control" placeholder="Email" required autofocus>
				</div>
			</div>

			<div class="field">
				<label>Password</label>
				<div class="ui left icon input">
					<i class="lock icon"></i> <input type="password" name="j_password"
						class="form-control" placeholder="Password" required>
				</div>
			</div>

			<button class="ui primary submit button" type="submit">Sign In</button>
		</form>
	</div>

	<div id="login-error">
		<div class="ui small error message">
			<div class="header">Your credentials could not be verified.</div>
		</div>
	</div>
</div>