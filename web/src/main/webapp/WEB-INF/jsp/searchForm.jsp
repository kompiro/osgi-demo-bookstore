<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Bookstore</title>
  </head>
  
  <body style="text-align:center;">
      <br/>
      <br/>
      <br/>
      <h1>ブックストア</h1>
      ${serviceName}<br/>
      <br/>
      <br/>
      <form method="POST" action="search.htm">
        <input type="text" name="searchString" size="55" />
        <br/>
        <br/>
        <input type="submit" value="ブック検索" />
      </form>
      <br/>
      <br/>
      <br/>
      <span style="font-family:arial;font-size:8pt;">Copyright &copy; 2009</span>
  </body>
</html>