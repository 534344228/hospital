<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${sysCfgMap['sys_title_name']}</title>
<jsp:include page="/resources/jspHead/jspHead.jsp">
	<jsp:param name="jquery" value="true" />
	<jsp:param name="bootstrap" value="true" />
	<jsp:param name="dialog" value="true" />
</jsp:include>
<script type="text/javascript">
function update(){
}
</script>
<style type="text/css">
a {
	cursor: pointer;
}
table tr{
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/main/navbar.jsp" flush="true" /><!-- 导航条 -->
	<jsp:include page="/WEB-INF/jsp/main/menu.jsp" flush="true" /><!-- 左侧菜单 -->
	<div class="container-fluid">
		<div class="col-sm-12 col-md-12 oper-panel">
			<div class="col-md-12 col-sm-12 oper-page">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="panel panel-default">
						  <div class="panel-heading">日志记录</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>