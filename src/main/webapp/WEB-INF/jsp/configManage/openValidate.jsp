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

function edit(cfgValue,cfgId){
	var url = "${path}/openValidate/edit?cfgValue="+cfgValue+"&cfgId="+cfgId;
	ajaxPost(url, null, function(data){
		  if("success" == data) {
              dialogShow("保存成功！");
              setTimeout(function() {
                  closeDialog();
                  window.location.href = "${path}/openValidate/main"
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
						  <div class="panel-heading">验证码状态</div>
						  <table   class="table table-hover text-center">
					          <tr>
					               <th width="5%" class="text-center">验证码状态</th>
					               <th width="10%" class="text-center">修改时间</th>
					               <th width="10%" class="text-center">操作</th>
					          </tr>
						      <c:forEach items="${cfgList}" var="cfg">
							      <tr>
							          <td  width="5%">
							             <c:if test="${cfg.cfgValue eq 'Y' }"><span style="color: green;">已开启</span></c:if>
                                         <c:if test="${cfg.cfgValue eq 'N' }"><span style="color: red;">已关闭</span></c:if>
							          </td>
							          <td  width="10%">
							             <fmt:formatDate value="${cfg.modifyTime}" pattern="yyyy-MM-dd"/>
							          </td>
							          <td  width="10%">
							             <c:if test="${cfg.cfgValue eq 'Y' }"><a style="color: red;"  onclick="edit('N','${cfg.cfgId}');">关闭</a></c:if>
							             <c:if test="${cfg.cfgValue eq 'N' }"><a style="color: green;" onclick="edit('Y','${cfg.cfgId}');">开启</a></c:if>
							          </td> 
							      </tr>
						      </c:forEach> 
						  </table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>