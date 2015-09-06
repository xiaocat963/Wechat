package com.phome.servlet;


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

public class Mytest {

        

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
					String secret = "8deb08f1ceea4b73e2866eebef97c23f";
					String accessToken = getAccessToken(appid, secret);
					return 0;
                
        }
        
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


     public static void main(String[] args) {
    	 String appid = "wxa9addeb101adbb61";
    	 String secret = "6517648b4c02049a2af5c9018bcb16ed";
    	 try {
			getAccessToken(appid,secret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


