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

//                String s ="{'button':[{'type':'view','name':'购买珠宝','url':'http://www.baidu.com'},{'name':'购买玛卡','sub_button':[{'type':'view','name':'开始选购','url':'http://www.taobao.com'},{'type':'click','name':'关于玛卡','key':'3'},{'type':'click','name':'我们的玛卡','key':'4'}]},{'name':'关于我们','sub_button':[{'type':'click','name':'联系方式','key':'2'},{'type':'click','name':'诚招代理','key':'5'}]}]}";
//                //"{\"button\":[{\"type\":\"view\",\"name\":\"购买珠宝\",\"url\":\"http://www.baidu.com\"},{\"name\":\"购买玛卡\",\"sub_button\":[{\"type\":\"view\",\"name\":\"开始选购\",\"url\":\"http://www.taobao.com\"},{\"type\":\"click\",\"name\":\"关于玛卡\",\"key\":\"3\"},{\"type\":\"click\",\"name\":\"我们的玛卡\",\"key\":\"4\"}]},{\"name\":\"关于我们\",\"sub_button\":[{\"type\":\"click\",\"name\":\"联系方式\",\"key\":\"2\"},{\"type\":\"click\",\"name\":\"诚招代理\",\"key\":\"5\"}]}]}";
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

                  // 连接超时
                  conn.setConnectTimeout(25000);

                  // 读取超时 --服务器响应比较慢,增大时间

                  conn.setReadTimeout(25000);

                  HttpURLConnection.setFollowRedirects(true);

                  // 请求方式

                  conn.setRequestMethod("GET");

                  conn.setDoOutput(true);

                  conn.setDoInput(true);

                  conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");

                  conn.setRequestProperty("Referer", "https://api.weixin.qq.com/");

                  conn.connect();

                  // 获取URLConnection对象对应的输出流

                  OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

                  // 发送请求参数

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

                          // 关闭连接

                          conn.disconnect();
                          

                  }

          } catch (Exception e) {

                  e.printStackTrace();

          }
			return accessToken;
        }     


        private static Menu getMenu() {
    		NormalButton btn11 = new NormalButton();
    		btn11.setName("下单购买");
    		btn11.setType("view");
    		btn11.setUrl("http://weidian.com/?userid=254597924&wfr=wx&from=singlemessage&isappinstalled=0");

//    		NormalButton btn12 = new NormalButton();
//    		btn12.setName("公交查询");
//    		btn12.setType("click");
//    		btn12.setKey("1");
//
//    		NormalButton btn13 = new NormalButton();
//    		btn13.setName("周边搜索");
//    		btn13.setType("click");
//    		btn13.setKey("1");
//
//    		NormalButton btn14 = new NormalButton();
//    		btn14.setName("历史上的今天");
//    		btn14.setType("click");
//    		btn14.setKey("1");

    		NormalButton btn21 = new NormalButton();
    		btn21.setName("卡倍多羊奶");
    		btn21.setType("view");
    		btn21.setUrl("http://www.youjigoatmilk.com/index.asp");
    	
//    		NormalButton btn22 = new NormalButton();
//    		btn22.setName("玛卡介绍");
//    		btn22.setType("click");
//    		btn22.setKey("22");
    		NormalButton btn22 = new NormalButton();
    		btn22.setName("玛卡功效");
    		btn22.setType("view");
    		btn22.setUrl("http://health.pclady.com.cn/92/926923.html");

    		NormalButton btn23 = new NormalButton();
    		btn23.setName("珠宝介绍");
    		btn23.setType("click");
    		btn23.setKey("23");

//    		NormalButton btn24 = new NormalButton();
//    		btn24.setName("人脸识别");
//    		btn24.setType("click");
//    		btn24.setKey("1");
//
//    		NormalButton btn25 = new NormalButton();
//    		btn25.setName("关于我们");
//    		btn25.setType("click");
//    		btn25.setKey("31");

    		NormalButton btn31 = new NormalButton();
    		btn31.setName("关于我们");
    		btn31.setType("click");
    		btn31.setKey("31");

    		NormalButton btn32 = new NormalButton();
    		btn32.setName("诚招代理");
    		btn32.setType("click");
    		btn32.setKey("32");

//    		NormalButton btn33 = new NormalButton();
//    		btn33.setName("幽默笑话");
//    		btn33.setType("click");
//    		btn33.setKey("1");

    		ComplexButton mainBtn1 = new ComplexButton();
    		mainBtn1.setName("下单购买");
    		mainBtn1.setSub_button(new NormalButton[] { btn11});

    		ComplexButton mainBtn2 = new ComplexButton();
    		mainBtn2.setName("商品介绍");
    		mainBtn2.setSub_button(new NormalButton[] { btn21, btn22, btn23});

    		ComplexButton mainBtn3 = new ComplexButton();
    		mainBtn3.setName("关于我们");
    		mainBtn3.setSub_button(new NormalButton[] { btn31, btn32});

    		/**
    		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
    		 * 
    		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
    		 * 比如，第三个一级菜单项不是"更多体验"，而直接是"幽默笑话"，那么menu应该这样定义：<br>
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
    		btn11.setName("精品靓衣");
    		btn11.setType("view");
    		btn11.setUrl("http://kongyd.duapp.com/clothes/clothesShop.jsp");
    		
    		NormalButton btn12 = new NormalButton();
    		btn11.setName("酷炫包包");
    		btn11.setType("view");
    		btn11.setUrl("http://kongyd.duapp.com/clothes/BagShop.jsp");

    		NormalButton btn21 = new NormalButton();
    		btn21.setName("新品推荐");
    		btn21.setType("view");
    		btn21.setUrl("http://kongyd.duapp.com/clothes/NewRecommand.jsp");
    	
    		NormalButton btn22 = new NormalButton();
    		btn22.setName("折扣专区");
    		btn22.setType("view");
    		btn22.setUrl("http://kongyd.duapp.com/clothes/discount.jsp");

    		NormalButton btn23 = new NormalButton();
    		btn23.setName("新品预告");
    		btn23.setType("click");
    		btn23.setKey("23");

    		NormalButton btn31 = new NormalButton();
    		btn31.setName("关于我们");
    		btn31.setType("click");
    		btn31.setKey("31");

    		NormalButton btn32 = new NormalButton();
    		btn32.setName("温馨提示");
    		btn32.setType("click");
    		btn32.setKey("32");

//    		NormalButton btn33 = new NormalButton();
//    		btn33.setName("幽默笑话");
//    		btn33.setType("click");
//    		btn33.setKey("1");

    		ComplexButton mainBtn1 = new ComplexButton();
    		mainBtn1.setName("买买买");
    		mainBtn1.setSub_button(new NormalButton[] { btn11,btn12});

    		ComplexButton mainBtn2 = new ComplexButton();
    		mainBtn2.setName("逛逛逛");
    		mainBtn2.setSub_button(new NormalButton[] { btn21, btn22, btn23});

    		ComplexButton mainBtn3 = new ComplexButton();
    		mainBtn3.setName("看看看");
    		mainBtn3.setSub_button(new NormalButton[] { btn31, btn32});

    		Menu menu = new Menu();
    		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
             
    		return menu;
    	}
}


