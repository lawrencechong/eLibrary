<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author(s)</th>
			<th>genre</th>
			<th>description</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.title}</td>
				
				<td> <c:forEach items="${book.authors}" var="author">
					${author.name}
				</c:forEach></td> 
				
				<td>${book.genre.name}</td>
				<td>${book.description}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
