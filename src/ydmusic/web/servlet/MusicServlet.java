package ydmusic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ydmusic.web.dao.MySQLMusic;
import ydmusic.web.po.Music;

/**
 * Servlet implementation class MusicServlet
 */
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MySQLMusic musicDao = new MySQLMusic();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().append("Served at: 开始").append(request.getContextPath());
		String paramid = request.getParameter("mid");
		String paraname = request.getParameter("sn");
		String aname = request.getParameter("an");

		System.out.println("paramid"+paramid);
		System.out.println("paraname"+paraname);
		System.out.println("aname"+aname);


		PrintWriter out = response.getWriter();
		Object resultobj = null;
		
		try {
			if (paramid==null && paraname==null&&aname==null){
				resultobj = this.musicDao.getMusics();
			}else if (paramid != null){
				resultobj = this.musicDao.getMusicById(paramid);
			}else if (paraname!=null && aname==null){
				resultobj = this.musicDao.getMusicByName(paraname);
			}else{
				resultobj = this.musicDao.getMusicByNames(paraname,aname);
			}
		if (resultobj!=null) {
			 System.out.println(JSON.toJSON(resultobj));
			 out.println(JSON.toJSON(resultobj));
		} else {
			out.println("No result!");
		}
		out.flush();
//			response.getWriter().write("你好");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter out = response.getWriter();

	}

}
