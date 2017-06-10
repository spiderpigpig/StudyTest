
$(function() {
	
	timer();
	window.setInterval(timer,1000);
	
	function timer() {
		var lis = $("li");
		$.ajax({url:"AjaxServlet",success:function(result){
			var result = eval(result);
			for (var index = 0; index < result.length; index++) {
				//alert();
				var date = new Date(result[index].talkDate);
				var month = date.getMonth()+1;
				var day = date.getDate();
				var hour = date.getHours();
				var min = date.getMinutes();
				var sec = date.getSeconds();
				if(hour<10)hour="0"+hour;
				if(min<10)min="0"+min;
				if(sec<10)sec="0"+sec;
				if(day!=new Date().getDate()){
					if(month<10)month="0"+month;
					if(day<10)day="0"+day;
					date = month+"月"+day+"日"+hour+":"+min+":"+sec;
				}else{
					date = hour+":"+min+":"+sec;
				}
				if(index<lis.length){
					lis.eq(index).html("<span>"+date+"</span><br/><b>"+result[index].username+"</b> : "+result[index].talkContent);
				}else{
					$(".talkContent").append($("<li><span>"+date+"</span><br/><b>"+result[index].username+"</b> : "+result[index].talkContent+"</li>"));
				}
				$("body").scrollTop(9999);
			}
		}});
		
	}
	
});
