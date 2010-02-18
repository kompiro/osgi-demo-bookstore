<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <title>こんぴろ書店(検索画面)</title>
  </head>
  
  <body style="text-align:center;font-size:20pt;">
      <br/>
      <br/>
      <br/>
      <h1>こんぴろ書店<br/>(検索画面)</h1>
      <!--  ${serviceName}  -->
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
      <span style="font-family:arial;font-size:8pt;">Copyright &copy; 2010</span>
  </body>
</html>