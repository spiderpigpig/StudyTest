package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.Service.QingHaiService;
import com.neusoft.Service.Impl.UserServiceImpl;
import com.neusoft.bean.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
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
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		if(username!=null && !username.equals("") && password!=null && !password.equals("")){
			UserServiceImpl service = new UserServiceImpl();
			String where = "WHERE USERNAME='"+username+"'";
			if(service.findAll(where).size()!=0){
				System.out.println("���ݿ����"+username);
				pw.write("<script>alert(\"�û����Ѵ���\");window.location.href=\"http://localhost:8080/webDemo1/manage.jsp\"; </script>");
				
			}else{
				User user = new User(username,password,0);
				if(service.insert(user)>0){
					System.out.println(username+"ע��ɹ�");
					pw.write("<script>alert(\"ע��ɹ�\");window.location.href=\"http://127.0.0.1:8020/webDemo1/login.html\"; </script>");
				}else{
					System.out.println("ע��ʧ��");
				}
			}
		} else{
			System.out.println("�û���������Ϊ��");
			pw.write("<script>alert(\"�û���������Ϊ��\");window.location.href=\"http://localhost:8080/webDemo1/manage.jsp\"; </script>");
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
