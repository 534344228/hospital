<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${sysCfgMap['sys_title_name']}</title>
<jsp:include page="/resources/jspHead/jspHead.jsp">
	<jsp:param name="jquery" value="true"/>
	<jsp:param name="bootstrap" value="true"/>
	<jsp:param name="dialog" value="true"/>
	<jsp:param name="placeholder" value="false"/>
	<jsp:param name="validationEngine" value="false"/>
</jsp:include>
<script type="text/javascript" defer="defer">
$(document).ready(function(){
	dialogShow("你访问的页面不存在...");
	var secs = 5;
	countDown(secs);
	window.setTimeout(function(){
		window.history.back(-1);
	}, secs*1000);
});

function countDown(secs){     
	 var jumpTo = document.getElementById('jumpTo');
	 jumpTo.innerHTML=secs;  
	 if(--secs>-1){
		 $("#jumpSapn").show();
		 $("#resendA").hide();
		 setTimeout("countDown("+secs+")", 1000);
	 }else{       
	     $("#resendA").show(); 
	     $("#jumpSapn").hide();
	 }     
}
</script>
</head>
<body>
	<h2 style="color: red; text-align: center;">404! 你访问的页面不存在...</h2>
	<h2 style="text-align: center;"><span id="jumpSapn"><span id="jumpTo" style="color:blue;"></span>秒后返回原页面</span></h2>
</body>
</html>