<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="登録結果ページ" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.kompiro.bookstore.books.model.Book" %>
<html>
<head><title>本の登録結果</title></head>
<body>
${serviceName}<br/>
<form method="POST" action="register.htm">
  書名: <input type="text" name="name" size="55" />
  <br/>
  著者: <input type="text" name="author" size="55" />
  <br/>
  値段: <input type="text" name="price" size="55" />&nbsp;<input type="submit" value="登録" />
</form>
<c:choose>
<c:when test='${empty book}'>
<h2>本が登録できませんでした。</h2>
</c:when>
<c:otherwise>
<h2>本を登録しました。</h2>
<table border="1">
<thead>
<tr>
<td><b>書名</b></td>
<td><b>著者</b></td>
<td><b>値段</b></td>
</tr>
</thead>
<tbody>
<tr>
<td><c:out value="${book.name}" /></td>
<td><c:out value="${book.author}" /></td>
<td><c:out value="${book.price}" />円</td>
</tr>
</tbody>
</table>
</c:otherwise>
</c:choose>
</body>
</html>