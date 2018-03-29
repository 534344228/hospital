<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag body-content="scriptless" pageEncoding="UTF-8"%>
<%@ attribute name="toPage" required="true"%>
<script type="text/javascript">

function topage(page){
	${toPage}(page);
}
function change(obj){
	if(obj.options[obj.selectedIndex].value!="0"){
		${toPage}(obj.options[obj.selectedIndex].value);
	}
}
function changeInput(){
	var page = $("#inputPage").val();
	var totalPage = parseInt("${pageView.totalpage}");
	if(page==""){
		return false;
	}
	if(parseInt(page) > totalPage ){
		page = totalPage;
	}
	${toPage}(page);
}

function selectPagesize(obj){
	var pageSize =$(obj).val();
	var url = "${pageContext.request.contextPath }/sysCfg/savePageSize.action?pageSize="+pageSize+"&pageServletPath=${pageServletPath}";
	ajaxPost(url, null, function(msg){
		if(msg=="Y"){
			topage(1);
		}
	}, null, false);
}

</script>
<style>
.pagination .active a {
	z-index: 0;
}
</style>
<div class="text-right" style="margin-top: 15px; margin-right: 50px; width: 100%;">
	<nav>
		<ul class="pagination pagination-sm" style="margin:0px; margin-bottom: 6px;">
			<div style="position: relative; float: left; margin-top: 2px; margin-right: 5px;">
				<span>
					共&nbsp;<span class="text-primary">${pageView.totalrecord}</span>
					条记录&nbsp;
				</span>
				
				<span id="pageSpan" class="page_num">
					<c:set var="cfgCode" value="${pageServletPath}/${sessionScope.currUser.userId }/pageSize" />
					每页<select name="pageSize" onchange="selectPagesize(this)" style="margin-left: 0px; width: 50px; height: 26px; border-radius: 4px;">
						<c:forEach varStatus="status" begin="5" end="50" step="5">
							<option value="${status.index}" <c:if test="${pageSize == status.index or status.index==sessionScope[cfgCode] }"> selected="selected"</c:if>>${status.index
								}</option>
						</c:forEach>
					</select>条&nbsp;
				</span>
				
				<span>
					&nbsp;第 
					<c:if test="${pageView.totalrecord > 0}">
						<span class="text-primary">${pageView.currentpage}</span>
					</c:if> 
					<c:if test="${pageView.totalrecord == 0}">
						<span class="text-primary">${pageView.totalrecord}</span>
					</c:if>页&nbsp;
				</span>
			</div>
			<c:if test="${pageView.currentpage<=1}">
				<li class="disabled"><a href="#">首页</a></li>
			</c:if>
			<c:if test="${pageView.currentpage>1}">
				<li><a href="javascript:topage('1')">首页</a></li>
			</c:if>
			<c:if test="${pageView.currentpage<=1}">
				<li class="disabled"><a aria-label="Previous">上一页</a></li>
			</c:if>
			<c:if test="${pageView.currentpage>1}">
				<li><a href="javascript:topage('${pageView.currentpage-1}')">上一页</a></li>
			</c:if>
			<c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
				<c:if test="${pageView.currentpage==wp}">
					<li class="active"><a>${wp}</a></li>
				</c:if>
				<c:if test="${pageView.currentpage!=wp}">
					<li><a href="javascript:topage('${wp}')">${wp}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${pageView.currentpage>=pageView.totalpage}">
				<li class="disabled"><a>下一页</a></li>
			</c:if>
			<c:if test="${pageView.currentpage<pageView.totalpage}">
				<li><a href="javascript:topage('${pageView.currentpage+1}')">下一页</a></li>
			</c:if>
			<c:if test="${pageView.currentpage>=pageView.totalpage}">
				<li class="disabled"><a>尾页</a></li>
			</c:if>
			<c:if test="${pageView.currentpage<pageView.totalpage}">
				<li><a href="javascript:topage('${pageView.totalpage}')">尾页</a></li>
			</c:if>
		</ul>
	</nav>
</div>