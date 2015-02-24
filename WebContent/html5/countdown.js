/**
 * 
 */

var count = 60;
var timer = null;

function init()
{
	var btnCountdown = document.getElementById("btn-countdown");
	btnCountdown.onclick = btnCountDownClick;
}



function countDown(){ //연산을해주는 역할, 역할을 따로따로
	
	var IblCount = document.getElementById("Ibl-count");
	
	IblCount.innerText= --count;
	
	if(count>0)
		setTimeout(countDown, 1000);	
}

function btnCountDownClick() { //이벤트함수라는걸 알수있도록 click... handler..요런거 붙여주자 //클릭받아오는역할	
	if(timer==null)
	timer=setTimeout(countDown, 1000);//1초후에 실행
	
	//setInterval(countDown, 1000); // 1초마다,, 이것보단 타임아웃을 다시 사용하는 것을 쓴다. 클릭할때만다 객체를 만들어줌
}
	
window.onload = init;