<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<div class="container">
	<div class="well well-sm">
		<strong>Display</strong>
		<div class="btn-group">
			<a href="#" id="list" class="btn btn-default btn-sm"><span
				class="glyphicon glyphicon-th-list"> </span>List</a> <a href="#"
				id="grid" class="btn btn-default btn-sm"><span
				class="glyphicon glyphicon-th"></span>Grid</a>
		</div>
	</div>
	
	Search Results: ${books.size()} <br>

	<c:forEach items="${books}" var="book">
		<div id="products" class="row list-group">
			<div class="item  col-xs-4 col-lg-4">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/400x250/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">${book.title}</h4>

						<c:forEach items="${book.authors}" var="author">
							<div class="group inner list-group-item-text">${author.name}</div>
						</c:forEach>

						<p class="group inner list-group-item-text">${book.description}</p>
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
		</div>
	</c:forEach>
</div>
