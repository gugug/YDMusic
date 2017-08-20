package ydmusic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ydmusic.web.dao.MySQLUser;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MySQLUser userDao = new MySQLUser();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String telnumber = request.getParameter("telnumber");

		System.out.println("username=" + username);
		System.out.println("password=" + password);
		System.out.println("telnumber" + telnumber);
		
        String name = new String(username.getBytes("iso-8859-1"),"utf-8");
        String pwd = new String(password.getBytes("iso-8859-1"),"utf-8");

        System.out.println("name=" + name);
        System.out.println("pwd=" + pwd);


		String registermsg = null;
		if (username != null && password != null&&telnumber!=null) {
			boolean addUserRs = userDao.addUser(name, pwd, telnumber);
			if (addUserRs) {
				registermsg = "OK";
			} else {
				registermsg = "NOK";
			}
		}else{
			registermsg = "NOK";
		}
		out.println(registermsg);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
