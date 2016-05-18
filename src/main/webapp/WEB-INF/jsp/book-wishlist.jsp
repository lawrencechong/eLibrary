<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<div class="ui compact menu">
  <div class="ui simple dropdown item">
    View By:
    <i class="dropdown icon"></i>
    <div class="menu">
      <div class="item" onclick="location.href='/user/wishlist?view=all';">All</div>
      <div class="item" onclick="location.href='/user/wishlist?view=available';">Available</div>
    </div>
  </div>
</div>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author(s)</th>
			<th>Available?</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${wishlist}" var="wishlist">
			<tr>
				<td><a href="/book/${wishlist.book.id}">${wishlist.book.title}</a></td>

				<td><c:forEach items="${wishlist.book.authors}" var="author">
					${author.name}
				</c:forEach></td>
				<td>
					<c:if test="${wishlist.book.isAvailable()}">
					Yes
					</c:if>
					<c:if test="${!wishlist.book.isAvailable()}">
					No
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>