package com.phome.one;


import java.io.BufferedReader;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

import java.net.URL;

import org.json.JSONObject;

import com.phome.bo.Button;
import com.phome.bo.ComplexButton;
import com.phome.bo.Menu;
import com.phome.bo.NormalButton;

public class MycreateMenu {

        

        /**

         * @param args
         * @throws Exception 

         */

        public static int create(String flag) throws Exception {

//                String s ="{'button':[{'type':'view','name':'�����鱦','url':'http://www.baidu.com'},{'name':'�����꿨','sub_button':[{'type':'view','name':'��ʼѡ��','url':'http://www.taobao.com'},{'type':'click','name':'�����꿨','key':'3'},{'type':'click','name':'���ǵ��꿨','key':'4'}]},{'name':'��������','sub_button':[{'type':'click','name':'��ϵ��ʽ','key':'2'},{'type':'click','name':'���д���','key':'5'}]}]}";
//                //"{\"button\":[{\"type\":\"view\",\"name\":\"�����鱦\",\"url\":\"http://www.baidu.com\"},{\"name\":\"�����꿨\",\"sub_button\":[{\"type\":\"view\",\"name\":\"��ʼѡ��\",\"url\":\"http://www.taobao.com\"},{\"type\":\"click\",\"name\":\"�����꿨\",\"key\":\"3\"},{\"type\":\"click\",\"name\":\"���ǵ��꿨\",\"key\":\"4\"}]},{\"name\":\"��������\",\"sub_button\":[{\"type\":\"click\",\"name\":\"��ϵ��ʽ\",\"key\":\"2\"},{\"type\":\"click\",\"name\":\"���д���\",\"key\":\"5\"}]}]}";
//                s.getBytes("UTF-8");
                
                
//                if (flag.equals("zhubao")) {
					String appid = "wxa9addeb101adbb61";
					String secret = "6517648b4c02049a2af5c9018bcb16ed";
					String accessToken = getAccessToken(appid, secret);
					int result=WeixinUtil.createMenu(getMenu(), accessToken);
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++"+flag);
					return result;
                
        }
        
//        public static void main(String[] args) {
//        	try {
//        		String appid = "wxa9addeb101adbb61";
//				String secret = "6517648b4c02049a2af5c9018bcb16ed";
//				String accessToken = getAccessToken(appid, secret);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
        
        public static String getAccessToken(String appid, String secret) throws Exception {     
        	StringBuffer bufferRes = new StringBuffer();
        	String accessToken = null;
        	  try {

        		  URL realUrl = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret);
        		  
                  HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

                  // ���ӳ�ʱ
                  conn.setConnectTimeout(25000);

                  // ��ȡ��ʱ --��������Ӧ�Ƚ���,����ʱ��

                  conn.setReadTimeout(25000);

                  HttpURLConnection.setFollowRedirects(true);

                  // ����ʽ

                  conn.setRequestMethod("GET");

                  conn.setDoOutput(true);

                  conn.setDoInput(true);

                  conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

                  conn.setRequestProperty("Referer", "https://api.weixin.qq.com/");

                  conn.connect();

                  // ��ȡURLConnection�����Ӧ�������

                  OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

                  // �����������

                  //out.write(URLEncoder.encode(params,"UTF-8"));

                  //out.write(params);

                  out.flush();

                  out.close();

                  InputStream in = conn.getInputStream();

                  BufferedReader read = new BufferedReader(new InputStreamReader(in,"UTF-8"));

                  String valueString = null;

                  while ((valueString=read.readLine())!=null){

                          bufferRes.append(valueString);

                  }

                  System.out.println("what's this"+bufferRes.toString());
                  
                  JSONObject jsonObject = new JSONObject(bufferRes.toString());
                  accessToken = (String) jsonObject.get("access_token");
                  System.out.println(accessToken);
                  in.close();
                    
                  if (conn != null) {

                          // �ر�����

                          conn.disconnect();
                          

                  }

          } catch (Exception e) {

                  e.printStackTrace();

          }
			return accessToken;
        }     


        private static Menu getMenu() {
    		NormalButton btn11 = new NormalButton();
    		btn11.setName("�µ�����");
    		btn11.setType("view");
    		btn11.setUrl("http://weidian.com/?userid=254597924&wfr=wx&from=singlemessage&isappinstalled=0");

//    		NormalButton btn12 = new NormalButton();
//    		btn12.setName("������ѯ");
//    		btn12.setType("click");
//    		btn12.setKey("1");
//
//    		NormalButton btn13 = new NormalButton();
//    		btn13.setName("�ܱ�����");
//    		btn13.setType("click");
//    		btn13.setKey("1");
//
//    		NormalButton btn14 = new NormalButton();
//    		btn14.setName("��ʷ�ϵĽ���");
//    		btn14.setType("click");
//    		btn14.setKey("1");

    		NormalButton btn21 = new NormalButton();
    		btn21.setName("����������");
    		btn21.setType("view");
    		btn21.setUrl("http://www.youjigoatmilk.com/index.asp");
    	
//    		NormalButton btn22 = new NormalButton();
//    		btn22.setName("�꿨����");
//    		btn22.setType("click");
//    		btn22.setKey("22");
    		NormalButton btn22 = new NormalButton();
    		btn22.setName("�꿨��Ч");
    		btn22.setType("view");
    		btn22.setUrl("http://health.pclady.com.cn/92/926923.html");

    		NormalButton btn23 = new NormalButton();
    		btn23.setName("�鱦����");
    		btn23.setType("click");
    		btn23.setKey("23");

//    		NormalButton btn24 = new NormalButton();
//    		btn24.setName("����ʶ��");
//    		btn24.setType("click");
//    		btn24.setKey("1");
//
//    		NormalButton btn25 = new NormalButton();
//    		btn25.setName("��������");
//    		btn25.setType("click");
//    		btn25.setKey("31");

    		NormalButton btn31 = new NormalButton();
    		btn31.setName("��������");
    		btn31.setType("click");
    		btn31.setKey("31");

    		NormalButton btn32 = new NormalButton();
    		btn32.setName("���д���");
    		btn32.setType("click");
    		btn32.setKey("32");

//    		NormalButton btn33 = new NormalButton();
//    		btn33.setName("��ĬЦ��");
//    		btn33.setType("click");
//    		btn33.setKey("1");

    		ComplexButton mainBtn1 = new ComplexButton();
    		mainBtn1.setName("�µ�����");
    		mainBtn1.setSub_button(new NormalButton[] { btn11});

    		ComplexButton mainBtn2 = new ComplexButton();
    		mainBtn2.setName("��Ʒ����");
    		mainBtn2.setSub_button(new NormalButton[] { btn21, btn22, btn23});

    		ComplexButton mainBtn3 = new ComplexButton();
    		mainBtn3.setName("��������");
    		mainBtn3.setSub_button(new NormalButton[] { btn31, btn32});

    		/**
    		 * ���ǹ��ں�xiaoqrobotĿǰ�Ĳ˵��ṹ��ÿ��һ���˵����ж����˵���<br>
    		 * 
    		 * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br>
    		 * ���磬������һ���˵����"��������"����ֱ����"��ĬЦ��"����ômenuӦ���������壺<br>
    		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
    		 */
    		Menu menu = new Menu();
    		System.out.println("--------------"+mainBtn1);
    		System.out.println("--------------"+mainBtn2);
    		System.out.println("--------------"+mainBtn3);
    		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
             
    		System.out.println("--------------"+menu);
    		return menu;
    	}
        
        
        private static Menu getClothesMenu() {
    		NormalButton btn11 = new NormalButton();
    		btn11.setName("��Ʒ����");
    		btn11.setType("view");
    		btn11.setUrl("http://kongyd.duapp.com/clothes/clothesShop.jsp");
    		
    		NormalButton btn12 = new NormalButton();
    		btn11.setName("���Ű���");
    		btn11.setType("view");
    		btn11.setUrl("http://kongyd.duapp.com/clothes/BagShop.jsp");

    		NormalButton btn21 = new NormalButton();
    		btn21.setName("��Ʒ�Ƽ�");
    		btn21.setType("view");
    		btn21.setUrl("http://kongyd.duapp.com/clothes/NewRecommand.jsp");
    	
    		NormalButton btn22 = new NormalButton();
    		btn22.setName("�ۿ�ר��");
    		btn22.setType("view");
    		btn22.setUrl("http://kongyd.duapp.com/clothes/discount.jsp");

    		NormalButton btn23 = new NormalButton();
    		btn23.setName("��ƷԤ��");
    		btn23.setType("click");
    		btn23.setKey("23");

    		NormalButton btn31 = new NormalButton();
    		btn31.setName("��������");
    		btn31.setType("click");
    		btn31.setKey("31");

    		NormalButton btn32 = new NormalButton();
    		btn32.setName("��ܰ��ʾ");
    		btn32.setType("click");
    		btn32.setKey("32");

//    		NormalButton btn33 = new NormalButton();
//    		btn33.setName("��ĬЦ��");
//    		btn33.setType("click");
//    		btn33.setKey("1");

    		ComplexButton mainBtn1 = new ComplexButton();
    		mainBtn1.setName("������");
    		mainBtn1.setSub_button(new NormalButton[] { btn11,btn12});

    		ComplexButton mainBtn2 = new ComplexButton();
    		mainBtn2.setName("����");
    		mainBtn2.setSub_button(new NormalButton[] { btn21, btn22, btn23});

    		ComplexButton mainBtn3 = new ComplexButton();
    		mainBtn3.setName("������");
    		mainBtn3.setSub_button(new NormalButton[] { btn31, btn32});

    		Menu menu = new Menu();
    		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
             
    		return menu;
    	}
}


