/**
 * 
 */

function init(){
	var bImg = document.getElementById("b-img");
	bImg.onclick=changeImage;
}

function changeImage(){
	var img1 = document.getElementById("img1");
	var txt1 = document.getElementById("txt-1");
	var txtBorder = document.getElementById("txt-border");
	img1.src=txt1.value;
	img1.style.borderWidth=txtBorder.value;
}

 window.onload=init;
