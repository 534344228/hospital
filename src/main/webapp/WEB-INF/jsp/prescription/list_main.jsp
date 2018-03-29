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
$(function() {
	$('.datepicker').datepicker();

});

/* 全选 */
function selAllCheckbox(obj) {
    if ($(obj).prop("checked")) {
        $("input[name='prescriptionId']").prop("checked", true);
    } else {
        $("input[name='prescriptionId']").prop("checked",false);
    }
    $(".ml :checkbox").each(function(){
    	var prescriptionId = $(this).val();
    	choosePrescription(prescriptionId);
 	});
}

function doChecked(){
	var $checkPrescriptionIdList = $("#prescriptionIdListDiv").children();
	$checkPrescriptionIdList.each(function(){
		var prescriptionIds = $(this).val();
		$("#"+prescriptionIds+"_checkbox").attr("checked",true);
	});
	//获取当前页选中的checkBox  （全选选中）
	var inputSize = $(".ml input").length;//checkbox个数
	if(inputSize > 0){
		var checkSize = $(".ml input:checked").length; //选中的个数
		if(checkSize == inputSize){
			$("#selAllCheckbox").prop("checked", true);
		}
	}
}

function choosePrescription(prescriptionId, resourse){
	var $checkPrescriptionId = $("#"+prescriptionId+"_checkbox");
	if(resourse == "tr"){//点击tr,手动选中/取消选中
		if ($checkPrescriptionId.prop("checked")==true) {//若已选中
			$checkPrescriptionId.removeAttr("checked");
		}else{
			$checkPrescriptionId.prop("checked","checked");//用attr只能点2次！
		}
	}
	if ($checkPrescriptionId.prop("checked")==true) {//选中
		/* $checkUserId.attr("checked","checked"); */
		//判断是否已选
		var isAdd = true;
		var $checkPrescriptionIdList = $("#prescriptionIdListDiv").children();
		$checkPrescriptionIdList.each(function(){
			var mId = $(this).val();
			if(prescriptionId == mId){
				isAdd = false;
			}
		});
		if(isAdd){
			$("#prescriptionIdListDiv").append("<input id='"+prescriptionId+"' name='prescriptionId' value='"+prescriptionId+"'/>");
		}
		//获取当前页选中的checkBox  （全选选中）
		var inputSize = $(".ml input").length;//checkbox个数
	    var checkSize = $(".ml input:checked").length; //选中的个数
		if(checkSize == inputSize){
			$("#selAllCheckbox").prop("checked", true);
		}
	}else{//未选中
		/* $checkUserId.removeAttr("checked"); */
		$("#selAllCheckbox").prop("checked", false);//取消全选
		$("#"+prescriptionId).remove();
	}
}

/**
 * 批量删除
 */
function batchDel() {
	var count = $("#prescriptionIdListDiv").children().length;
	if(count == 0){
		dialogAlert("请选择要删除的！");
		return false;
	}
	dialogConfirm("确认删除该"+count+"个处方？",  function(){
		loadingOpen();
		var url ="${path}/prescription/batchDel";
		ajaxPost(url, $("#editForm").serialize(), function(data){
			loadingClose();
			if("删除成功！"==data){
				//删除成功之后，清空
				$("#prescriptionIdListDiv").empty();
				setTimeout(function(){
					toPage(1);
				},1000);
			}
		}, null, true);
	});
}

/* 单个删除 */
function deletePrescription(prescriptionId) {
	var url = "${path}/prescription/deletePrescription?prescriptionId=" + prescriptionId;
	dialogConfirm("确定删除此药品？", function() {
		loadingOpen();
		ajaxGet(url, null, function(data) {
			loadingClose();
			if ("Y" == data) {
				dialogShow("删除成功！");
				setTimeout(function() {
					toPage(1);
				}, 1000);
			}
		}, null, false);
	});
}

function editPrescription(prescriptionId) {
	var url = "${path}/prescription/editPrescription?prescriptionId=" + prescriptionId;
	window.location.href = url;
}

function toPage(page) {
	if (page != undefined) {
		$("#currentPage").val(page);
	}
	search();
}

function checkDate(){
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(startTime && endTime){
		if(startTime > endTime){
			dialogShow("结束时间必须大于开始时间");
			$("#endTime").val("");
		}else{
			return true;
		}
	}
}

$(document).ready(function(){
	//选中已选择的
	search();
});

function search() {
	var url = "${path}/prescription/prescriptionList";
	ajaxPostHtml("prescriptionListDiv", url, $("#searchForm").serialize(), true);
}

</script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/main/navbar.jsp" flush="true" /><!-- 导航条 -->
	<jsp:include page="/WEB-INF/jsp/main/menu.jsp" flush="true" /><!-- 左侧菜单 -->
	<div class="container-fluid">
		<div class="col-sm-12 col-md-12 oper-panel">
			<a href="#left-panel" id="menuHide"></a>
			<h3 class="title">处方信息管理</h3>
			<div class="col-md-12 col-sm-12 oper-page">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<form method="post" id="searchForm" class="form-inline">
									<input id="currentPage" type="hidden" name="currentPage" />
									<label for="patientName">病人名</label>
									<input type="text" id="patientName" name="patientName" value="${param.patientName }" class="form-control" placeholder="" style="width: 60px;"/>
									&#12288;<label for="medicineName">中药名</label>
									<input type="text" id="medicineName" name="medicineName" value="${param.medicineName }" class="form-control" placeholder="" style="width: 60px;"/>
									&#12288;<label for="westernDiagnosis">西医诊断</label>
									<input type="text" id="westernDiagnosis" name="westernDiagnosis" value="${param.westernDiagnosis }" class="form-control" placeholder="" style="width: 60px;"/>
									&#12288;<label for="disease">中医诊断证型</label>
									<input type="text" id="dise" name="dise" value="${param.dise }" class="form-control" placeholder="" style="width: 60px;"/>
									&#12288;		
									<div class="form-group">
									<label for="createTime">就诊时间</label>
			                      <input type="text" class="datepicker form-control" id="startTime" onchange="checkDate()" placeholder="起始时间" name="startTime" value="${param.startTime }" readonly="readonly" style="width: 90px; background: white;">
		                          </div>~
		                           <div class="form-group">
			                        <input type="text" class="datepicker form-control" id="endTime" onchange="checkDate()" placeholder="结束时间" name="endTime" value="${param.endTime }" readonly="readonly" style="width: 90px; background: white;">
		                            </div>&#12288;
									<button type="button" class="btn btn-default" onclick="toPage(1)">查询</button>
									<button type="button" class="btn btn-default" onclick="editPrescription('')">新增</button>
									<button type="button" class="btn btn-default" onclick="batchDel()">批量删除</button>
								</form>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" style="border-bottom-style: none;">处方列表</div>
							<form id="editForm"  >
								<div id="prescriptionIdListDiv" style="display: none;">
									<!-- 隐藏批量删除主键 -->
								</div>	
							</form>
							<div id="prescriptionListDiv" class="panel-body" style="padding: 0px;">
								<!-- 加载药品列表 -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>