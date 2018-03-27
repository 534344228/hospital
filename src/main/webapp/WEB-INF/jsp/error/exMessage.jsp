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
	/* dialogShow("你访问的页面不存在...");
	window.setTimeout(function(){
			window.history.back(-1);
		},3000); */		
});
</script>
</head>
<body>
	<h2 style="color: red; text-align: center;">异常：${message}</h2>
</body>
</html>