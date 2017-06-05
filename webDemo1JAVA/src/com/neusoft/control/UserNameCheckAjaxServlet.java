package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Dao.Impl.QingHaiDaoImpl;
import com.neusoft.Service.QingHaiService;
import com.neusoft.Service.Impl.UserServiceImpl;

/**
 * Servlet implementation class UserNameCheckAjaxServlet
 */
@WebServlet("/UserNameCheckAjaxServlet")
public class UserNameCheckAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameCheckAjaxServlet() {
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
		String username = request.getParameter("username");
		QingHaiService service = new UserServiceImpl();
		String where = "WHERE USERNAME='"+username+"'";
		PrintWriter pw = response.getWriter();
		if(username.trim().equals("")){
			pw.write("�û�������Ϊ��");
		}else if(service.findAll(where).size()>0){
			pw.write("�û����Ѵ���");
		}else{
			pw.write("�û�������ʹ��");
		}
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
