package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Service.QingHaiService;
import com.neusoft.Service.Impl.MessageServiceImpl;
import com.neusoft.bean.Message;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		Message mes = new Message(username,telephone,email,address,message);
		QingHaiService service = new MessageServiceImpl<Message>();
		if(service.insert(mes)>0){
			response.sendRedirect("http://127.0.0.1:8020/webDemo1/onlineTalk.html");
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
