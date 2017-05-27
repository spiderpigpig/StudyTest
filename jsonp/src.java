package com.neusoftTest.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/src.do")
public class src extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3157277662632487459L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		resp.setContentType("application/javascript;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String json = "{\"id\":126}";
		String callBack = req.getParameter("callBack");
		json = callBack + "(" + json + ")";
		pw.write(json);
		pw.flush();
		pw.close();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}

}
