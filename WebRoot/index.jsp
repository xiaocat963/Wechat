<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  <script type="text/javascript">
  $(document).ready(function(){
  var user = "<%=user%>";
  if(user == null && user ==""){
	  window.location.href="login.jsp"
  }
  });
  </script>
  </script>
  <body>
    <form action="<%=request.getContextPath()%>/Yourchat" method="post">
      <input type="submit" value="提交">
   </form>
   <form action="<%=request.getContextPath()%>/CreateMenu" method="post">
      <input type="submit" value="创建jewel">
   </form>
   
   <form action="<%=request.getContextPath()%>/CreateMenu">
      <input type="submit" value="创建clothes">
   </form>

  </body>
</html>
