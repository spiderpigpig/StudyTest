package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet Filter implementation class UserCheckFilter
 */
@WebFilter("/*")
public class UserCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getServletPath().equals("/UserLogin")||httpServletRequest.getServletPath().equals("/NewsServlet")||session.getAttribute("user")!=null){
			// pass the request along the filter chain
			System.out.println(httpServletRequest.getServletPath());
			System.out.println(session.getAttribute("user"));
			chain.doFilter(request, response);
		}else{
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert(\"请不要强行登陆\");window.location.href=\"http://127.0.0.1:8020/webDemo1/login.html\";</script>");
			pw.flush();
			pw.close();
			//httpServletResponse.sendRedirect("http://127.0.0.1:8020/webDemo1/login.html");
			
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
