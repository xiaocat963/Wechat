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
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		String myurl="http://kongyd.duapp.com";
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			
			//�ָ�ͼ����Ϣ
			NewsMessage newsMessage=new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			
			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "�����͵����ı���Ϣ��";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "лл���Ĺ�ע��";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");

					if (eventKey.equals("11")) {
//						respContent = "";
//						textMessage.setContent(respContent);
//						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("21")) {
						List<Article> listArticle=new ArrayList<Article>();
						Article article1=new Article();
						article1.setTitle("����������");
						article1.setDescription("����������");
						article1.setPicUrl("http://www.baobei360.com/upfile/Video/201408/201408271015279829.jpg");
						article1.setUrl("http://www.youjigoatmilk.com/about.asp?id=28");
//						
//						Article article2=new Article();
//						article2.setTitle("���ǵ��꿨");
//						article2.setDescription("������꿨");
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
							article1.setTitle("�꿨��Ч");
							article1.setDescription("���ǵĲ�Ʒ");
							article1.setPicUrl(myurl+"/weixinPic/5-1.jpg");
							article1.setUrl(myurl+"/MakaInstr1.jsp");
//							
//							Article article2=new Article();
//							article2.setTitle("�꿨��Ч");
//							article2.setDescription("������꿨");
//							article2.setPicUrl(myurl+"/weixinPic/3-2.jpg");
//							article2.setUrl(myurl+"/MakaInstr2.jsp");
							
							Article article3=new Article();
							article3.setTitle("�꿨ʳ�÷�ʽ");
							article3.setDescription("�꿨��ô��");
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
//							article1.setTitle("���ǵ��꿨");
//							article1.setDescription("�Ҽ����꿨");
//							article1.setPicUrl(myurl+"/weixinPic/3-1.jpg");
//							article1.setUrl(myurl+"/ourMaka.jsp");
//							
//							Article article2=new Article();
//							article2.setTitle("���ǵ��꿨");
//							article2.setDescription("������꿨");
//							article2.setPicUrl(myurl+"/weixinPic/3-2.jpg");
//							article2.setUrl(myurl+"/ourMaka.jsp");
							
						 	List<Article> listArticle=new ArrayList<Article>();
							Article article1=new Article();
							article1.setTitle("���");
							article1.setDescription("������");
							article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz/tUlXIBiapViaicsMy2GePB8t8DiayKjuK5FlPEgFJiavSibPQSTianACrYBpft7z9tyAT0ZKDvn1J9L9l0Mo5ErXC2AwA/640?wx_fmt=jpeg&wxfrom=5");
							article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA4NTk1NzExNQ==&mid=209457964&idx=1&sn=c357bb9dc44f27fd6042d667059dc324#rd");
						 	
							Article article2=new Article();
							article2.setTitle("������");
							article2.setDescription("�߽�������");
							article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz/tUlXIBiapViaicsMy2GePB8t8DiayKjuK5Fl8voqqM6JJqxGfG4NeE5mAxBG0nWLoMCoFp6Z92FT0wicjz8t17G6YhA/640?wx_fmt=jpeg&wxfrom=5");
							article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzA4NTk1NzExNQ==&mid=209457231&idx=1&sn=a9ef4ed4bf6c4c7a24645c278224ee5e#rd");
						 	
							listArticle.add(article1);
							listArticle.add(article2);
							
	                        newsMessage.setArticles(listArticle);
							respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("31")) {
						respContent = "��Ӫ��������䡢��觡���ʯ���鱦���Σ������ϼܸ�Ʒ���꿨��Ƭ���꿧�ɹ����꿧ҩ�ƻ�ӭ���Ϲ˿͹���ѡ����"+"\r\n"+"��ַ������ʡ�ն��в�Է·�����ȹ㳡ΰԾԵ�鱦��\r\n��ϵ�绰��13577974477.";
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("32")) {
						respContent = "���и����������ۡ������̣����鴹ѯ13577974477.";
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
