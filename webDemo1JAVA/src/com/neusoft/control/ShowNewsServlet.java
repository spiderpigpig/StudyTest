package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neusoft.Service.QingHaiService;
import com.neusoft.Service.Impl.NewsServiceImpl;
import com.neusoft.bean.News;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/ShowNewsServlet")
public class ShowNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		String newsID = request.getParameter("newsID");
		System.out.println(newsID);
		PrintWriter pw = response.getWriter();
		QingHaiService<News> service = new NewsServiceImpl<>();
		List<News> list = service.findAll("WHERE NEWSID="+newsID);
		//String callBack = request.getParameter("callBack");
		String json = "getShowNews("+JSON.toJSONString(list.get(0))+")";
		pw.write(json);
		pw.write("<script>window.location.href=\"http://127.0.0.1:8020/webDemo1/showNews.html\"; </script>");
		System.out.println(json);
		
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
