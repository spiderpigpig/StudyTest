package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Service.QingHaiService;
import com.neusoft.Service.Impl.MessageServiceImpl;

/**
 * Servlet implementation class MessageDeleteServlet
 */
@WebServlet("/MessageDeleteServlet")
public class MessageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageDeleteServlet() {
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
		String messageID = request.getParameter("messageID");
		System.out.println(messageID);
		QingHaiService service = new MessageServiceImpl();
		String where = "MESSAGEID="+messageID;
		if(service.delete(where)>0){
			System.out.println("删除成功");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert(\"删除成功\");window.location.href=\"http://localhost:8080/webDemo1/manage.jsp\"; </script>");
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
