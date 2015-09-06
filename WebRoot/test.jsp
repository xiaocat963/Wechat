<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<head>
    <title>demo - scroll photos</title>
</head>
<body>
<div style=" margin-bottom:5px;  background-color:Aqua; overflow:hidden;">
    <div id="domainImages" style=" margin-left:0px;">
        <span style="  float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
        <span style="  overflow:hidden; float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
        <span style=" overflow:hidden; float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
        <span style=" overflow:hidden; float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
        <span style="  overflow:hidden; float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
        <span style="  overflow:hidden; float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
        <span style=" overflow:hidden; float:left; ">
            <img style=" width:100%; height:100%;" src="weixinPic/yuzhuo1.jpg" />
        </span>
    </div>
    <div style="clear:both;"></div>
</div>
<input type="button" id="btnPrev" onclick="clickHandler(event)" value="prev" />
<input type="button" id="btnNext" onclick="clickHandler(event)" value="next" />
    <script type="text/javascript">
        var domainImagesObj = document.getElementById("domainImages");
        var index = 0;
        // 总页数
        var pageNum = 0;
        // 图片总数
        var imagesLength = 0;
        // 每页要显示的图片个数
        var pageImgNumber = 2;
        // 放置图片的Div宽度
        var imagesWidth = domainImagesObj.getElementsByTagName("div")[0].style.width;
        // 翻页时需要设置的左边距距离
        var scrollPels = parseInt(imagesWidth.substring(0, imagesWidth.indexOf("px")), 10) * pageImgNumber;
        
        imagesLength = domainImagesObj.getElementsByTagName("img").length;
        pageNum = imagesLength / pageImgNumber;
        
        function clickHandler(oEvent)
        {
            // 获取左边距距离            
            var styleLeftValue = parseInt(domainImagesObj.style.marginLeft.substring(0, domainImagesObj.style.marginLeft.indexOf("px")),10);
            var src = oEvent.target || oEvent.srcElement;
            var srcID = src.id;
            
            // 上一页
            if (srcID == "btnPrev") {
                if (index > 0) {
                    //设置样式，实现图片翻页效果
                    domainImagesObj.style.marginLeft = (styleLeftValue + scrollPels) + "px";
                    index -= 1;
                }
            }
            // 下一页
            else if (srcID == "btnNext") {
                if (index < (pageNum - 1)) {
                    //设置样式，实现图片翻页效果
                    domainImagesObj.style.marginLeft = (styleLeftValue - scrollPels) + "px";
                    index += 1;
                }
            }
        }
    </script>
</body>
</html>