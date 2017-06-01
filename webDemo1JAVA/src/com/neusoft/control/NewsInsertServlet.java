package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class NewsDetUptServlet
 */
@WebServlet("/NewsInsertServlet")
public class NewsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsInsertServlet() {
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
		String title = request.getParameter("title");
		String newsContent = request.getParameter("newsContent");
		QingHaiService service = new NewsServiceImpl<>();
		News news = new News(title, newsContent);
		if(service.insert(news)>0){
			System.out.println("������ӳɹ�");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert(\"������ӳɹ�\");window.location.href=\"http://localhost:8080/webDemo1/manage.jsp\"; </script>");
			pw.flush();
			pw.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
