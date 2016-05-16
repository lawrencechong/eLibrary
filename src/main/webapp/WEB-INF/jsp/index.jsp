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


<div class="book_section">
	<div class="section_head">
		<p class="book_index_title">Recommended For You</p>

	</div>



</div>

<div class="book_section">
	<div class="section_head">
		<p class="book_index_title">Most Popular</p>

	</div>


</div>

<div class="book_section">
	<div class="section_head">
		<p class="book_index_title">
			New eBooks <span class="section_link"> <a
				href="/books/new_books">More New Books ></a></span>
		</p>
	</div>

	<div class='book-container'>
		<div class="ui card">
			<center>
				<div class="image">
					<img src="<c:url value='/resources/images/hp.jpg'/>" alt="book"
						width="290">
				</div>
			</center>
			<div class="content">
				<a class="header">Harry Potter and the Sorcerer's Stone</a>
				<div class="meta">
					<span class="date">J.K. Rowling</span>
				</div>
				<div class="description">Kristy is an art director living in
					New York.</div>
			</div>
			<div class="extra content">
				<a> <i class="user icon"></i> 22 Friends
				</a>
			</div>
		</div>
	</div>
</div>

<div class="book_section">
	<div class="section_head">
		<p class="book_index_title"></p>
	</div>
	
	<div class="section_head">
		<p class="book_index_title">
			New Audio Books <span class="section_link"> <a
				href="/books/new_books">More Audio Books Books ></a></span>
		</p>
	</div>

	<div class='book-container'>
		<img src="<c:url value='/resources/images/hp.jpg'/>" alt="book"
			height="156" width="130">
		<p>Harry Potter</p>
		<p>J.K. Rowling</p>
	</div>


</div>




