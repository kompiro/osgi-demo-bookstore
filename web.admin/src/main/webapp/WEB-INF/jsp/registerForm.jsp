<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="本の登録ページ" %>
<html>
  <head>
    <title>こんぴろ書店(登録画面)</title>
  </head>
  
  <body style="text-align:center;font-size:20pt;">
      <br/>
      <br/>
      <br/>
      <h1>本の登録</h1>
      <!-- ${serviceName} -->
      <br/>
      <br/>
      <form method="POST" action="register.htm">
        書名: <input type="text" name="name" size="55" />
        <br/>
        著者: <input type="text" name="author" size="55" />
        <br/>
        値段: <input type="text" name="price" size="55" />
        <br/>
        <br/>
        <input type="submit" value="登録" />
      </form>
      <br/>
      <br/>
      <br/>
      <span style="font-family:arial;font-size:8pt;">Copyright &copy; 2010</span>
  </body>
</html>