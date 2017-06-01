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
<title>添加新闻</title>
</head>
<body>


<h3>添加新闻</h3>
<form action="NewsInsertServlet" method="post">
标题：<input style="width: 580px" type="text"  name="title"/><br>
内容：<textarea rows="20" cols="80" name="newsContent"></textarea>
<button>提交</button>
</form>

</body>
</html>