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
	<jsp:param name="placeholder" value="true" />
	<jsp:param name="validationEngine" value="true" />
</jsp:include>

<script type="text/javascript">
function save() {
	if(false==$("#eidtForm").validationEngine("validate")){
		return ;
	}
	loadingOpen();
	var url = "${path}/cfg/save";
	var data = $('#eidtForm').serialize();
	ajaxPost(url, data, function(msg){
		loadingClose();
		if("保存成功 ！" == msg){
			setTimeout(function(){
				window.location.reload();
			}, 1000);
		}
	}, null, true);
}
</script>
<style type="text/css">
	.table label{line-height: 30px;}
	.table span{line-height: 30px;}
	.table input[type='text']{width: 470px;}
	.table select{width: 470px;}
</style>
</head>

<body>


<jsp:include page="../main/navbar.jsp" flush="true"/>
<jsp:include page="../main/menu.jsp" flush="true"/>
<div class="container-fluid">
	<div class="col-sm-12 col-md-12 col-lg-12 oper-panel">
		<!-- <a href="#left-panel" id="menuHide"><span id="menuSpan" class="glyphicon glyphicon-chevron-left"></span></a>
	 -->
		<div class="col-md-12 col-sm-12 col-lg-12 oper-page">
		<div class="panel panel-default">
			<div class="panel-body">
					<form id="eidtForm">
						<div class="panel panel-default">
							<div class="panel-heading" style="border-bottom-style: none;">基本配置</div>
							<div class="panel-body" style="padding:0px;">
								<table class="table">
									<tr>
										<td width="21%" class="text-right"><label for="sys_title_name">系统标题名称：</label></td>
										<td width="79%" class="text-left">
											<input type="hidden" name="cfgCode" value="sys_title_name"/>
											<c:if test="${not empty sysCfgMap['sys_title_name']}">
												<input type="text" id="sys_title_name" name="sys_title_name" value="${sysCfgMap['sys_title_name']}" class="validate[required,maxSize[333]] form-control" /> 
											</c:if> 
											<c:if test="${empty sysCfgMap['sys_title_name']}">
												<input type="text" id="sys_title_name" name="sys_title_name" value="医院" class="validate[required,maxSize[333]] form-control" /> 
											</c:if>
											<input type="hidden" name="sys_title_name_desc" value="系统标题名称"/>
											<input type="hidden" name="sys_title_name_ws_id" value="sys"/> 
										</td>
									</tr>
								</table>
							</div>
						</div>
						
											
						
						<div class="panel panel-default">
							<div class="panel-heading" style="border-bottom-style: none;">文件上传配置</div>
							<div class="panel-body" style="padding:0px;">
								<table class="table">
									<tr>
										<td width="21%" class="text-right"><label for="upload_base_dir">上传文件保存物理路径：</label></td>
										<td width="79%" class="text-left">
											<input type="hidden" name="cfgCode" value="upload_base_dir">
											<c:if test="${not empty sysCfgMap['upload_base_dir']}">
												<input type="text" id="upload_base_dir" name="upload_base_dir" value="${sysCfgMap['upload_base_dir']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：/data/wwwroot/appium/xhImg" />
											</c:if> 
											<c:if test="${empty sysCfgMap['upload_base_dir']}">
												<input type="text" id="upload_base_dir" name="upload_base_dir" value="/data/wwwroot/appium/xhImg" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：/data/wwwroot/appium/xhImg" />
											</c:if>
											<input type="hidden" name="upload_base_dir_ws_id" value="sys"/>
											<input type="hidden" name="upload_base_dir_desc" value="上传文件保存物理路径"/><span>用于保存上传的图片、文件的实际存储文件夹</span>
										</td>
									</tr>
									<tr>
										<td class="text-right"><label for="accept_file_suffix">上传访问url根地址：</label></td>
										<td class="text-left">
											<input type="hidden" name="cfgCode" value="upload_base_url"/>
											<c:if test="${not empty sysCfgMap['upload_base_url']}">
												<input type="text" id="upload_base_url" name="upload_base_url" value="${sysCfgMap['upload_base_url']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：http://www.appium.com/xhImg" />
											</c:if> 
											<c:if test="${empty sysCfgMap['upload_base_url']}">
												<input type="text" id="upload_base_url" name="upload_base_url" value="http://www.appium.com/xhImg" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：http://www.appium.com/xhImg" />
											</c:if> 
											<input type="hidden" name="upload_base_url_desc" value="上传访问url根地址"/><span>上传访问url根地址</span>
											<input type="hidden" name="upload_base_url_ws_id" value="sys"/>
										</td>
									</tr>
									
									<tr>
										<td class="text-right"><label for="accept_file_suffix">允许上传文件后缀名：</label></td>
										<td class="text-left">
											<input type="hidden" name="cfgCode" value="accept_file_suffix"/>
											<c:if test="${not empty sysCfgMap['accept_file_suffix']}">
												<input type="text" id="accept_file_suffix" name="accept_file_suffix" value="${sysCfgMap['accept_file_suffix']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：.bmp,.gif,.jpg,.png" />
											</c:if> 
											<c:if test="${empty sysCfgMap['accept_file_suffix']}">
												<input type="text" id="accept_file_suffix" name="accept_file_suffix" value=".jpg,.jpeg,.bmp,.png,.txt,.doc,.docx,.xls,.xlsx,.ppt,.zip,.rar" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：.bmp,.gif,.jpg,.png" />
											</c:if> 
											<input type="hidden" name="accept_file_suffix_desc" value="允许上传文件后缀名"/><span>多个用英文逗号隔开</span>
											<input type="hidden" name="accept_file_suffix_ws_id" value="sys"/>
										</td>
									</tr>
									<tr>
										<td class="text-right"><label for="accept_file_size_limit">允许上传<font color="blue">文件大小</font>限制(<font color="red">M</font>)：</label></td>
										<td class="text-left">
											<input type="hidden" name="cfgCode" value="accept_file_size_limit"/>
											<c:if test="${not empty sysCfgMap['accept_file_size_limit']}">
												<input type="text" id="accept_file_size_limit" name="accept_file_size_limit" value="${sysCfgMap['accept_file_size_limit']}" class="validate[required,custom[number],maxSize[9],max[1024]] form-control col-md-6" placeholder="例如：5" />
											</c:if> 
											<c:if test="${empty sysCfgMap['accept_file_size_limit']}">
												<input type="text" id="accept_file_size_limit" name="accept_file_size_limit" value="5" class="validate[required,custom[number],maxSize[9],max[1024]] form-control col-md-6" placeholder="例如：5" />
											</c:if> 
											<input type="hidden" name="accept_file_size_limit_desc" value="允许上传文件大小限制(M)"/> 
											<input type="hidden" name="accept_file_size_limit_ws_id" value="sys"/>
										</td>
									</tr>
									<%-- <tr>
										<td class="text-right"><label for="accept_image_mime">允许上传<font color="blue">图片</font>的MIME类型：</label></td>
										<td class="text-left">
											<input type="hidden" name="cfgCode" value="accept_image_mime">
											<c:if test="${not empty sysCfgMap['accept_image_mime']}">
												<input type="text" id="accept_image_mime" name="accept_image_mime" value="${sysCfgMap['accept_image_mime']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：image/bmp,image/gif,image/jpeg,image/png" />
											</c:if> <c:if test="${empty sysCfgMap['accept_image_mime']}">
												<input type="text" id="accept_image_mime" name="accept_image_mime" value="image/bmp,image/gif,image/jpeg,image/png" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：image/bmp,image/gif,image/jpeg,image/png" />
											</c:if> 
											<input type="hidden" name="accept_image_mime_desc" value="允许上传图片的MIME类型"/><span>多个用英文逗号隔开</span>
											<input type="hidden" name="accept_image_mime_ws_id" value="sys"/>
										</td>
									</tr>
									<tr>
										<td class="text-right"><label for="accept_image_suffix">允许上传<font color="blue">图片</font>的后缀名：</label></td>
										<td class="text-left">
											<input type="hidden" id="accept_image_suffix" name="cfgCode" value="accept_image_suffix"/>
											<c:if test="${not empty sysCfgMap['accept_image_suffix']}">
												<input type="text" id="accept_image_suffix" name="accept_image_suffix" value="${sysCfgMap['accept_image_suffix']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：.jpg,.jpeg,.bmp,.png" />
											</c:if> 
											<c:if test="${empty sysCfgMap['accept_image_suffix']}">
												<input type="text" id="accept_image_suffix" name="accept_image_suffix" value=".jpg,.jpeg,.bmp,.png" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：.jpg,.jpeg,.bmp,.png" />
											</c:if> 
											<input type="hidden" name="accept_image_suffix_desc" value="允许上传图片的后缀名"/><span>多个用英文逗号隔开</span>
											<input type="hidden" name="accept_image_suffix_ws_id" value="sys"/>
										</td>
									</tr> --%>
									
									<tr>
										<td class="text-right"><label for="accept_excel_mime">允许上传<font color="blue">Excel</font>的MIME类型：</label></td>
										<td class="text-left">
											<input type="hidden" name="cfgCode" value="accept_excel_mime"/>
											<c:if test="${not empty sysCfgMap['accept_excel_mime']}">
												<input type="text" id="accept_excel_mime" name="accept_excel_mime" value="${sysCfgMap['accept_excel_mime']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：application/vnd.ms-excel" />
											</c:if> 
											<c:if test="${empty sysCfgMap['accept_excel_mime']}">
												<input type="text" id="accept_excel_mime" name="accept_excel_mime" value="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：application/vnd.ms-excel" />
											</c:if> 
											<input type="hidden" name="accept_excel_mime_desc" value="允许上传Excel的MIME类型"/><span>多个用英文逗号隔开</span>
											<input type="hidden" name="accept_excel_mime_ws_id" value="sys"/>
										</td>
									</tr>
									<tr>
										<td class="text-right"><label for="accept_excel_suffix">允许上传<font color="blue">Excel</font>的后缀名：</label></td>
										<td class="text-left">
											<input type="hidden" name="cfgCode" value="accept_excel_suffix"/>
											<c:if test="${not empty sysCfgMap['accept_excel_suffix']}">
												<input type="text" id="accept_excel_suffix" name="accept_excel_suffix" value="${sysCfgMap['accept_excel_suffix']}" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：.xls,.xlsx" />
											</c:if> 
											<c:if test="${empty sysCfgMap['accept_excel_suffix']}">
												<input type="text" id="accept_excel_suffix" name="accept_excel_suffix" value=".xls,.xlsx" class="validate[required,maxSize[333]] form-control col-md-6" placeholder="例如：.xls,.xlsx" />
											</c:if> 
											<input type="hidden" name="accept_excel_suffix_desc" value="允许上传Excel的后缀名"/><span>多个用英文逗号隔开</span>
											<input type="hidden" name="accept_excel_suffix_ws_id" value="sys"/>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</form>
				<div style="width: 100%;text-align: center;">
					<input type="button" class="btn btn-primary" onclick="save();" value="保&#12288;存">
				</div>
				</div>
 			</div>
		</div>
	</div>
</div>

</body>
</html>
