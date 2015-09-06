<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详情</title>
    
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
    <link href="css/lightbox.css" rel="stylesheet"/>
   <style type="text/css">
   
   .detailTitle{
    font-size: x-large;
    font-style: normal;
    text-shadow: green;
    font-weight:200;
    height: 10%;
   }
   
   
   .detailDescribe{
    font-style: normal;
    text-shadow: none;
    height: 30%;
   }
   
   </style>
  </head>
  
  
  <body onload="showPic()">
   <script src="<%=path%>/js/bootstrap.js"></script>
   <script src="<%=path%>/js/jquery-1.9.0.min.js"></script>
   <script src="js/lightbox.js" type="text/javascript"></script>
   

   
   
   
   
    <div class="detail" style="width: 100%">
    
      <div class="navbar" style="background: red">
      <div class="container" style="width: 100%">
  <ul class="nav"> 
   <li><a style="cursor: default;"><strong><font style="color: white;font-size: large;">商品详情</font></strong></a></li>
   </ul>
   </div>
   </div>
    
    <div style="height: 100%;width: 100%;">
    
<div style="text-align:  center;margin-top: -5%;">
    <img id="imgs" style="width: 100%;height: 75%" src="<%=request.getContextPath()%>/weixinPic/yuzhuo1.jpg"> 
    </div>


     <div class="navbar" style="width: 100%;height: 25%">
    <div class="container" style="width: 100%;height: 100%">
    
      <ul class="nav" id="nav1" style="width: 100%"> 
      
      </ul>
      
    </div>
    </div> 

    </div>
    
    <div style="height: 75%;width: 100%;">
    <div style="margin-left: 10%">
      <div class="detailTitle">
                    老坑缅甸玉手镯28g
      </div>
      
      <div class="detailDescribe">
               
      <textarea style="font-size: large;width: 80%;height: 50%">正宗缅甸玉啊有木有，颜色很正啊有木有，成色很好啊有木有，特价酬宾！</textarea>
      </div>
       
      <div class="price">
        <strong>价格</strong><span style="margin-left: 10%;"><font style="text-decoration: line-through;">¥178</font></span>
        <span style="margin-left: 2%"><font size="3" style="color: red"><strong>¥150</strong></font></span>
      </div><br/><br/>
      
      <!-- 这里加上成交数与评论 -->
    
    <div class="count">
    <strong>数量</strong>
    <span style="margin-left: 9%;">
     <img onclick="decrease()" height="2%" src="<%=request.getContextPath()%>/weixinPic/jianhao.jpg">
     <input title="请输入购买量" id="count" class="count-text"  style="width: 10%;height:6%;margin-top: 2%" type="text" maxlength="8" value="1"/>
     <img onclick="increase()" height="2%" src="<%=request.getContextPath()%>/weixinPic/jia.jpg">
     </span>
    </div><br/><br/>
    <div class="buttons">
    <span onclick="getBig('aas')"><img src="<%=request.getContextPath()%>/weixinPic/buy.jpg"></span>&nbsp;&nbsp;&nbsp;&nbsp;
    <span><img src="<%=request.getContextPath()%>/weixinPic/addshopCar.jpg"></span>
    </div>
    </div>
    </div>
    </div>
    
     <div class="navbar navbar-fixed-bottom" style="width: 100%">
    <div class="container" style="width: 100%">
    
      <ul class="nav" style="width: 100%"> 
      <li style="width: 33%;"><a href="#" class="btn btn-large"><i class="icon-home"></i>首页</a></li>
      <li style="width: 34%;"><a href="#" class="btn btn-large"><i class="icon-shopping-cart"></i>购物车</a></li>
      <li style="width: 33%;"><a href="#" class="btn btn-large"><i class="icon-exclamation-sign"></i> 购物帮助</a></li>
      </ul>
      
    </div>
    </div>
    
    
  </body>
  
  <script type="text/javascript">
  function decrease(){
    var count=document.getElementById("count").value;
    if(count>1){
    document.getElementById("count").value= count-1;
    }
    else{
    document.getElementById("count").value=1;
    }
  }
  
  function increase(){
    var count=document.getElementById("count").value;
    if(count<99){
    document.getElementById("count").value= parseInt(count)+1;
    }
    else if(count>=99){
    document.getElementById("count").value=99;
    }
    else{
    document.getElementById("count").value=1;
    }
  }
  
setInterval(changePic,3000); 
setInterval(changeMini,3000); 
var array=new Array(); 
var index=0; 
var array= new Array("weixinPic/yuzhuo1.jpg","weixinPic/3-1.jpg","weixinPic/6-2.jpg","weixinPic/5-1.jpg","weixinPic/5-2.jpg","weixinPic/6-3.jpg"); 
function changePic() 
{ var myimg=document.getElementById("imgs"); 
if(index==array.length-1) 
{ index=0; }else{ index++; } 
myimg.src=array[index]; 
} 


function showPic(){
 var array= new Array("weixinPic/yuzhuo1.jpg","weixinPic/3-1.jpg","weixinPic/6-2.jpg","weixinPic/5-1.jpg","weixinPic/5-2.jpg","weixinPic/6-3.jpg"); 

  var s=document.getElementById("nav1");  
  var t=array.length; 
  for (var i=0;i<t;i++)  
  {  
  var li= document.createElement("li");    
  var newname=array[i].substr(0,array[i].length-4)+"mini.jpg";
  var para0=array[i].substr(0,array[i].length-4)+".jpg";
  var para="'"+array[i].substr(0,array[i].length-4)+".jpg'";
  var str='<a href="'+para0+'" rel="lightbox" onmouseover="getBig('+para+')"><img src="'+newname+'"></a>';
  li.innerHTML=str;
    s.appendChild(li);   
    }   
 }


function getBig(para){
 var myimg=document.getElementById("imgs");
 myimg.src=para;
}
  </script>
  
</html>
