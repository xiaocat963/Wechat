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
 * 处理微信服务器请求的Servlet URL地址：http://xxx/weixin/dealwith.do
 * 
 * 注意：官方文档限制使用80端口哦！
 * 
 * @author marker
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
public class Wechat extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
     
    public Wechat() {  }
     
     
    //TOKEN 是你在微信平台开发模式中设置的哦
    public static final String TOKEN = "kongyd";
 
    /**
     * 处理微信服务器验证
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");// 随机字符串
 
        // 重写totring方法，得到三个参数的拼接字符串
        List<String> list = new ArrayList<String>(3) {
            private static final long serialVersionUID = 2621444383666420433L;
            public String toString() {
                return this.get(0) + this.get(1) + this.get(2);
            }
        };
        list.add(TOKEN);
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);// 排序
        String tmpStr = new MySecurity().encode(list.toString(),
                MySecurity.SHA_1);// SHA-1加密
        Writer out = response.getWriter();
        if (signature.equals(tmpStr)) {
            out.write(echostr);// 请求验证成功，返回随机码
        } else {
            out.write("");
        }
        out.flush();
        out.close();
    }
 
     
    /**
     * 处理微信服务器发过来的各种消息，包括：文本、图片、地理位置、音乐等等
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
                System.out.println("收到微信消息："+msg.getContent());
                if("1".equals(msg.getContent())){
                    Msg4Text rmsg = new Msg4Text();
                    rmsg.setFromUserName(msg.getToUserName());
                    rmsg.setToUserName(msg.getFromUserName());
                    //rmsg.setFuncFlag("0");
                    rmsg.setContent("欢迎光临！");
                    session.callback(rmsg);
                    return;
                } 
                 
                else if("2".equals(msg.getContent())){
                    Msg4Text rmsg = new Msg4Text();
                    rmsg.setFromUserName(msg.getToUserName());
                    rmsg.setToUserName(msg.getFromUserName());
                    //rmsg.setFuncFlag("0");
                    rmsg.setContent("地址：普洱市华尔兹广场A座6号伟跃缘珠宝。         联系电话：13577974477");
                    session.callback(rmsg);
                    return;
                } 
                
                else if("3".equals(msg.getContent())){
                //回复一条消息
                Data4Item d1 = new Data4Item("", "测试描述", "http://cms.yl-blog.com/themes/blue/images/logo.png", "cms.yl-blog.com"); 
                //Data4Item d2 = new Data4Item("雨林博客", "测试描述", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com"); 
                //Data4Item d3 = new Data4Item("kongyd", "测试描述", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com");   
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
                    //回复一条消息
                    Data4Item d1 = new Data4Item("本店玛卡产品", "本店玛卡产品", "/weixinPic/3-1.jpg", "/ourMaka.jsp"); 
                    //Data4Item d2 = new Data4Item("雨林博客", "测试描述", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com"); 
                    //Data4Item d3 = new Data4Item("kongyd", "测试描述", "http://www.yl-blog.com/template/ylblog/images/logo.png", "www.yl-blog.com");   
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
                    rmsg.setContent("诚招各级合作销售、代理商，详情咨询13577974477");
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
         
        //必须调用这两个方法
                //如果不调用close方法，将会出现响应数据串到其它Servlet中。
        session.process(is, os);//处理微信消息 
        session.close();//关闭Session
    }
 
}
