<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getHtml.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=path%>/js/bootstrap.js"></script>
   <script src="<%=path%>/js/jquery-1.9.0.min.js"></script>
   <script src="<%=path%>/js/jquery-1.js"></script>
   <script src="<%=path%>/js/jquery_last.js"></script>
  </head>
  
  <body onload=get1()>
    <div id='demo'></div> <br>
  </body>
  
  <script type="text/javascript">
  function get(){
  alert(1);
    $.get('http://www.zfanw.com/blog/', function(data) {
    alert(1);
   var title = $(data).filter('title').text();
   alert(1);
   alert(title);
   $('demo').html('陈三的博客的title为：' + title);
 });
  }
  
  function get1(){
  alert(1);
    var data=load('htmlDemo.jsp');
    alert(data);
  }
  
  </script>
</html>
