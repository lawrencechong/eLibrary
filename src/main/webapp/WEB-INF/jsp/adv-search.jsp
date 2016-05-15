<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>


<div id="auth-container" class="ui form"
	style="margin-left: 125px; margin-top: 85px; margin-right: 200px">
	<h4 class="ui dividing header">Advanced Book Search Form</h4>

	<div class="ui form segment" id="auth">

		<form class="form-signin" role="form"
			action="<spring:url value="/adv_search" />" method="GET">

			<div class="field">
				<input type="text" name="title" class="form-control"
					placeholder="Title" required autofocus>
			</div>

			<div class="field">
				<input type="text" name="author" class="form-control"
					placeholder="Author">
			</div>

			<div class="field">
				<input type="text" name="genre" class="form-control"
					placeholder="Genre">
			</div>

			<div class="field">
				<input type="text" name="publisher" class="form-control"
					placeholder="Publisher">
			</div>

			<div class="field">
				<input type="text" name="isbn" class="form-control"
					placeholder="ISBN">
			</div>


			<button class="ui primary submit button" type="submit">Search</button>
		</form>
	</div>

	<div id="login-error">
		<div class="ui small error message">
			<div class="header">Your credentials could not be verified.</div>
		</div>
	</div>
</div>