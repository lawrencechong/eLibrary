<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp" %>


<form:form commandName="book" enctype="multipart/form-data"
	cssClass="form-horizontal registrationForm">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful!</div>
	</c:if>
	
	<div class="ui form" style="margin-left: 125px; margin-top: 85px; margin-right: 200px">
		<h4 class="ui dividing header">New Book</h4>
		<div class="ui form segment">

		
		<div class="field">
			<label>Title</label>
			<form:input path="title"  />
			<form:errors path="title" />
		</div>
		
		<div class="field">
			<label>Author(s)</label>
			<form:input path="authors"  />
			<form:errors path="authors" />
		</div>
		
		<div class="field">
			<label>ISBN</label>
			<form:input path="isbn"  />
			<form:errors path="isbn" />
		</div>
		
		<div class="field">
			<label>Genre</label>
			<form:input path="genre"  />
			<form:errors path="genre" />
		</div>

		<div class="field">
			<label>Description</label>
			<form:textarea cols="50" rows="4" path="description"  />
			<form:errors path="description" />
		</div>
		
		<div class="field">
			<label>Book Image Cover</label>
			<input type="file" name="fileUpload" size="50" accept="image/*" />
			<form:errors path="img" />
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
