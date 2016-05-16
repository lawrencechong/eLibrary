<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author(s)</th>
			<th>Your Rating</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ratings}" var="rating">
			<tr>
				<td><a href="/book/${rating.book.id}">${rating.book.title}</a></td>

				<td><c:forEach items="${rating.book.authors}" var="author">
					${author.name}
				</c:forEach></td>
				
				<td>${rating.rating_score }/5</td>
			</tr>
		</c:forEach>
	</tbody>
</table>