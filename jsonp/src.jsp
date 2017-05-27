<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>

<script type="text/javascript">
function _aaa() {
	var _script = document.createElement('script');
	_script.setAttribute("src","http://www.spider.com:8080/spider/src.do?callBack=getResult");
	var _html = document.getElementsByTagName('html')[0];
	_html.appendChild(_script);
}
function getResult(result) {
	//result = eval(result);
	alert(result.id);
}
</script>
<!-- <script type="text/javascript" src="http://www.spider.com:8080/spider/jjj.js"></script> -->
<body>
<h1>你好我是测试</h1>
<button onclick="_aaa()">获取远程src</button>
</body>
</html>