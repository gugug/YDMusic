package ydmusic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ydmusic.web.dao.MySQLUser;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MySQLUser userDao = new MySQLUser();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
//        response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");     
        String password = request.getParameter("password");        
//        Map<String, String[]> parameterMap = request.getParameterMap();
        //服务器端打印信息  
        System.out.println("username=" + username);  
        System.out.println("password=" + password);
        
        String name = new String(username.getBytes("iso-8859-1"),"utf-8");
        String pwd = new String(password.getBytes("iso-8859-1"),"utf-8");
        
        String loginmsg = null;
        if (username!=null&&password!=null){
        	boolean user = this.userDao.isUser(name, pwd);
        	if (user){
        		loginmsg = "OK";
        	}else{
        		loginmsg = "NOK";
        	}
        }else{
    		loginmsg = "NOK";
        }
        System.out.println(loginmsg);
		out.println(loginmsg);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
