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

//                String s ="{'button':[{'type':'view','name':'�����鱦','url':'http://www.baidu.com'},{'name':'�����꿨','sub_button':[{'type':'view','name':'��ʼѡ��','url':'http://www.taobao.com'},{'type':'click','name':'�����꿨','key':'3'},{'type':'click','name':'���ǵ��꿨','key':'4'}]},{'name':'��������','sub_button':[{'type':'click','name':'��ϵ��ʽ','key':'2'},{'type':'click','name':'���д���','key':'5'}]}]}";
//                //"{\"button\":[{\"type\":\"view\",\"name\":\"�����鱦\",\"url\":\"http://www.baidu.com\"},{\"name\":\"�����꿨\",\"sub_button\":[{\"type\":\"view\",\"name\":\"��ʼѡ��\",\"url\":\"http://www.taobao.com\"},{\"type\":\"click\",\"name\":\"�����꿨\",\"key\":\"3\"},{\"type\":\"click\",\"name\":\"���ǵ��꿨\",\"key\":\"4\"}]},{\"name\":\"��������\",\"sub_button\":[{\"type\":\"click\",\"name\":\"��ϵ��ʽ\",\"key\":\"2\"},{\"type\":\"click\",\"name\":\"���д���\",\"key\":\"5\"}]}]}";
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


