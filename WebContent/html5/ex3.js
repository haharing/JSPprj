/**
 * 
 */

function init(){
	var p1 = document.getElementById("p1");
		p1.onclick=textClick;
	
	var p2 = document.getElementById("p2");
		p2.onclick=imgClick;
		
	var p3 = document.getElementById("p3");
		p3.onclick=delClick;
		
	var p4 = document.getElementById("p4");
		p4.onclick=copyClick;
}

function textClick(){
	var txt = document.createTextNode("안녕하세요");
	var div1=document.getElementById("div1");
	
	div1.appendChild(txt);
	
}

function imgClick(){
	var img1 = document.createElement("img");
	var div1=document.getElementById("div1");
	img1.src="지성.jpg";
	
	div1.appendChild(img1);	
}

function delClick(){
	
	
	 //삭제할 노드를 가지고 있는 부모 엘리먼트 노드 선택	
	var div1=document.getElementById("div1"); 
	
	//삭제할 (텍스트) 노드 선택
	var txt=div1.lastChild;
	
	//(텍스트)노드를 삭제하기	
	div1.removeChild(txt);
}

function copyClick(){
	
	
	 //복제할 노드를 선택	
	var div1=document.getElementById("div1"); 
	
	//노드를 복제
	var clone = div1.cloneNode(true);
	
	//복제한 노드를 삽일할 노드 선택
	
	var target = document.body;
	
	//복제한 노드를 target에 추가
	target.appendChild(clone);
	
}
window.onload=init;