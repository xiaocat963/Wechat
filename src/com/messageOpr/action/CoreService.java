package com.messageOpr.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.messageOpr.bo.response.Article;
import com.messageOpr.bo.response.NewsMessage;
import com.messageOpr.bo.response.TextMessage;

public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		String myurl="http://kongyd.duapp.com";
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			
			//恢复图文消息
			NewsMessage newsMessage=new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "您发送的是文本消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");

					if (eventKey.equals("11")) {
//						respContent = "";
//						textMessage.setContent(respContent);
//						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("21")) {
						List<Article> listArticle=new ArrayList<Article>();
						Article article1=new Article();
						article1.setTitle("卡倍多羊奶");
						article1.setDescription("卡倍多羊奶");
						article1.setPicUrl("http://www.baobei360.com/upfile/Video/201408/201408271015279829.jpg");
						article1.setUrl("http://www.youjigoatmilk.com/about.asp?id=28");
//						
//						Article article2=new Article();
//						article2.setTitle("你们的玛卡");
//						article2.setDescription("你家类玛卡");
//						article2.setPicUrl(myurl+"/weixinPic/3-2.jpg");
//						article2.setUrl(myurl+"/ourMaka.jsp");
						
						listArticle.add(article1);
						//listArticle.add(article2);
						
                        newsMessage.setArticles(listArticle);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("22")) {
						 newsMessage.setArticleCount(2);
							
							List<Article> listArticle=new ArrayList<Article>();
							Article article1=new Article();
							article1.setTitle("玛卡功效");
							article1.setDescription("我们的产品");
							article1.setPicUrl(myurl+"/weixinPic/5-1.jpg");
							article1.setUrl(myurl+"/MakaInstr1.jsp");
//							
//							Article article2=new Article();
//							article2.setTitle("玛卡功效");
//							article2.setDescription("你家类玛卡");
//							article2.setPicUrl(myurl+"/weixinPic/3-2.jpg");
//							article2.setUrl(myurl+"/MakaInstr2.jsp");
							
							Article article3=new Article();
							article3.setTitle("玛卡食用方式");
							article3.setDescription("玛卡怎么吃");
							article3.setPicUrl(myurl+"/weixinPic/6-1.jpg");
							article3.setUrl(myurl+"/MakaInstr3.jsp");
							
							listArticle.add(article1);
							//listArticle.add(article2);
							listArticle.add(article3);
							
	                        newsMessage.setArticles(listArticle);
							respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("23")) {
						 newsMessage.setArticleCount(1);
							
//							List<Article> listArticle=new ArrayList<Article>();
//							Article article1=new Article();
//							article1.setTitle("我们的玛卡");
//							article1.setDescription("我家类玛卡");
//							article1.setPicUrl(myurl+"/weixinPic/3-1.jpg");
//							article1.setUrl(myurl+"/ourMaka.jsp");
//							
//							Article article2=new Article();
//							article2.setTitle("你们的玛卡");
//							article2.setDescription("你家类玛卡");
//							article2.setPicUrl(myurl+"/weixinPic/3-2.jpg");
//							article2.setUrl(myurl+"/ourMaka.jsp");
							
						 	List<Article> listArticle=new ArrayList<Article>();
							Article article1=new Article();
							article1.setTitle("翡翠");
							article1.setDescription("翡翠鉴赏");
							article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz/tUlXIBiapViaicsMy2GePB8t8DiayKjuK5FlPEgFJiavSibPQSTianACrYBpft7z9tyAT0ZKDvn1J9L9l0Mo5ErXC2AwA/640?wx_fmt=jpeg&wxfrom=5");
							article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA4NTk1NzExNQ==&mid=209457964&idx=1&sn=c357bb9dc44f27fd6042d667059dc324#rd");
						 	
							Article article2=new Article();
							article2.setTitle("黄龙玉");
							article2.setDescription("走进黄龙玉");
							article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz/tUlXIBiapViaicsMy2GePB8t8DiayKjuK5Fl8voqqM6JJqxGfG4NeE5mAxBG0nWLoMCoFp6Z92FT0wicjz8t17G6YhA/640?wx_fmt=jpeg&wxfrom=5");
							article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzA4NTk1NzExNQ==&mid=209457231&idx=1&sn=a9ef4ed4bf6c4c7a24645c278224ee5e#rd");
						 	
							listArticle.add(article1);
							listArticle.add(article2);
							
	                        newsMessage.setArticles(listArticle);
							respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("31")) {
						respContent = "主营玉器、翡翠、玛瑙、宝石等珠宝首饰，最新上架各品牌玛卡精片、玛咖干果、玛咖药酒欢迎新老顾客光临选购！"+"\r\n"+"地址：云南省普洱市茶苑路华尔兹广场伟跃缘珠宝。\r\n联系电话：13577974477.";
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("32")) {
						respContent = "诚招各级合作销售、代理商，详情垂询13577974477.";
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}

				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}
