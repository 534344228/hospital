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
<link rel="stylesheet"
	href="${path }/resources/js/select2/css/select2.min.css">
<style type="text/css">
td>input, select {
	height: 26px;
	width: 200px;
}


.table label {
	line-height: 30px;
}

.table input[type='text'] {
	width: 180px;
}

.table select {
	width: 180px;
}

.select2-container--default.select2-container--focus .select2-selection--multiple{
  border-color: #66afe9 ;
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102,175,233,.6);
  border: solid #66afe9 1px !important;
}
.adon{
    float: left;
    margin-left: 6px;
    line-height: 30px;
    font-size: 18px;
    color: #1B191F;
}
</style>
<jsp:include page="/resources/jspHead/jspHead.jsp">
	<jsp:param name="jquery" value="true" />
	<jsp:param name="bootstrap" value="true" />
	<jsp:param name="dialog" value="true" />
	<jsp:param name="placeholder" value="true" />
	<jsp:param name="datePicker" value="true" />
	<jsp:param name="validationEngine" value="true" />
	<jsp:param name="cxselect" value="true" />
</jsp:include>
<script type="text/javascript">
$(function() {
	$('.datepicker').datepicker();

});


	function savePrescription() {
		
		if ($("#editForm").validationEngine("validate") == false) {
			return false;
		}
		var medicines = [];
		$.each($('#medicinesShow').select2('data'),function(i,v){
			$.each($('.selectJs2'),function(j,b){
				if(v.id===$(b).val())medicines.push({medicineName:v.text,medicineId:v.id,dose:$('.jl',$(b).parents('tr')).val()});
			});
		});
		$('#medicines').val(JSON.stringify(medicines));
		var url = "${path}/prescription/savePrescription";
		$("#saveBtn").attr("disabled", true);
		loadingOpen();
		ajaxPost(url, $("#editForm").serialize(), function(data) {
			loadingClose();
			if ("保存成功！" == data) {
				setTimeout(function() {
					window.location.reload();
				}, 1000);
			}
		}, null, true);
	}

	/* 返回 */
	function cancelEdit() {
		window.history.go(-1);
	}
	
	

</script>
</head>
<body>
	<c:if test="${!pageFlag}">
	<jsp:include page="/WEB-INF/jsp/main/navbar.jsp" flush="true" /><!-- 导航条 -->
	<jsp:include page="/WEB-INF/jsp/main/menu.jsp" flush="true" /><!-- 左侧菜单 -->
	</c:if>
	<div class="container-fluid" style="${pageFlag?'margin-left:0px':''}">
		<div class="col-sm-12 col-md-12 oper-panel">
			<a href="#left-panel" id="menuHide"> </a>
				<div class="col-md-12 clear-left-right-padding"  ><c:if test="${!pageFlag}">
				<h3 class="title col-md-3 clear-left-right-padding">${empty prescription.prescriptionId?'新增':'修改' }处方</h3>
			</c:if>
			</div>
			<%-- <h3 class="title">${empty prescription.prescriptionId?'新增':'修改' }处方</h3> --%> 
			<div class="col-md-12 col-sm-12 oper-page">
				<div class="panel panel-default">
					<div class="panel-body" style="padding: 0px;">

						<form id="editForm" method="post">
						
							<input type="hidden" name="prescriptionId"
								value="${prescription.prescriptionId}" id="prescriptionId" />
							<div class="table-responsive">
								<table class="table text-center" class="form-inline">
									
									
									<tr>
										<td class="text-right"><label for="patientName">病人姓名：</label></td>
										<td class="text-left"><input type="text" ${ pageFlag?"disabled":""}
											class="form-control validate[required,maxSize[20]]" id="patientName"
											name="patientName" value="${prescription.patientName }" /></td>
										<td class="text-right"><label for="patientAge">病人年龄：</label></td>
										<td class="text-left"><input type="text" ${ pageFlag?"disabled":""}
											class="form-control validate[required,custom[number],maxSize[20]]"
											id="patientAge" name="patientAge" value="${prescription.patientAge }" /></td>
									</tr>
									<tr>
										<td class="text-right"><label for="patientGenderid">病人性别：</label></td>
										<td class="text-left"><c:forEach var="genderEnum"
												items="${userGenderEnumList}">
												<label> <input type="radio" name="patientGenderid" ${ pageFlag?"disabled":""} value="${genderEnum.id }"
													<c:if test="${prescription.patientGenderid eq genderEnum.id}">checked="checked"</c:if> />&nbsp;${genderEnum.name }
												</label>
												&#12288;
											</c:forEach>
											</td>
											
											<td class="text-right"><label>就诊次数：</label></td>
										    <td class="text-left"><label class="pull-left"><input class="visits1"  name="visitsI" type="radio" ${ pageFlag?"disabled":""} 
											${prescription.visits==1?"checked='checked'":""} />初诊&nbsp;&nbsp;</label>
											<label class="pull-left"><input class="visits2" type="radio" name="visitsI" ${ pageFlag?"disabled":""}
											 ${prescription.visits>1?"checked='checked'":""} />复诊</label>
											 <input type="hidden" id="visitsTemp" value="${prescription.visits}">
											 <input class="form-control pull-left" name="visits" min="1" id="visits" type="number"  value="${empty prescription.visits?1:prescription.visits}" ${ pageFlag?"disabled":""} style="margin-left:15px;  display:none;width:70px"/>
											</td>
									</tr>

									<tr>
									 <td class="text-right"><label for="visitTime">就诊时间：</label></td>
									 
										<td class="text-left" ><input type="text" ${ pageFlag?"disabled":""}
											class="datepicker form-control validate[required]"
											id="visitTime" name="visitTimeString"
											value="<fmt:formatDate value='${prescription.visitTime }' pattern='yyyy-MM-dd'/>"  /></td>
											
									   <%--  <td class="text-right"><label for="pname">中医诊断病名：</label></td>
										<td class="text-left" ><input type="text" ${ pageFlag?"disabled":""}
											class="form-control validate[required,maxSize[50]]"
											id="pname" name="pname"
											value="${prescription.pname }" /></td> --%>
											<input type="hidden" name="pname" id="pname" value='${prescription.pname }'></input>
											<td class="text-right"><label for="zybm">中医诊断病名：</label></td>
										    <td class="text-left" ><select  ${ pageFlag?"disabled":""}
											class="form-control validate[required,maxSize[50]]" multiple="multiple"
											id="zybm" name="zybm" value="" /></td>	
									  
									</tr>
									<tr>
									 <%-- <td class="text-right"><label for="disease">中医诊断证型：</label></td>
										<td class="text-left" ><input type="text" ${ pageFlag?"disabled":""}
											class="form-control validate[required,maxSize[50]]"
											id="disease" name="disease"
											value="${prescription.disease }" /></td> --%>
											<input type="hidden" name="disease" id="disease" value='${prescription.disease }'></input>
											<td class="text-right"><label for="chinese">中医诊断证型：</label></td>
										    <td class="text-left" ><select  ${ pageFlag?"disabled":""}
											class="form-control validate[required,maxSize[50]]" multiple="multiple"
											id="chinese" name="chinese" value="" /></td>	
											
										<input type="hidden" name="westernDiagnosis" id="westernDiagnosis" value='${prescription.westernDiagnosis }'></input>
											<td class="text-right"><label for="west">西医诊断：</label></td>
										    <td class="text-left" ><select  ${ pageFlag?"disabled":""}
											class="form-control validate[required,maxSize[50]]" multiple="multiple"
											id="west" name="west" value="" /></td>	
											
									</tr>
									<%-- <tr>
									<td class="text-right"><label for="pyAbb">中医诊断证型首字母：</label></td>
										<td class="text-left" ><input type="text" ${ pageFlag?"disabled":""}
											class="form-control validate[required,custom[onlyLetterSp,maxSize[50]]"
											id="pyAbb" name="pyAbb"
											value="${prescription.pyAbb }" /></td>
                                     <td>
                                     <td>
                                     </td>

									</tr>  --%>
									<tr>
									<td class="text-right"><label for="medicalHistory">现病史：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="medicalHistory"
												name="medicalHistory"
												class="form-control validate[maxSize[330]]">${prescription.medicalHistory }</textarea>
										</td>
		
									</tr>	
									<tr>
									<td class="text-right"><label for="treatmentCycle">既往史：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="treatmentCycle"
												name="treatmentCycle"
												class="form-control validate[maxSize[330]]">${prescription.treatmentCycle }</textarea>
										</td>
									
									</tr> 
									<tr>
									
										<td class="text-right"><label for="physicalExamination">体格检查：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="physicalExamination"
												name="physicalExamination"
												class="form-control validate[maxSize[330]]">${prescription.physicalExamination }</textarea>
										</td>
	
									</tr> 
									<tr>
										<td class="text-right"><label for="equipmentInspection">实验室和器械检查：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="equipmentInspection"
												name="equipmentInspection"
												class="form-control validate[maxSize[330]]">${prescription.equipmentInspection }</textarea>
										</td>
									</tr>

							
									<tr>
										<td class="text-right"><label for="westMedicines">西医处方：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="westMedicines"
												name="westMedicines"
												class="form-control validate[maxSize[330]]">${prescription.westMedicines }</textarea>
										</td>
										
									</tr>
									<tr>
										<td class="text-right"><label for="medicines">中药处方：</label></td>
										<td class="text-left" colspan="3"><select rows="1" multiple="multiple" disabled
												style="width:100%" id="medicinesShow" name="medicinesShow"
												class="form-control validate[maxSize[330]]"></select>
												<input type="hidden" name="medicines" id="medicines" value='${prescription.medicines}'>
										</td>
									</tr>
									</form>
									<tbody id="medicinesDiv">
										<tr>
											<td class="text-right"><label>中药名：</label></td>
											<td class="text-left"><select ${ pageFlag?"disabled":""}
												class=" selectJs2 form-control validate[required]" id="select1"
												style="height: 45px">
													 <option value="请选择">请选择</option>
													
											</select></td>
											<td class="text-right "><label>剂量：</label></td>
											<td class="text-left ">
												<input type="text" ${ pageFlag?"disabled":""} class="form-control  col-md-6 jl" id="dose1" />
												<span class="adon">g</span>
												<c:if test="${ !pageFlag}">
												<div class="col-md-6 text-right">
													<button type="button" class="glyphicon glyphicon-plus btn btn-default ${ pageFlag?'':''}" onclick="addCell()"></button>
												</div>
												</c:if>
											</td>
										</tr>
									</tbody>
										<tr>
										<td class="text-right"><label for="iusage">诊疗体会：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="iusage"
												name="iusage"
												class="form-control validate[maxSize[330]]">${prescription.iusage }</textarea>
										</td>
										
									</tr>
									<tr>
										<td class="text-right"><label for="prescriptionIntroduce">备注：</label></td>
										<td class="text-left" colspan="3"><textarea rows="1" ${ pageFlag?"disabled":""}
												cols="10" id="prescriptionIntroduce"
												name="prescriptionIntroduce"
												class="form-control validate[maxSize[330]]">${prescription.prescriptionIntroduce }</textarea>
										</td>
									</tr>
								</table>
							</div>
							<div class="text-center" style="margin-bottom: 10px;">
							<c:if test="${ !pageFlag}">
								<input type="button" id="saveBtn" class="btn btn-primary"
									value="保&#12288;存 " onclick="savePrescription()" />&#12288; <input
									type="button" class="btn btn-default" value="取&#12288;消"
									onclick="cancelEdit()" />
									</c:if>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${path }/resources/js/select2/js/select2.full.min.js"></script>
	<script type="text/javascript">
	function hereDoc(fn) {
		return fn.toString().split('\n').slice(1, -1).join('\n') + '\n';
	}
		function addCell(){
			var cellHtml=hereDoc(function(){/*
				<tr>
				<td class="text-right"><label>中药名：</label></td>
				<td class="text-left" >
					<select class="selectJs2 form-control validate[required]" style="height:36px" ${ pageFlag?'disabled':''}>
					<option value="请选择">请选择</option>
					</select>
				</td>
				<td class="text-right"><label>剂量：</label></td>
				<td class="text-left" >
					<input type="text" ${ pageFlag?'disabled':''} class="form-control  col-md-6 jl"/>
						<span class="adon">g</span>
						<c:if test="${ !pageFlag}">
					<div class="col-md-6 text-right">
						<a type="button " class="glyphicon glyphicon-plus btn btn-default" onclick="addCell()"></a>
						<a type="button"  class="glyphicon glyphicon-minus  btn btn-default" onclick="minusCell()"></a>
					</div>
					</c:if>
				</td>
			</tr>
				*/});
			$('#medicinesDiv').append(cellHtml); 
			ajaxSelect();
			return $('tr','#medicinesDiv').last();
		}
		function minusCell(){
			var list = [];
			if($.isArray($('#medicinesShow').val())){
				list = $('#medicinesShow').val();
			}else{
				list.push($('#medicinesShow').val());
			}
			$.each(list,function(i,v){
				if($('.selectJs2',$(event.target).parents('tr')).val()===v)list.pop(i);
			});
			
			$('#medicinesShow').val(list);
			$('#medicinesShow').trigger('change');
			$(event.target).parents('tr').remove();
		}
		
		function ajaxSelect(){
			$('.selectJs2').select2({			
				 ajax: {
					    url: '${path}/medicine/list_medicineListSearch',
					    dataType: 'json',
					    data:function(params){
					    	var query = {
					    	        q: params.term,
					    	        page: params.page || 1
					    	      }
					    	return query;
					    },
						processResults: function (data,params) {
							params.page = params.page||1;
							
					      return {
					        results: JSON.parse(JSON.stringify(data).replace(/medicineName/g,'text').replace(/medicineId/g,'id')),
					        pagination:{
					        	more: data[0]===undefined?false:data[0].more
					        }
					      };
						}
    			}	  
			});
			$('.selectJs2').on("select2:select",function(e){
				$('#medicinesShow').select2({data:[e.params.data]});
				var list = [];
				
				$('.selectJs2').each(function(i,v){
					list.push($(v).val());
				});
				$('#medicinesShow').val(list);
				$('#medicinesShow').trigger('change');
			})
		}
		
		function createAndSelectOp($el,data){
			// Set the value, creating a new option if necessary
				if ($el.find("option[value='" + data.id + "']").length) {
					$el.val(data.id).trigger('change');
				} else { 
				    // Create a DOM Option and pre-select by default
				    var newOption = new Option(data.text, data.id, true, true);
				    // Append it to the select
				    $el.append(newOption).trigger('change');
				} 
		}
		$(function(){
 			$('#medicinesShow').select2({multiple:true});
 			if(!($('#medicines').val()===null||$('#medicines').val()===''||$('#medicines').val()===undefined)){
 				var jsonData = JSON.parse($('#medicines').val().replace(/medicineName/g,'text').replace(/medicineId/g,'id'));
 				var list = [];
 				$.each(jsonData,function(i,v){
 					list.push(v.id);
 					if(i===0){
 						createAndSelectOp($('#select1'),v);
 						$('#dose1').val(v.dose);
 					}else{
 						var $tr = addCell();
 						createAndSelectOp($('.selectJs2',$tr),v);
 						$('.jl',$tr).val(v.dose);
 					}
 				
 				});
 				$('#medicinesShow').select2({data:jsonData});
 				$('#medicinesShow').val(list);
				$('#medicinesShow').trigger('change');
 				
 			}
			
			ajaxSelect();
			if(${pageFlag}){
				$('.container-fluid').height($('[i=content]',parent.document).height()-50);
				$('.container-fluid').css("overflow","auto");
			}
			
			if($('#visitsTemp').val()&&$('#visitsTemp').val()>1){
				$('.visits1').attr('checked', false);
				$('.visits2').attr('checked', true);
				$('#visits').show().val($('#visitsTemp').val());
			}else{
				$('#visits').val(1);
				$('.visits1').attr('checked', true);
				$('.visits2').attr('checked', false);
			}
	
			$('.visits1').on('change',function(){
				
				if($(this).val()=="on")$('#visits').hide().val(1);
			});
			$('.visits2').on('change',function(){
				if($(this).val()=='on')$('#visits').show().val($('#visitsTemp').val()?$('#visitsTemp').val():2);
			})
			
			
			//西医诊断下拉框
			$('#west').select2({
				tags:true, 
				ajax:{
					url:'${path}/medicine/getWests',
					dataType: 'json',
				    data:function(params){
				    	var query = {
				    	        q: params.term,
				    	        page: params.page || 1
				    	      }
				    	return query;
				    },
					processResults: function (data,params) {
						params.page = params.page||1;
				      return {
				        results: data,
				        pagination:{
				        	more: data[0]===undefined?false:data[0].more
				        }
				      };
					}
				}
		
			});
			
			$('#west').on("select2:unselect",function(e){
				
				var array =[];
				$.each(JSON.parse($('#westernDiagnosis').val()),function(i,v){
					if(v.id!=e.params.data.id){
						array.push(v);
					}
				});
				$('#westernDiagnosis').val(JSON.stringify(array))
			});
			$('#west').on("select2:select",function(e){
				
			var westName=$('#westernDiagnosis').val();
				var wests = [];
				if(typeof $(this).val()=='string'){
					wests.push($(this).val());
				}
			if(westName){
				var array = JSON.parse(westName);
				array.push(e.params.data);
				$('#westernDiagnosis').val(JSON.stringify(array))
				return;
			}
			 $('#westernDiagnosis').val(JSON.stringify([e.params.data]))
				
			})
			
			if($('#prescriptionId').val()){
				var westval=$('#westernDiagnosis').val().replace(/westId/g,'id').replace(/westName/g,'text');
				 $('#west').select2({data:JSON.parse(westval),
					  tags:true, 
					 ajax:{
							url:'${path}/medicine/getWests',
							dataType: 'json',
						    data:function(params){
						    	var query = {
						    	        q: params.term,
						    	        page: params.page || 1
						    	      }
						    	return query;
						    },
							processResults: function (data,params) {
								params.page = params.page||1;
						      return {
						        results: data,
						        pagination:{
						        	more: data[0]===undefined?false:data[0].more
						        }
						      };
							}
						}});
				 
				 var arraytemp = [];
				$.each(JSON.parse(westval),function(i,v){
					arraytemp.push(v.id);
					
				});
				
				$('#west').val(arraytemp);
				$('#west').trigger('change');
			}
			$('#chinese').select2({
				tags:true, 
				ajax:{
					url:'${path}/medicine/getChinese',
					dataType: 'json',
				    data:function(params){
				    	var query = {
				    	        q: params.term,
				    	        page: params.page || 1
				    	      }
				    	return query;
				    },
					processResults: function (data,params) {
						params.page = params.page||1;
				      return {
				        results: data,
				        pagination:{
				        	more: data[0]===undefined?false:data[0].more
				        }
				      };
					}
				}
		
			});
			//中医诊断证型下拉框
			$('#chinese').on("select2:unselect",function(e){
				
				var array =[];
				$.each(JSON.parse($('#disease').val()),function(i,v){
					if(v.id!=e.params.data.id){
						array.push(v);
					}
				});
				$('#disease').val(JSON.stringify(array))
			});
			$('#chinese').on("select2:select",function(e){
				
			var chineseName=$('#disease').val();
				var chinese = [];
				if(typeof $(this).val()=='string'){
					chinese.push($(this).val());
				}
			if(chineseName){
				var array = JSON.parse(chineseName);
				array.push(e.params.data);
				$('#disease').val(JSON.stringify(array))
				return;
			}
			 $('#disease').val(JSON.stringify([e.params.data]))
				
			})
			
			if($('#prescriptionId').val()){
				var chineseval=$('#disease').val().replace(/chineseId/g,'id').replace(/chineseName/g,'text');
				 $('#chinese').select2({data:JSON.parse(chineseval),
					  tags:true, 
					 ajax:{
							url:'${path}/medicine/getChinese',
							dataType: 'json',
						    data:function(params){
						    	var query = {
						    	        q: params.term,
						    	        page: params.page || 1
						    	      }
						    	return query;
						    },
							processResults: function (data,params) {
								params.page = params.page||1;
						      return {
						        results: data,
						        pagination:{
						        	more: data[0]===undefined?false:data[0].more
						        }
						      };
							}
						}});
				 
				 var arraytemp = [];
				$.each(JSON.parse(chineseval),function(i,v){
					arraytemp.push(v.id);
					
				});
				
				$('#chinese').val(arraytemp);
				$('#chinese').trigger('change');
			}
		
			//中医诊断病名下拉框
			$('#zybm').select2({
				tags:true, 
				ajax:{
					url:'${path}/medicine/getZybm',
					dataType: 'json',
				    data:function(params){
				    	var query = {
				    	        q: params.term,
				    	        page: params.page || 1
				    	      }
				    	return query;
				    },
					processResults: function (data,params) {
						params.page = params.page||1;
				      return {
				        results: data,
				        pagination:{
				        	more: data[0]===undefined?false:data[0].more
				        }
				      };
					}
				}
		
			});
			
			$('#zybm').on("select2:unselect",function(e){
				
				var array =[];
				$.each(JSON.parse($('#pname').val()),function(i,v){
					if(v.id!=e.params.data.id){
						array.push(v);
					}
				});
				$('#pname').val(JSON.stringify(array))
			});
			$('#zybm').on("select2:select",function(e){
				
			var zybmName=$('#pname').val();
				var zybm = [];
				if(typeof $(this).val()=='string'){
					zybm.push($(this).val());
				}
			if(zybmName){
				var array = JSON.parse(zybmName);
				array.push(e.params.data);
				$('#pname').val(JSON.stringify(array))
				return;
			}
			 $('#pname').val(JSON.stringify([e.params.data]))
				
			})
			
			if($('#prescriptionId').val()){
				var zybmval=$('#pname').val().replace(/zybmId/g,'id').replace(/zybmName/g,'text');
				 $('#zybm').select2({data:JSON.parse(zybmval),
					  tags:true, 
					 ajax:{
							url:'${path}/medicine/getZybm',
							dataType: 'json',
						    data:function(params){
						    	var query = {
						    	        q: params.term,
						    	        page: params.page || 1
						    	      }
						    	return query;
						    },
							processResults: function (data,params) {
								params.page = params.page||1;
						      return {
						        results: data,
						        pagination:{
						        	more: data[0]===undefined?false:data[0].more
						        }
						      };
							}
						}});
				 
				 var arraytemp = [];
				$.each(JSON.parse(zybmval),function(i,v){
					arraytemp.push(v.id);
					
				});
				
				$('#zybm').val(arraytemp);
				$('#zybm').trigger('change');
			}
		});
		
					
			
		
	</script>
</body>
</html>