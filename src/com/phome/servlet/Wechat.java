package com.phome.servlet;
 
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.marker.weixin.DefaultSession;
import org.marker.weixin.HandleMessageAdapter;
import org.marker.weixin.MySecurity;
import org.marker.weixin.msg.Data4Item;
import org.marker.weixin.msg.Msg4Image;
import org.marker.weixin.msg.Msg4ImageText;
import org.marker.weixin.msg.Msg4Text;
 
/**
 * ����΢�ŷ����������Servlet URL��ַ��http://xxx/weixin/dealwith.do
 * 
 * ע�⣺�ٷ��ĵ�����ʹ��80�˿�Ŷ��
 * 
 * @author marker
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
public class Wechat extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
     
    public Wechat() {  }
     
     
    //TOKEN ������΢��ƽ̨����ģʽ�����õ�Ŷ
    public static final String TOKEN = "kongyd";
 
    /**
     * ����΢�ŷ�������֤
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String signature = request.getParameter("signature");// ΢�ż���ǩ��
        String timestamp = request.getParameter("timestamp");// ʱ���
        String nonce = request.getParameter("nonce");// �����
        String echostr = request.getParameter("echostr");// ����ַ���
 
        // ��дtotring�������õ�����������ƴ���ַ���
        List<String> list = new ArrayList<String>(3) {
            private static final long serialVersionUID = 2621444383666420433L;
            public String toString() {
                return this.get(0) + this.get(1) + this.get(2);
            }
        };
        list.add(TOKEN);
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);// ����
        String tmpStr = new MySecurity().encode(list.toString(),
                MySecurity.SHA_1);// SHA-1����
        Writer out = response.getWriter();
        if (signature.equals(tmpStr)) {
            out.write(echostr);// ������֤�ɹ������������
        } else {
            out.write("");
        }
        out.flush();
        out.close();
    }
 
     
    /**
     * ����΢�ŷ������������ĸ�����Ϣ���������ı���ͼƬ������λ�á����ֵȵ�
     * 
     * 
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        InputStream is = request.getInputStream();
        OutputStream os = response.getOutputStream();
         
         
        final DefaultSession session = DefaultSession.newInstance(); 
         
        session.addOnHandleMessageListener(new HandleMessageAdapter(){
             
            @Override
            public void onTextMsg(Msg4Text msg) {
                System.out.println("�յ�΢����Ϣ��"+msg.getContent());
                if("1".equals(msg.getContent())){
                    Msg4Text rmsg = new Msg4Text();
                    rmsg.setFromUserName(msg.getToUserName());
                    rmsg.setToUserName(msg.getFromUserName());
                    //rmsg.setFuncFlag("0");
                    rmsg.setContent("��ӭ���٣�");
                    session.callback(rmsg);
                    return;
                } 
                 
                else if("2".equals(msg.getContent())){
                    Msg4Text rmsg = new Msg4Text();
                    rmsg.setFromUserName(msg.getToUserName());
                    rmsg.setToUserName(msg.getFromUserName());
                    //rmsg.setFuncFlag("0");
                    rmsg.setContent("��ַ���ն��л����ȹ㳡A��6��ΰԾԵ�鱦��         ��ϵ�绰��13577974477");
                    session.callback(rmsg);
                    return;
                } 
                
                else if("3".equals(msg.getContent())){
                //�ظ�һ����Ϣ
                Data4Item d1 = new Data4Item("", "��������", "http://cms.yl-blog.com/themes/blue/images/logo.png", "cms.yl-blog.com"); 
                //Data4Item d2 = new Data4Item("���ֲ���", "��������", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com"); 
                //Data4Item d3 = new Data4Item("kongyd", "��������", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com");   
                //Data4Item d4 = new Data4Item(title, description, picUrl, url)
                
                Msg4ImageText mit = new Msg4ImageText();
                mit.setFromUserName(msg.getToUserName());
                mit.setToUserName(msg.getFromUserName()); 
                mit.setCreateTime(msg.getCreateTime());
                mit.addItem(d1);
                //rmsg.setFuncFlag("0");
                session.callback(mit);
                return;
                }
                 
                else if("4".equals(msg.getContent())){
                    //�ظ�һ����Ϣ
                    Data4Item d1 = new Data4Item("�����꿨��Ʒ", "�����꿨��Ʒ", "/weixinPic/3-1.jpg", "/ourMaka.jsp"); 
                    //Data4Item d2 = new Data4Item("���ֲ���", "��������", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com"); 
                    //Data4Item d3 = new Data4Item("kongyd", "��������", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com");   
                    //Data4Item d4 = new Data4Item(title, description, picUrl, url)
                    
                    Msg4ImageText mit = new Msg4ImageText();
                    mit.setFromUserName(msg.getToUserName());
                    mit.setToUserName(msg.getFromUserName()); 
                    mit.setCreateTime(msg.getCreateTime());
                    mit.addItem(d1);
                    //rmsg.setFuncFlag("0");
                    session.callback(mit);
                    return;
                    }
                 
                if("5".equals(msg.getContent())){
                    Msg4Text rmsg = new Msg4Text();
                    rmsg.setFromUserName(msg.getToUserName());
                    rmsg.setToUserName(msg.getFromUserName());
                    //rmsg.setFuncFlag("0");
                    rmsg.setContent("���и����������ۡ������̣�������ѯ13577974477");
                    session.callback(rmsg);
                    return;
                } 
                else{
                	 Msg4Text rmsg = new Msg4Text();
                     rmsg.setFromUserName(msg.getToUserName());
                     rmsg.setToUserName(msg.getFromUserName());
                     //rmsg.setFuncFlag("0");
                     rmsg.setContent("1214");
                     session.callback(rmsg);
                     return;
                }
                 
            }
        });
         
        //�����������������
                //���������close���������������Ӧ���ݴ�������Servlet�С�
        session.process(is, os);//����΢����Ϣ 
        session.close();//�ر�Session
    }
 
}
