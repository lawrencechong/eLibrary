<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../layout/taglib.jsp"%>

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
