package webChat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.ChatDaoImpl;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username").trim();
		String talkContent = request.getParameter("content").trim();
		if(username==null||"".equals(username)){
			username="ÄäÃû";
		}
		
		ChatDaoImpl dao = new ChatDaoImpl();
		int count = dao.findCount();
		if(count==-1){
			System.out.println("error");
		}else if(count<20){
			dao.insert(username, talkContent);
			System.out.println("inset success");
			response.sendRedirect("chat.html");
		}else{
			dao.update(username, talkContent);
			System.out.println("update success");
			response.sendRedirect("chat.html");
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
