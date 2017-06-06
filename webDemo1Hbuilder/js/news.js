init();

function init() {
	//跨域请求
	var _script = document.createElement('script');
	_script.setAttribute("src","http://localhost:8080/webDemo1/NewsServlet?callBack=getNews");
	var _html = document.getElementsByTagName('html')[0];
	_html.appendChild(_script);

}
//function _onclick(a){
//	//alert(a.title);
//	var str1 =JSON.stringify(a);
//	sessionStorage.newss=str1;
//}
function getNews(ret) {
	var ul=document.getElementById("news_list");
	// 将json字符串转成json对象
	var str =JSON.stringify(ret);
	//ret = eval(ret);
	for(var i = 0; i < ret.length; i++) {
		
		var li = document.createElement("li");
		ul.appendChild(li);
		
		var a = document.createElement("a");
		a.href="showNews.html?listID="+i;

		var strNews=JSON.stringify(ret[i]);
		//a.setAttribute("onclick","_onclick("+strNews+")");
		
		sessionStorage.news=str;
		li.appendChild(a);
		
		var div= document.createElement("div");
		div.className="time";
		a.appendChild(div);
		
		var b_div=document.createElement("b");
		div.appendChild(b_div);
		var day = new Date(ret[i].newsDate).getDate()<10?"0"+new Date(ret[i].newsDate).getDate():new Date(ret[i].newsDate).getDate();
		b_div.innerHTML=day;
		var i_div=document.createElement("i");
		div.appendChild(i_div);
		var year=new Date(ret[i].newsDate).getFullYear();
		var month = (new Date(ret[i].newsDate).getMonth()+1)<10?("0"+(new Date(ret[i].newsDate).getMonth()+1)):(new Date(ret[i].newsDate).getMonth()+1);
		i_div.innerHTML=year+"-"+month;
		
		var h3=document.createElement("h3");
		a.appendChild(h3);
		h3.innerHTML=ret[i].title;
		
		var p = document.createElement("p");
		a.appendChild(p);
		p.innerHTML= ret[i].newsContent.length<=70 ? ret[i].newsContent : ret[i].newsContent.substring(0,70)+"...";
		var b = document.createElement("b");
		b.className="more";
		li.appendChild(b);
		b.innerHTML="+";
		
		//li.innerHTML = ret[i].bookName;
	}
	//创建ul
}