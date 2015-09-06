<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MakaInstr3.jsp' starting page</title>
    
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
            <strong><font size="4"> 玛卡制品目前主要有两大类：一是初步加工，将玛卡干果磨成粉或切成片；二是深度加工，通过现代工艺将玛卡粉破壁后制成的超微粉，其有效成分可以直接服用被人体迅速吸收；解决玛卡干果、切片服用不方便的问题。玛卡干果、切片与其他食物配合，通过炖汤、浸泡、入料等等一些传统饮食方法进行使用，制成美味的玛卡食品。下面就是目前比较常见的10种玛卡吃法。<br/>
           吃法1： 直接服用玛卡超微粉，这是目前最便利的玛卡使用方式。一般每天按照用餐时间服用，即早中晚三次，饭前空腹用温水送服。可以每天吃3次，每次10克即可。<br/></font></strong>
           <div style="text-align: center;"><img style="width: 80%;" src="<%=request.getContextPath()%>/weixinPic/6-1.jpg"></div><br/><br/>
       <strong><font size="4"> 吃法2：在炖鸡、鸭、牛羊肉、排骨、汤等时，在停火前30分钟加入30克玛卡切片/2000ml汤，饮用50ml/天；<br/></font></strong>
          <div style="text-align: center;"> <img style="width: 100%" src="<%=request.getContextPath()%>/weixinPic/6-2.jpg"></div><br/><br/>
          <strong><font size="4">吃法3：将玛卡切片和白酒，按重量(g):体积(ml)为1:20泡50度以上的白酒3周，饮用25ml/天;泡后的玛卡片可按用法1继续食用；<br/>
吃法4：将玛卡切片10克(2-3片)加开水(保温杯每次约300-500毫升)泡20分钟喝，泡4次后的玛卡片可直接食用；
吃法5：玛卡小米粥的做法，把廋猪肉切丝，和山药、大枣、小米共煮粥，粥熟前25分钟加入玛卡干片至粥熟；</font></strong>
<div style="text-align: center;"><img style="width: 100%" src="<%=request.getContextPath()%>/weixinPic/6-3.jpg"></div><br/><br/>
<strong><font size="4">吃法6：玛卡干片30g、红枣10枚，将红枣去核，洗净待用。锅置火上，加适量清水，用旺火煮沸，放入红枣、玛卡干片，锅加盖煮30分钟即可；<br/>
吃法7：将玛咖切片，随佐料同时入锅，文火慢煮，使玛咖中的营养成分，扩散在锅底的汤汁中，一般而言，2-3人食用，可放入三个完整玛卡的切片。<br/>
吃法8：把1或多个香蕉、芝麻糊、蜂蜜、花生酱/杏仁或坚果糊的果汁，混合玛卡超微粉和牛奶，最终制成玛卡香蕉奶昔。这一做法相对来说非常简单，是常推荐的一种玛卡吃法。<br/>
吃法9：玛卡根浸泡在容器，将它们与很多种不同的配料混合一起，包括一小撮的鲜木瓜、一些炼乳，还有鸡蛋，蜂蜜和香草，经过不停搅拌，最后制成可口的玛卡饮料。<br/>
吃法10：将玛卡切片，投入纯高粮酿制的烈性白酒中，长时间炮制，玛卡的有效成分充分扩散到酒精中，一个月之后，可直接倒出白酒即饮（5斤白酒可放入一斤切片,10克枸杞，10克西洋参），这就是玛卡保健酒。<br/>
玛卡的吃法很多，以上这十种相对来说更为常见，在此提醒大家，不管采用哪种玛卡吃法，服用有添加剂的胶囊玛卡、玛卡精片有可能不适合所有人，甚至对身体有害！直接食用纯天然的玛卡超微粉，很方便，同时大幅提升了人体对玛卡有效成分的吸收利用率。<br/>
 </font> </strong></div>
  </body>
</html>
