<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${sysCfgMap['sys_title_name']}</title>
<jsp:include page="/resources/jspHead/jspHead.jsp">
    <jsp:param name="jquery" value="true" />
    <jsp:param name="bootstrap" value="true" />
    <jsp:param name="dialog" value="true" />
    <jsp:param name="placeholder" value="false" />
    <jsp:param name="validationEngine" value="false" />
</jsp:include>
</head>
<body>
<script type="text/javascript" defer="defer">
$(document).ready(function(){
    dialogShow("长时间未操作，请重新登录...");
    window.setTimeout(function() {
        var url = "${path}/login/forwardLogin.action";
        top.window.location.href = url;
        closeDialog();
    },1500);
    dialogCenter();
});
</script>
</body>
</html>