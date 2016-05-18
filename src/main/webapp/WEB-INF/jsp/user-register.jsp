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

			<style>
				/* Force scrollbars onto browser window */
				body {
					margin-bottom: 200%;
				}

				/* Box styles */
				.myBox {
					border: none;
					padding: 5px;
					font: 24px/36px sans-serif;
					width: 1000px;
					height: 200px;
					overflow: scroll;
				}

				/* Scrollbar styles */
				::-webkit-scrollbar {
					width: 12px;
					height: 12px;
				}

				::-webkit-scrollbar-track {
					box-shadow: inset 0 0 10px olivedrab;
					border-radius: 10px;
				}

				::-webkit-scrollbar-thumb {
					border-radius: 20px;
					background: black;
					box-shadow: inset 0 0 6px rgba(0,0,0,0.5);
				}

				::-webkit-scrollbar-thumb:hover {
					background: #7bac10;
				}
			</style>
			</head>
			<body>

			<!-- HTML -->
			<div class="myBox">
				Copy Right Policy.
				<br>

				The Digital Age presents new challenges to fundamental copyright doctrines that are legal cornerstones of library services. Libraries are leaders in trying to maintain a balance of power between copyright holders and users, in keeping with the fundamental principles outlined in the Constitution and carefully crafted over the past 200 years. In this role, we closely follow both federal and state legislation and make our voices heard when our issues are moving. Libraries are perceived as a voice for the public good and our participation is often sought in "friend of the court" briefs in important intellectual property cases. Our involvement extends to the international copyright arena where we also follow the treaties to which the U.S. is a signatory and which could influence the development of copyright changes at home.

				Copyright issues are among the most hotly contested issues in the legal and legislative world; billions of dollars are at stake. Legal principles and technological capabilities are constantly challenging each other and every outcome can directly affect the future of libraries.

				Everyday copyright law affects the way libraries provide information to their users. The first sale doctrine enables libraries to lend books and other resources. Fair use allows for the use of copyrighted works for purposes of criticism, comment, news reporting, scholarship, or research. Libraries are permitted to make reproductions of copyrighted works for preservation and replacement purposes. And under copyright law, libraries can aid in the transformation and reproduction of copyrighted works for users with disabilities. As libraries advocate for user rights and access to information, it's crucial to continue to address the emerging challenges posed at the intersection of technology, society, and law.
			</div>

			<form action="">
				<input type="checkbox" required>I agree to the terms and conditons<br>
			</form>

			<br>





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


