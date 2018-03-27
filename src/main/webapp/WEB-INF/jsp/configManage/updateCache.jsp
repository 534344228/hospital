<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	   var url = "${path}/updateCache/update";
	    ajaxPost(url, null, function(data){
	          if("success" == data) {
	              dialogShow("更新成功！");
	              setTimeout(function() {
	                  closeDialog();
	                  window.location.href = "${path}/updateCache/main"
	              }, 1000);
	          }else{
	              dialogShow(data);
	              setTimeout(function() {
	                  closeDialog();
	              }, 1000);
	          }
	    }, null, false)
}
</script>
<style type="text/css">
a {
	cursor: pointer;
}

table tr {
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
							<div class="panel-heading">缓存更新</div>
							<!-- 						
  <input class="btn btn-default" onclick="update();" style ="margin-top: 20px;margin-left: 20px;margin-bottom: 20px" type="button" value="一键更新缓存"/>
 -->
							<div class="panel-body" style="padding: 0px;">
								<table class="table table-hover text-center">
									<tr>
										<th colspan="2" style="text-align: center;">
									</tr>
									<tr>
										<th style="text-align: center;" width="60%">服务器</th>
										<th style="text-align: center;" width="40%">操&#12288;作</th>
									</tr>

									<tr>
										<td style="text-align: center;">本服务</td>
										<td style="text-align: center;"><input
											class="btn btn-primary" type="button" id="refreshBtn" onclick="update()"
											value="一键更新缓存" /></td>
									</tr>


								</table>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>