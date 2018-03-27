<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<jsp:param name="placeholder" value="false" />
	<jsp:param name="validationEngine" value="false" />
</jsp:include>
<script type="text/javascript">
$(document).ready(function() {
	//alert("${exception.message }");
});

function showErrors() {
	var err_el = document.getElementById('errors');
	if (err_el.style.display == 'none') {
		err_el.style.display = '';
	} else {
		err_el.style.display = 'none';
	}
}

function goback() {
	loadingOpen();
	window.history.back(-1);
}
</script>
</head>
<body>
<table class="table table-hover text-center">
	<tr>
		<th style="text-align: center;">发生错误啦：${exception.message }</th>
	</tr>
	<tr>
		<td>
			<input class="btn btn-danger" type="button" value="查看详情" onclick="showErrors();" />&#12288;&#12288;&#12288;&#12288;
			<input class="btn btn-default" type="button" value="返&#12288;&#12288;回" onclick="goback();" />
		</td>
	</tr>
	<tr>
		<td>
			<div id="errors" style="display: none; color: red; width: 100%;">
				${exception.message }
				<c:forEach items="${exception.stackTrace }" var="e">  
	    		${e }<br />
				</c:forEach>
			</div>
		</td>
	</tr>
</table>
</body>
</html>
