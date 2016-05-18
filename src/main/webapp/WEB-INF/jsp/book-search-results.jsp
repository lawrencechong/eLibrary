<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

Found: ${booksFound} Books
<br>

<div class="container left">
	<div class="well well-sm">
		<strong>Display:</strong>
		<div class="btn-group">
			<a href="#" id="list" class="btn btn-default btn-sm"><span
				class="glyphicon glyphicon-th-list"> </span>List</a> <a href="#"
				id="grid" class="btn btn-default btn-sm"><span
				class="glyphicon glyphicon-th"></span>Grid</a>
		</div>

<div class="ui basic buttons left">

  	<button class="ui icon button" title="First Page" onclick=${"location.href='".concat(currentSearch).concat("'")}>
  <i class="angle double left icon"></i>
</button>
<c:if test="${previousPage != null}">
	<button class="ui icon button" title="Previous Page" onclick=${"location.href='".concat(currentSearch).concat("&page=").concat(previousPage).concat("'")}>
  <i class="angle left icon"></i>
</button>
</c:if>
<c:if test="${nextPage != null}">
	<button class="ui icon button" title="Next Page" onclick=${"location.href='".concat(currentSearch).concat("&page=").concat(nextPage).concat("'")}>
  <i class="angle right icon"></i>
</button>
</c:if>
	<button class="ui icon button" title="Last Page" onclick=${"location.href='".concat(currentSearch).concat("&page=").concat(lastPage).concat("'")}>
  <i class="angle double right icon"></i>
</button>
</div>

		<form action="/search" class="right">
			<c:if test="${param.q != null}">
				<input type="hidden" name="q" value=${param.q}>
			</c:if>
			<c:if test="${param.title != null}">
				<input type="hidden" name="title" value=${param.title}>
			</c:if>
			<c:if test="${param.author != null}">
				<input type="hidden" name="author" value=${param.author}>
			</c:if>
			<c:if test="${param.genre != null}">
				<input type="hidden" name="genre" value=${param.genre}>
			</c:if>
			<c:if test="${param.isbn != null}">
				<input type="hidden" name="isbn" value=${param.isbn}>
			</c:if>
			
			<select class="ui dropdown" name="view">
				<option value="">View By</option>
				<option value="all">All</option>
				<option value="available">Available</option>
			</select> <select class="ui dropdown" name="sort">
				<option value="">Sort By</option>
				<option value="title">Title</option>
				<option value="author">Author</option>
			</select> <input type="submit" value="Search" />
		</form>
	</div>
	
	<div id="products" class="row list-group">

		<c:forEach items="${books}" var="book">
			<div class="item  col-xs-4 col-lg-4">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400x250/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading"><a href="/book/${book.id}">${book.title}</a></h4>
						<h6>
							<c:forEach items="${book.authors}" var="author">
								<div class="group inner list-group-item-text">${author.name}</div>
							</c:forEach>
						</h6>
						<p class="group inner list-group-item-text">${book.shortenDescription()}</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="http://www.jquery2dotnet.com">Add
									to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>



