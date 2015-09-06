package com.phome.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phome.one.MycreateMenu;

@SuppressWarnings("serial")
public class CreateMenu extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String flag=request.getParameter("flag");
		try {
			int para = 0;
			String result;
			if(flag.equals("zhubao")){
			para=MycreateMenu.create(flag);
			if(para==0)result="珠宝成功";
			}
			if(flag.equals("yifu")){
			para=MycreateMenu.create(flag);	
			if(para==0)result="衣服成功";
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.print("    This is ");
			out.print(this.getClass());
			out.println(", using the GET method");
			out.println(", and the result is"+para);
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           
		String flag=request.getParameter("flag");
		try {
			int para=0;
			if(flag.equals("zhubao")){
			para=MycreateMenu.create(flag);
			}
			if(flag.equals("yifu")){
			para=MycreateMenu.create(flag);	
			}
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.print("the flag is :"+flag);
			out.print(this.getClass());
			out.println(", using the POST method");
			out.println(", and the result is"+para);
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
