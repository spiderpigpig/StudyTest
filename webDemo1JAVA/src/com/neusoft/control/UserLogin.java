package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.neusoft.Service.Impl.UserServiceImpl;
import com.neusoft.bean.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String password = request.getParameter("password");
		if(username!=null && !username.trim().equals("") && password!=null && !password.trim().equals("")){
			UserServiceImpl service = new UserServiceImpl();
			List<User> list = service.check(username,password);
			if(list.size()!=0){
				System.out.println(username+"登录成功");
				User user = list.get(0);
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				//request.getRequestDispatcher("manage.jsp").forward(request, response);
				response.sendRedirect("manage.jsp");
			}else{
				System.out.println("登录失败");
				PrintWriter pw = response.getWriter();
				pw.write("<script>alert(\"用户名或密码错误\");window.location.href=\"http://127.0.0.1:8020/webDemo1/login.html\"; </script>");
				pw.flush();
				pw.close();
				
			}
		} else{
			System.out.println("用户名或密码为空");
			response.sendRedirect("http://127.0.0.1:8020/webDemo1/login.html");
			
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
