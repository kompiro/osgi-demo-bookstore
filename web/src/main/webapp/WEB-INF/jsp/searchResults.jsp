<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="書名検索ページ" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.kompiro.bookstore.books.model.Book" %>
<html>
<head><title>書名検索結果</title></head>
<body>
<form method="POST" action="search.htm">
<input type="text" name="searchString"/>&nbsp;
<input type="submit" value="Search"/>
</form>
<c:choose>
<c:when test='${empty books}'>
<h2>本が見つかりませんでした。</h2>
</c:when>
<c:otherwise>
<table border="1">
<thead>
<tr>
<td><b>書名</b></td>
<td><b>著者</b></td>
<td><b>値段</b></td>
</tr>
</thead>
<tbody>
<c:forEach items="${books}" var="book">
<tr>
<td><c:out value="${book.name}" /></td>
<td><c:out value="${book.author}" /></td>
<td><c:out value="${book.price}" />円</td>
</tr>
</c:forEach>
</tbody>
</table>
</c:otherwise>
</c:choose>
</body>
</html>