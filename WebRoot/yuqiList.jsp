<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>玉器专场</title>
    
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
    
    
    <div class="list" style="margin-bottom: 5%">
      <div class="row1">
        <div class="span4">
          <div onclick="yuqiDetail()"><img style="text-align: center;" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg">
            <div><strong>漂亮的玉镯头</strong></div>
            <div><font style="font-style: inherit;red">¥109.00</font></div>
          </div>
        </div>
        
        <div class="span4">
          <div onclick="yuqiDetail()"><img style="text-align: center;" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg">
            <div><strong>漂亮的玉镯头</strong></div>
            <div><font style="font-style: inherit;red">¥109.00</font></div>
          </div>
        </div>
        
        <div class="span4">
          <div onclick="yuqiDetail()"><img style="text-align: center;" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg">
            <div><strong>漂亮的玉镯头</strong></div>
            <div><font style="font-style: inherit;red">¥109.00</font></div>
          </div>
        </div>
      </div>
      
       <div class="row2">
        <div class="span4">
          <div onclick="yuqiDetail()"><img style="text-align: center;" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg">
            <div><strong>漂亮的玉镯头</strong></div>
            <div><font style="font-style: inherit;red">¥109.00</font></div>
          </div>
        </div>
        
        <div class="span4">
          <div onclick="yuqiDetail()"><img style="text-align: center;" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg">
            <div><strong>漂亮的玉镯头</strong></div>
            <div><font style="font-style: inherit;red">¥109.00</font></div>
          </div>
        </div>
        
        <div class="span4">
          <div onclick="yuqiDetail()"><img style="text-align: center;" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg">
            <div><strong>漂亮的玉镯头</strong></div>
            <div><font style="font-style: inherit;red">¥109.00</font></div>
          </div>
        </div>
      </div>
      
       <div class="row3">
        <div class="span4">
          <div><img src=""></div>
        </div>
        
        <div class="span4">
          <div><img src=""></div>
        </div>
        
        <div class="span4">
          <div><img src=""></div>
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript">
    function yuqiDetail(){
    window.location.href="<%=request.getContextPath()%>/yuqiDetail.jsp";
    }
  </script>
</html>
