<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="xhfn" uri="http://www.xh.com/xhfn"%>
<%@ taglib prefix="xh" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<script type="text/javascript">
	$(document).ready(function() {
		//阻止事件传播
		$("input[type='checkbox']").click(function(event) {
			event.stopPropagation();
		});
		$("table a").click(function(event) {
			event.stopPropagation();
		});
		//选中已选择的
		doChecked();
	});
</script>
<table class="table table-hover text-center">
	<tr>
		<th class="text-center">
			<input type="checkbox" id="selAllCheckbox" onclick="selAllCheckbox(this)" />
		</th>
		<th class="text-center">序号</th>
		<th class="text-center">病人姓名</th>
		<th class="text-center">病人年龄</th>
		<th class="text-center">病人性别</th>
		<th class="text-center">就诊次数</th>
		<th class="text-center">就诊时间</th>
		<th class="text-center">操作</th>
	</tr>
	<tbody class="ml" style="border: none;">
		<c:set var="currentPage" value="${empty param.currentPage?'1':param.currentPage}" />
		<c:forEach items="${prescriptionList }" var="prescription" varStatus="status">
			<tr onclick="choosePrescription('${prescription.prescriptionId}','tr')" style="cursor: pointer;">
				<td>
					<input type="checkbox" id="${prescription.prescriptionId}_checkbox" value="${prescription.prescriptionId}" name="prescriptionId"
						class="prescriptionId" onclick="choosePrescription('${prescription.prescriptionId}')">
				</td>
				<td>${(currentPage-1)*pageSize + status.count}</td>
				<td>${prescription.patientName }</td>
				<td>${prescription.patientAge}</td>

				<td>
					<c:forEach var="genderEnum" items="${userGenderEnumList}">
						<c:if test="${genderEnum.id == prescription.patientGenderid }">${genderEnum.name }</c:if>
					</c:forEach>
				</td>
				<td>${prescription.visits}</td>

				<td>
					<fmt:formatDate value="${prescription.visitTime }" pattern="yyyy-MM-dd" />
				</td>

				<td>
					<a style="cursor: pointer" onclick="editPrescription('${prescription.prescriptionId }')">编辑</a>
					&nbsp;&nbsp;
					<a style="cursor: pointer" onclick="deletePrescription('${prescription.prescriptionId }')">删除</a>
					&nbsp;&nbsp;

				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty prescriptionList }">
			<tr>
				<td colspan="10" class="text-center">无记录!</td>
			</tr>
		</c:if>
	</tbody>
</table>
<div>
	<c:set var="pageView" value="${xhfn:getPageView(prescriptionList)}" scope="request"></c:set>
	<xh:pagination toPage="toPage" />
</div>