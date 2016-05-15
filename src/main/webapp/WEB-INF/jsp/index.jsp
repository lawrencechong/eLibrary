<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author(s)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td><a href="/book/${book.id}">${book.title}</a></td>

				<td><c:forEach items="${book.authors}" var="author">
					${author.name}
				</c:forEach></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<img src="<c:url value='/resources/images/hp.jpg'/>" alt="book"
	height="156" width="130">


<div></div>
<div>Most Popular</div>

<div>New eBooks</div>

<div>New Audio Books</div>

<div>Recommended Books</div>



