/**
 * 
 */

var win = null;

function init()
{
	var btnNewTab = document.getElementById("btn-new-tab");
	var btnNewWin = document.getElementById("btn-new-win");
	var btnCloseWin = document.getElementById("btn-close-win");
	btnNewTab.onclick=btnNewTabClick;
	btnNewWin.onclick=btnNewWinClick;
	btnCloseWin.onclick=btnCloseWinClick;	
}

function btnNewTabClick(){
	win = open("http://www.naver.com/","_blank"); //요즘은 open은 잘 안쓴다. win 참조
}

function btnNewWinClick(){
	win = open("notice.html","_blank","width=500px, height=400px");
}


function btnCloseWinClick(){
	window.close();
}


window.onload=init;