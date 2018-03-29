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
	<jsp:param name="datePicker" value="true"/>
</jsp:include>
<script type="text/javascript">


function toPage(page) {
	if (page != undefined) {
		$("#currentPage").val(page);
	}

}

var Prescription = function() {

	this.init = function() {

		//模拟上传excel  
		$("#uploadEventBtn").unbind("click").bind("click", function() {
			$("#uploadEventFile").click();
		});
		$("#uploadEventFile").bind(
				"change",
				function() {
					$("#uploadEventPath").attr("value",
							$("#uploadEventFile").val());
				});

	};
	//点击上传按钮  
	this.uploadBtn = function() {
		var uploadEventFile = $("#uploadEventFile").val();
		if (uploadEventFile == '') {
			dialogShow("请选择excel,再上传");
		} else if (uploadEventFile.lastIndexOf(".xls") < 0) { //可判断以.xls和.xlsx结尾的excel  
			dialogShow("只能上传Excel文件");
		} else {
			var url = "${path}/prescription/upload";
			var formData = new FormData(document.getElementById("batchUpload"));
			prescription.sendAjaxRequest(url, 'POST', formData);
		}
	};

	this.sendAjaxRequest = function(url, type, data) {
		$.ajax({
			url : "${path}/prescription/upload",
			type : type,
			data : data,
			success : function(result) {
					if (result.resultMap) {
						dialogShow(result.resultMap);
						return;
				}
				$(".successTotal").html(result.successTotal);
				debugger
				$(".total").html(result.total-result.successTotal);
				dialogShow("excel上传成功");
			},
			error : function() {
				dialogShow("excel上传失败");
			},
			cache : false,
			contentType : false,
			processData : false
		});
	};
}

var prescription;
$(function() {
	prescription = new Prescription();
	prescription.init();
});

function excelOut(){
    var url ="${path}/prescription/excelOut";  
    url = encodeURI(url);
    location.href = url;  
}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/main/navbar.jsp" flush="true" /><!-- 导航条 -->
	<jsp:include page="/WEB-INF/jsp/main/menu.jsp" flush="true" /><!-- 左侧菜单 -->

	 
	  <div class="container-fluid">
		<div class="col-sm-12 col-md-12 oper-panel">
			<a href="#left-panel" id="menuHide"> </a>
			<div class="col-md-12 clear-left-right-padding"  >
				<h3 class="title col-md-3 clear-left-right-padding">处方上传</h3>
	 
	

		<div class="col-md-12 col-sm-12 col-lg-12 oper-page">
		<div class="panel panel-default">
			<div class="panel-body">	
						<div class="panel panel-default">
							<div class="panel-heading" style="border-bottom-style: none;">上传下载</div>
							<div class="panel-body" style="padding:0px;">
					<form enctype="multipart/form-data"   id="batchUpload" action="${path}/prescription/upload" method="post" class="form-horizontal  col-md-12" >
					<button class="btn btn-primary btn-xs" id="uploadEventBtn" style="height: 40px;width: 100px;float: left; " type="button">选择文件</button>
					<input type="file" name="file" style="width: 0px; height: 0px;" id="uploadEventFile"> 
					<input id="uploadEventPath" disabled="disabled" type="text" placeholder="请选择excel表" style="border: 1px solid #e6e6e6; height: 40px; width: 200px;margin-left: 3px;">
					<button type="button"  class="btn btn-primary btn-sm" onclick=" prescription.uploadBtn()"  style=" position: relative; bottom: 2px;height: 40px;width: 100px">处方上传</button>
					<button type="button"  class="btn btn-primary btn-sm" onclick=" excelOut()"  style=" position: relative; bottom: 2px; left: 20px;height: 40px;width: 100px">处方模板下载</button>
				</form>	
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading" style="border-bottom-style: none;">处方上传列表</div>
							<div class="panel-body" style="padding:0px;">
						   			 <table   class="table table-hover text-center">
					          <tr>
					           
					               <th width="10%" class="text-center">上传处方成功数</th>
					               <th width="10%" class="text-center">上传处方失败数</th>
					          </tr>
						      <tr>
											<td width="10%"  class="successTotal"></td>
											<td width="10%"  class="total"></td>
										</tr>
						  </table>
						</div>
				</div>
				</div>
						
				</div>
				</div>
				</div>
				
                </div> 
                </div>
                 </div>
              
                   
</body>
</html>