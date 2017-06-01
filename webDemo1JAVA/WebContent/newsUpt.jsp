<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.List"%>
<%@page import="com.neusoft.Service.Impl.NewsServiceImpl"%>
<%@page import="com.neusoft.Service.QingHaiService"%>
<%@page import="com.neusoft.bean.News"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻</title>
</head>
<body>
<%
String newsID = request.getParameter("newsID");
QingHaiService service = new NewsServiceImpl();

if(newsID!=null){
	String where = "WHERE NEWSID="+newsID;
	List<News> list = service.findAll(where);
	News news = list.get(0);
	pageContext.setAttribute("news", news);
}
%>

<h3>修改新闻</h3>
<form action="NewsUptServlet?newsID=${news.newsID }" method="post">
标题：<input style="width: 580px" type="text" value="${news.title }" name="title"/><br>
内容：<textarea rows="20" cols="80" name="newsContent">${news.newsContent }</textarea>
<button>提交</button>
</form>

</body>
</html>