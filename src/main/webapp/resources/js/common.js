
/**
 * 检查上传文件的后缀、大小
 */
function checkFile(fileObj, acceptFileSuffix, acceptFileSizeLimit){
	var filePath = fileObj.value;
	if(filePath==""){
		return false;
	}
	var suffixArray = acceptFileSuffix.split(",");
	var regStr = "/";
	for(var i = 0 ;i<suffixArray.length;i++){
		if(suffixArray[i]){
			if(i==(suffixArray.length-1)){
				regStr = regStr+"\\"+suffixArray[i]+'$';
			}else{
				regStr = regStr+"\\"+suffixArray[i]+'$|';
			}
		}
	}
	regStr = regStr+'/i';
	regStr = eval(regStr);
	if($.trim(filePath) != "" && !regStr.test(filePath)){
		//fileObj.value = "";
		dialogShow("请上传&nbsp;"+acceptFileSuffix+"格式的图片");
		return false;
	}else{// 文件大小
		var result = getFileSize(fileObj, acceptFileSizeLimit);
		if(!result){
			return false;
		}else{
			return true;
		}
	}
}

/**
 * 检查文件大小
 */
function getFileSize(fileObj, acceptFileSizeLimit) {
	 try {
		 var fileSize = 0;
		 //for IE
		 if ($.support.msie) {
			 //该方法需要将Internet选项中安全级别提高，启用一个系统本身不推荐的选项
			 var objFSO = new ActiveXObject("Scripting.FileSystemObject"); 
			 var filePath = fileObj.value;
			 var objFile = objFSO.getFile(filePath);
			 var fileSize = objFile.size; //size in kb
			 fileSize = fileSize / 1048576; //size in mb (1024*1024)
		 }
		 //for FF, Safari, Opeara and Others
		 else {
			 fileSize = fileObj.files[0].size; //size in kb
			 fileSize = fileSize / 1048576; //size in mb  (1024*1024)
		 }
		 //alert("上传文件大小为：" + fileSize + "MB");
		 if(fileSize > acceptFileSizeLimit){
			 dialogAlert("文件大小超过限制:<font color='red'>"+acceptFileSizeLimit+"M</font>，当前文件大小为:"+fileSize+"M");
			 return false;
		 }else{
			 return true;
		 }
		 
	 }
	 catch (e) {
		 dialogAlert("检查文件大小出现异常 :" + e);
		 return false;
	 }
}

	 

/**
 * 检查excel文件的后缀、大小
 * @param fileObj
 */
function checkExcel(fileObj, acceptExcelSuffix, acceptFileSizeLimit){
	var filePath = fileObj.value;
	if(filePath == null || filePath==""){
		dialogAlert("请选择Excel文件!");
		return false;
	}
	/*
	var suffix = filePath.substring(filePath.lastIndexOf(".")+1);
	if("xlsx" == suffix || "xls" == suffix){
		return true;
	}else{
		dialogShow("请上传Excel文件!");
		return false;
	}
	*/
	var suffixArray = acceptExcelSuffix.split(",");
	var regStr = "/";
	for(var i = 0 ;i<suffixArray.length;i++){
		if(suffixArray[i]){
			if(i==(suffixArray.length-1)){
				regStr = regStr+"\\"+suffixArray[i]+'$';
			}else{
				regStr = regStr+"\\"+suffixArray[i]+'$|';
			}
		}
	}
	regStr = regStr+'/i';
	regStr = eval(regStr);
	if($.trim(filePath) !="" && !regStr.test(filePath)){
		//fileObj.value = "";
		dialogShow("请上传Excel文件!");
		return false;
	}else{// 文件大小
		var result = getFileSize(fileObj, acceptFileSizeLimit);
		if(!result){
			return false;
		}else{
			return true;
		}
	}
}

/**
 * checkox 单选
 * @param obj
 */
function selectSingle(obj) {
	var value = $(obj).val();
	var name = $(obj).attr("name");
	$("input[name="+name+"][value!="+value+"]:checked").attr("checked",false);
}

/**
 * 复选框全选
 * @param obj 复选框对象
 */
function selAllCheckbox(obj) {
    if ($(obj).prop('checked')) {
        $("input[type='checkbox']").attr("checked","checked");
    } else {
        $("input[type='checkbox']").removeAttr("checked");
    }
}

/**
 * 复选框取消全选
 * @param obj 复选框对象
 */
function uncheckAll(obj) {
	if($(obj).prop('checked')) {
		$("table tr").children("th").eq(0).find("input[type='checkbox']").attr("checked", "checked");
	} else {
		$("table tr").children("th").eq(0).find("input[type='checkbox']").removeAttr("checked");
	}
}