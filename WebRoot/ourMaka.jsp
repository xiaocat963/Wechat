<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ourMaka.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="makaPic" style="width:100%;">
    <strong><font size="4">  好消息！普洱伟跃缘珠宝玛咖系列产品已上柜！
      1原材料都产自高原丽江，质量保证，品种丰富。</font></strong><br/>
      <div style="text-align: center;"><img style="width: 100%;height:30%" src="<%=request.getContextPath()%>/weixinPic/4-1.jpg"></div><br/>
        <strong><font size="4">  泸州老窑玛咖酒</font></strong><br/><br/>
      <div style="text-align: center;"><img style="width: 100%;height:30%" src="<%=request.getContextPath()%>/weixinPic/4-2.jpg"></div><br/>
         <strong><font size="4"> 康美药业康美云玛咖精片</font><br/><br/></strong>
      <div style="text-align: center;"><img style="width: 100%;height:30%" src="<%=request.getContextPath()%>/weixinPic/4-3.jpg"></div><br/>
        <strong><font size="4">  红顺堂玛咖精片</font></strong><br/><br/>
      <div style="text-align: center;"><img style="width: 100%;height:30%" src="<%=request.getContextPath()%>/weixinPic/4-4.jpg"></div><br/>
         <strong><font size="4"> 玛咖干果</font></strong><br/><br/>
         
        <strong><font size="4"> 还有更多优秀商品，请新老客户到线下店铺或者网上商城选购。</font> </strong>        
    </div>
  </body>
</html>
