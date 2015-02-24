/**
 * 
 */

function init(){
	var btnNewInner = document.getElementById("btn-new-inner");
	btnNewInner.onclick=openDoc;
}

function openDoc(){
	window.frames[0].location.href="http://supercell.com/en/";
}



window.onload=init;