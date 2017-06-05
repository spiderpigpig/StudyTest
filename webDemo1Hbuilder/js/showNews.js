
var thisURL = document.URL;    
var  getval =thisURL.split('?')[1];
var listID= getval.split("=")[1];
//alert(JSON.parse(news).title);
//alert(news);
//init();
//getShowNews2();
function init() {
	//跨域请求
	var _script = document.createElement('script');
	_script.setAttribute("src","http://localhost:8080/webDemo1/ShowNewsServlet?callBack=getShowNews&newsID="+newsID);
	var _html = document.getElementsByTagName('html')[0];
	_html.appendChild(_script);
	
}

function getShowNews(ret) {
	//alert(ret.title);
	var title = document.getElementById("newsTitle");
	title.innerHTML=ret.title;
	var HtmlNewsDate = document.getElementById("newsDate");
	var newsDate = new Date(ret.newsDate);
	var year = newsDate.getFullYear();
	var month = (newsDate.getMonth()+1)<10?"0"+(newsDate.getMonth()+1):(newsDate.getMonth()+1);
	var day = newsDate.getDate()<10?"0"+newsDate.getDate():newsDate.getDate();
	HtmlNewsDate.innerHTML=year+"-"+month+"-"+day+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	var newsContent = document.getElementById("newsContent");
	newsContent.innerHTML=ret.newsContent;
}

function getShowNews2() {
	
	var str = sessionStorage.news;
	//alert(str);
	var retList = JSON.parse(str);
	var ret = retList[listID];
	//alert(ret.title);
	var title = document.getElementById("newsTitle");
	title.innerHTML=ret.title;
	
	var HtmlNewsDate = document.getElementById("newsDate");
	var newsDateStr = ret.newsDateStr;
	var newsDate = new Date(ret.newsDate);
	var year = newsDate.getFullYear();
	var month = (newsDate.getMonth()+1)<10?"0"+(newsDate.getMonth()+1):(newsDate.getMonth()+1);
	var day = newsDate.getDate()<10?"0"+newsDate.getDate():newsDate.getDate();
	//HtmlNewsDate.innerHTML=year+"-"+month+"-"+day+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	HtmlNewsDate.innerHTML=newsDateStr+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	var newsContent = document.getElementById("newsContent");
	newsContent.innerHTML=ret.newsContent;
	
}