<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<security:authentication var="user" property="principal" />

${book.title}
<br>
<c:forEach items="${book.authors}" var="author">
					${author.name}
				</c:forEach>
<br>

${book.genre.name}
<br>
${book.description}
<br>
<security:authorize access="isAuthenticated()">
	<div>
		<c:if test="${rating == null}">
		Your Rating: <p class="ui star rating" data-id=${book.id
			}
				data-rating="0" data-max-rating="5"></p>
		</c:if>
		<c:if test="${rating != null}">
		Your Rating: <p class="ui star rating" data-id=${book.id
			}
				data-rating=${rating.rating_score } data-max-rating="5"></p>
			<a href="/user/rating/${rating.id}/delete">Delete Rating</a>
		</c:if>
	</div>

	<div>
		<c:if test="${hold == null}">
		<button class="ui basic button" onClick="location.href='/user/holds/new/Book/${book.id}'">
			Reserve
		</button>
		</c:if>
		<c:if test="${hold != null}">
		<button class="ui basic button" onClick="location.href='/user/holds/delete/${book.id}'">
			Delete Reserve
		</button>
		</c:if>
		<c:if test="${wishlist == null}">
		<button class="ui basic button" onClick="location.href='/user/wishlist/book/${book.id}'">
			Add to Wish List
		</button>
		</c:if>
		<c:if test="${wishlist != null}">
		<button class="ui basic button" onClick="location.href='/user/wishlist/remove/book/${book.id}'">
			Remove from Wish List
		</button>
		</c:if>
		<button class="ui basic button" onClick="location.href='/user/borrow/book/${book.id}'">
			Borrow
		</button>
		<button class="ui basic button" onClick="location.href='/user/renew/book/${book.id}'">
			Renew
		</button>
		<button class="ui basic button" onClick="location.href='/user/return/book/${book.id}'">
			Return
		</button>
	</div>
</security:authorize>