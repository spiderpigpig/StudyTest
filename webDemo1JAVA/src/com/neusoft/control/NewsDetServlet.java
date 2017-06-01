package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Service.QingHaiService;
import com.neusoft.Service.Impl.NewsServiceImpl;

/**
 * Servlet implementation class NewsDetUptServlet
 */
@WebServlet("/NewsDetServlet")
public class NewsDetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDetServlet() {
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
		QingHaiService service = new NewsServiceImpl<>();
		String where = "NEWSID="+newsID;
		if(service.delete(where)>0){
			System.out.println("新闻删除成功");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert(\"新闻删除成功\");window.location.href=\"http://localhost:8080/webDemo1/manage.jsp\"; </script>");
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
