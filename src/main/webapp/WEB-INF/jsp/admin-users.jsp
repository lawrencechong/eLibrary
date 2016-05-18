<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Roles</th>
			<th>Active?</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.name}</td>
				
				<td> <c:forEach items="${user.roles}" var="role">
					${role.name}
				</c:forEach></td>
				<td>${user.enabled}</td>
				<td class="ui red button" onClick="location.href='./admin/ban/${user.name}'">Ban</td>
			</tr>x
		</c:forEach>
	</tbody>
</table>
