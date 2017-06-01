<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.neusoft.Service.Impl.NewsServiceImpl"%>
<%@page import="com.neusoft.bean.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.neusoft.Service.Impl.MessageServiceImpl"%>
<%@page import="com.neusoft.Service.QingHaiService"%>
<%@page import="com.neusoft.bean.User"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<% 	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	User user = (User)request.getAttribute("user"); 
	int status = 1;
	if(user!=null){
		status = user.getStatus();
		
	}else{
		status = (int)session.getAttribute("status");
	}
	session.setAttribute("status", status);
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理 - 青海高端盐湖科技有限公司</title>
	</head>
	<style>
		div,h1,a,input{
			font-family: "宋体";
		}
		body{
			justify-content: center;
			display: flex;
		}
		.body{
			width: 802px;
			height: auto;
			border: 1px solid black;
		}
		.title{
			height: 100px;
			justify-content: center;
			align-items: center;
			display: flex;
			border: 1px solid black;
		}
		.leftChoice{
			float: left; 
			width: 100px;height: auto;
			border: 1px solid black;
		}
		.rightText{
			width: 800px;height: auto;
			border: 1px solid black;
		}
		.button{
			width: 100%;
			height: 50px;background-color: gainsboro;
		}
		.buttonReg{
			width: 100%;
			height: 50px;background-color: gainsboro;
			display:${status==1?"block":"none"};
			
		}
		#rifhtNews{
			display: block;
		}
		#rifhtMessage{
			display: none;
		}
		#rifhtReg{
			display: none;text-align: center;padding: 80px;line-height: 40px;
		}
		.newsli{
			border: 1px solid black;margin-left: 90px;
		}
	</style>
	<script>
		function clickNews(){
			document.getElementById("rifhtNews").style.display="block";
			document.getElementById("rifhtMessage").style.display="none";
			document.getElementById("rifhtReg").style.display="none";
			document.getElementById("button1").style.backgroundColor="gray";
			document.getElementById("button2").style.backgroundColor="gainsboro";
			document.getElementById("button3").style.backgroundColor="gainsboro";
		}
		function clickMessage(){
			document.getElementById("rifhtNews").style.display="none";
			document.getElementById("rifhtMessage").style.display="block";
			document.getElementById("rifhtReg").style.display="none";
			document.getElementById("button1").style.backgroundColor="gainsboro";
			document.getElementById("button2").style.backgroundColor="gray";
			document.getElementById("button3").style.backgroundColor="gainsboro";
		}
		function clickReg(){
			document.getElementById("rifhtNews").style.display="none";
			document.getElementById("rifhtMessage").style.display="none";
			document.getElementById("rifhtReg").style.display="block";
			document.getElementById("button1").style.backgroundColor="gainsboro";
			document.getElementById("button2").style.backgroundColor="gainsboro";
			document.getElementById("button3").style.backgroundColor="gray";
		}
	</script>
	<body>
		<div class="leftChoice">
			<input id="button1" class="button" type="button" onclick="clickNews()" value="新闻" /><br />
			<input id="button2" class="button" type="button" onclick="clickMessage()" value="查看留言" /><br />
			<input id="button3" class="buttonReg" type="button" onclick="clickReg()" value="注册" /><br />
			<a href="http://127.0.0.1:8020/webDemo1/login.html"><input class="button" type="button"  value="退出" /></a>
			
		</div>
		<div class="body">
		
			<div class="title">
				<h1>欢迎登录后台管理系统</h1>
			</div>
			
			<div class="rightText">
				<div id="rifhtNews">
					<a href="newsInsert.jsp"><button>添加新闻</button></a>
					<hr>
					<%
					QingHaiService newsService = new NewsServiceImpl();
					List<Message> newsList = newsService.findAll("ORDER BY NEWSDATE DESC");
					pageContext.setAttribute("newsList", newsList);
					%>
					
					<ol>
						<c:forEach items="${newsList}" var="news">
							<li>
								<a href="NewsDetServlet?newsID=${news.newsID }"><button>删除</button></a>
								<a href="newsUpt.jsp?newsID=${news.newsID }"><button>修改</button></a>
								<h4>标题：${news.title}</h4>
								<p>时间：${news.newsDate}</p>
								<p>内容：${news.newsContent}</p>
								<hr>
							</li>
						</c:forEach>
					</ol>
				</div>
				<div id="rifhtMessage">
				<table border="1px">
					<tr><th>序号</th><th>姓名</th><th>电话</th><th>邮箱</th><th>地址</th><th>留言内容</th><th>留言时间</th><th>功能</th></tr>
					<%
					QingHaiService mesService = new MessageServiceImpl();
					
					List<Message> mesList = mesService.findAll("ORDER BY MESSAGEDATE DESC");
					pageContext.setAttribute("mesList", mesList);
					%>
					<c:forEach items="${mesList}" var="mes">
						<tr>
						<td>${mes.messageid}</td><td>${mes.username}</td><td>${mes.telephone}</td><td>${mes.email}</td><td>${mes.address}</td><td>${mes.message}</td><td>${mes.messageDate}</td>
						<td><a href="MessageDeleteServlet?messageID=${mes.messageid}"><button>删除</button></a></td>
						</tr>
					</c:forEach>
				</table>
				</div>
				<div id="rifhtReg">
					<form action="http://localhost:8080/webDemo1/UserReg" method="post">
						用户名：<input type="text" name="username"/><br />
						密&nbsp;码：<input type="text" name="password"/><br />
						<input type="submit" value="注册"/>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
