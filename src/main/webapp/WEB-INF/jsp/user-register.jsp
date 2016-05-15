<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<form:form commandName="user" cssClass="form-horizontal registrationForm">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful!</div>
	</c:if>
	
	<div class="ui form" style="margin-left: 125px; margin-top: 85px; margin-right: 200px">
		<h4 class="ui dividing header">Register</h4>
		<div class="ui form segment">
		<div class="field">
			<div class="two fields">
				<div class="field">
					<label> First Name</label> 
					<form:input path="firstName"  />
					<form:errors path="firstName" />
				</div>
				<div class="field">
					<label> Last Name</label>
					<form:input path="lastName"  />
					<form:errors path="lastName" />
				</div>
			</div>
		</div>
		<div class="field">
			<label>Email Address</label>
			<form:input path="name"  />
			<form:errors path="name" />
		</div>

		<div class="field">
			<label>Password</label>
			<form:password path="password" />
			<form:errors path="password" />
		</div>
		
		<div class="field">
			<label>Password again:</label>
			<input type="password" name="password_again" id="password_again"  />
		</div>

		<input type="submit" value="Save">
		
	</div>
	</div>
</form:form>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".registrationForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3,
					remote : {
						url: "<spring:url value='/register/available.html' />",
						type: "get",
						data: {
							username: function() {
								return $("#name").val();
							}
						}
					}
				},
				email: {
					required : true,
					email: true
				},
				password: {
					required : true,
					minlength : 5
				},
				password_again: {
					required : true,
					minlength : 5,
					equalTo: "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				name: {
					remote: "Such username already exists!"
				}
			}
		}
	);
});
</script> 


