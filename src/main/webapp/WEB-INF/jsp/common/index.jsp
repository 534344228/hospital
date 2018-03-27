 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${sysCfgMap['sys_title_name']}</title>
<jsp:include page="/resources/jspHead/jspHead.jsp">
	<jsp:param name="jquery" value="false"/>
	<jsp:param name="bootstrap" value="false"/>
	<jsp:param name="dialog" value="false"/>
	<jsp:param name="placeholder" value="false"/>
	<jsp:param name="validationEngine" value="false"/>
</jsp:include>

<script type="text/javascript">
$(document).ready(function(){
	
});

</script>
</head>

<body>
	<!-- 转到登录页面 -->
    <jsp:forward page="/login/forwardLogin"></jsp:forward>
</body>
</html>
