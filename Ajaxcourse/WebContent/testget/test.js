/**
 * AJAX建立和服务器的链接，接收服务器的请求，处理服务器返回的数据
 * 
 * 开发步骤：
 *     1 创建XMLHttpRequest对象
 *     2 打开和服务器的连接
 *     3 发送数据
 *     4 接收服务器端的响应
 *     
 */
//*     创建XMLHttpRequest对象
function ajaxFunction(){
	var xmlHttp;
	try {
		xmlHttp=new XMLHttpRequest();
	} catch (e) {
		try {//Internet Explorer
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp=new ActiveXObject("Micrsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	return xmlHttp;
}

window.onload=function(){
	document.getElementById("ok").onclick=function(){
//		 *     1 获取XMLHttpRequest对象
		var xmlReq=ajaxFunction();
//		 *     2 打开和服务器的连接
		xmlReq.onreadystatechange=function(){
			if(xmlReq.readyState==4){
				if(xmlReq.status==200||xmlReq.status==304){
					var data=xmlReq.responseText;
					alert("data   "+data);
				}
			}
		}
//		 *     3 发送数据
		xmlReq.open("post","../testServlet?timeStamp=" + new Date().getTime() +"&a=9", true);
		
//		 *     4 接收服务器端的响应
		xmlReq.send("b=45&c=23");

	}
}