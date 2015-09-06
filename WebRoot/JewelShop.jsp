<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>珠宝专区</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">

 <!-- <style type="text/css">
   body {background: #000;}
  @media (max-width:700px){body {
	background: #f00;
}}
  </style>-->
  </head>
  
  <body>
   <script src="<%=path%>/js/bootstrap.js"></script>
   <script src="<%=path%>/js/jquery-1.9.0.min.js"></script>
    <div class="navbar navbar-fixed-bottom" style="width: 100%">
    <div class="container" style="width: 100%">
    
      <ul class="nav" style="width: 100%"> 
      <li style="width: 33%;"><a href="#" class="btn btn-large"><i class="icon-home"></i>首页</a></li>
      <li style="width: 34%;"><a href="#" class="btn btn-large"><i class="icon-shopping-cart"></i>购物车</a></li>
      <li style="width: 33%;"><a href="#" class="btn btn-large"><i class="icon-exclamation-sign"></i> 购物帮助</a></li>
      </ul>
      
    </div>
    </div>
   
   <div class="main" style="width: 100%;margin-bottom: 5%" >
     <div style="width: 100%;height:40%;" onclick="goyuqi()">
     <div style="text-align: center;"><img  style="width: 100%;height: 80%" src="<%=request.getContextPath()%>/weixinPic/yuzhuo2.jpg">
     </div><div style="width: 100%;height: 11%;margin-top: 1%"><span style="margin-left:5%;margin-top:50%;"><strong>玉器专区</strong></span></div>
     </div>   
   
     <div style="width: 100%;height:40%;" onclick="gohupo()">
     <div style="text-align: center;"><img  style="width: 100%;height: 80%" src="<%=request.getContextPath()%>/weixinPic/hupo.jpg">
     </div><div style="width: 100%;height: 11%;margin-top: 1%"><span style="margin-left:3%;margin-top:50%;"><strong>翡翠琥珀</strong></span></div>
     </div> 
     
     <div style="width: 100%;height:40%;" onclick="goyuqi()">
     <div style="text-align: center;"><img  style="width: 100%;height: 80%" src="<%=request.getContextPath()%>/weixinPic/fozhu.jpg">
     </div><div style="width: 100%;height: 11%;margin-top: 1%"><span style="margin-left:3.5%;margin-top:50%;text-align: center"><strong>其他珠宝</strong></span></div>
     </div>
   </div>
  </body>
  <script type="text/javascript">
  function goyuqi(){
  window.location.href="<%=request.getContextPath()%>/yuqiList.jsp";
  }
  
  function gohupo(){
  window.location.href="<%=request.getContextPath()%>/test.jsp";
  }
  </script>