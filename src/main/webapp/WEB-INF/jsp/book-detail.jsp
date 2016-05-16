<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<security:authentication var="user" property="principal" />

Book Details
<br>
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
	<c:if test="${rating.rating_score == null}">
		Your Rating: <p class="ui star rating" data-id=${book.id} data-rating="0" data-max-rating="5"></p>
	</c:if>
	<c:if test="${rating.rating_score != null}">
		Your Rating: <p class="ui star rating" data-id=${book.id} data-rating=${rating.rating_score} data-max-rating="5"></p>
		<a href="/user/rating/${rating.id}/delete">Delete Rating</a>
	</c:if>
</security:authorize>