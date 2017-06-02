//banner
var bannerNum = 1;
var t=self.setInterval("banner_auto()",2000);
var newsNewsClick=0;
var newsDynamicClick=0;
function  banner_auto(){
	bannerNum ++;
	if(bannerNum == 4){
		bannerNum = 1;
	}
	document.getElementById("banner").src = "img/banner"+bannerNum+".jpg";
	document.getElementById("bannerN"+bannerNum).style.backgroundColor = "#00408f";
	if (bannerNum==1) {
		document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	} else if(bannerNum==2){
		document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	} else if(bannerNum==3){
		document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
	}
}
function banner_before(){
	bannerNum --;
	if(bannerNum == 0){
		bannerNum = 3;
	}
	document.getElementById("banner").src = "img/banner"+bannerNum+".jpg";
	document.getElementById("bannerN"+bannerNum).style.backgroundColor = "#00408f";
	if (bannerNum==1) {
		document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	} else if(bannerNum==2){
		document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	} else if(bannerNum==3){
		document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
	}
}
function banner_next(){
	bannerNum ++;
	if(bannerNum == 4){
		bannerNum = 1;
	}
	document.getElementById("banner").src = "img/banner"+bannerNum+".jpg";
	document.getElementById("bannerN"+bannerNum).style.backgroundColor = "#00408f";
	if (bannerNum==1) {
		document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	} else if(bannerNum==2){
		document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	} else if(bannerNum==3){
		document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
		document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
	}
}
function bannerNum1(){
	document.getElementById("banner").src = "img/banner1.jpg";
	document.getElementById("bannerN1").style.backgroundColor = "#00408f";
	document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
	document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	bannerNum = 1;
}
function bannerNum2(){
	document.getElementById("banner").src = "img/banner2.jpg";
	document.getElementById("bannerN2").style.backgroundColor = "#00408f";
	document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
	document.getElementById("bannerN3").style.backgroundColor = "#aaaaaa";
	bannerNum = 2;
}
function bannerNum3(){
	document.getElementById("banner").src = "img/banner3.jpg";
	document.getElementById("bannerN3").style.backgroundColor = "#00408f";
	document.getElementById("bannerN1").style.backgroundColor = "#aaaaaa";
	document.getElementById("bannerN2").style.backgroundColor = "#aaaaaa";
	bannerNum = 3;
}
function bannerContinue(){
	t=self.setInterval("banner_auto()",2000);
}
function bannerPause(){
	window.clearInterval(t);
}

//about
function aboutMedalOver(){
	document.getElementById("imgMedal").src = "img/iconfont-gongsizizhiWhite.png";
	document.getElementById("aboutMedal").style.backgroundColor = "#00408f";
	document.getElementById("aboutMedalH").style.color = "#FFFFFF";
}
function aboutMedalOut(){
	document.getElementById("imgMedal").src = "img/iconfont-gongsizizhiGray.png";
	document.getElementById("aboutMedal").style.backgroundColor = "#FFFFFF";
	document.getElementById("aboutMedalH").style.color = "#000000";
}
function aboutBooksOver(){
	document.getElementById("imgBooks").src = "img/iconfont-iconfontzhishikuWhite.png";
	document.getElementById("aboutBooks").style.backgroundColor = "#00408f";
	document.getElementById("aboutBooksH").style.color = "#FFFFFF";
}
function aboutBooksOut(){
	document.getElementById("imgBooks").src = "img/iconfont-iconfontzhishikuGray.png";
	document.getElementById("aboutBooks").style.backgroundColor = "#FFFFFF";
	document.getElementById("aboutBooksH").style.color = "#000000";
}
function newBoxUp(){
	document.getElementById("sbox").style.webkitTransform="translateY(0px)";
	document.getElementById("sbox").style.transition="0.5s";
	document.getElementById("newsNews").style.width="168px";
	document.getElementById("newsDynamic").style.width="155px";
	newsNewsClick=1;
	newsDynamicClick=0;
}
function newBoxDown(){
	document.getElementById("sbox").style.webkitTransform="translateY(-319px)";
	document.getElementById("sbox").style.transition="0.5s";
	document.getElementById("newsNews").style.width="155px";
	document.getElementById("newsDynamic").style.width="168px";
	newsNewsClick=0;
	newsDynamicClick=1;
}
function newBoxWidthAdd(id){
	document.getElementById(id).style.width="168px";
}
function newBoxWidthDec(id){
	if(id=="newsNews" && newsNewsClick==0){
		document.getElementById(id).style.width="155px";
	}
	if(id=="newsDynamic" && newsDynamicClick==0){
		document.getElementById(id).style.width="155px";
	}
	
}
function friendUlMoveOver(){
	document.getElementById("friendUl").style.zIndex="10";
}
function friendUlMoveOut(){
	document.getElementById("friendUl").style.zIndex="-1";
}
