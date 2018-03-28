<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<c:set var="path" value="${pageContext.request.contextPath }" />

<link href="${path}/resources/css/public.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${path}/resources/js/common.js"></script>

<c:if test="${param.jquery=='true'}">
	<script type="text/javascript" src="${path}/resources/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/scrollbar/jquery.mCustomScrollbar.js"></script>
	<link href="${path}/resources/js/scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet">
</c:if>

<c:if test="${param.scrollbar=='true'}">
	<link href="${path}/resources/js/scroll/jquery.mCustomScrollbar.css" rel="stylesheet">
	<script type="text/javascript" src="${path}/resources/js/scroll/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/scroll/jquery.mCustomScrollbar.js"></script>
</c:if>

<c:if test="${param.bootstrap=='true'}">
	<link href="${path}/resources/js/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${path}/resources/js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<link href="${path}/resources/css/main.css" type="text/css" rel="stylesheet" />
</c:if>
<c:if test="${param.scroll=='true'}">
	<link href="${path}/resources/jquery-nanoScroller/css/nanoscroller.css" rel="stylesheet">
    <script src="${path}/resources/jquery-nanoScroller/js/jquery.nanoscroller.js"></script>
</c:if>

<c:if test="${param.dialog=='true'}">
	<link rel="stylesheet" type="text/css" href="${path}/resources/js/dialog/css/ui-dialog.css"></link>
	<script type="text/javascript" src="${path}/resources/js/dialog/dialog-min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/dialog/dialog-plus-min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/ajax-dialog.js"></script>
</c:if>

<c:if test="${param.ajaxfileupload=='true'}">
	<script type="text/javascript" src="${path}/resources/js/ajaxfileupload.js" charset="UTF-8"></script>
</c:if>

<c:if test="${param.datePicker=='true'}">
	<script type="text/javascript"  charset="utf-8" src="${path}/resources/js/datepicker/bootstrap-datepicker.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/js/datepicker/datepicker.css"></link>
</c:if>

<c:if test="${param.jquery_form=='true'}">
	<script type="text/javascript" src="${path}/resources/js/jquery.form.min.js"></script>
</c:if>

<c:if test="${param.placeholder=='true'}">
	<link rel="stylesheet" type="text/css" href="${path}/resources/js/placeholder/css/jquery.html5.placeholder.css"></link>
	<script type="text/javascript" src="${path}/resources/js/placeholder/jquery.html5.placeholder.min.js"></script>
</c:if>

<c:if test="${param.ztree=='true' }">
	<link rel="stylesheet" href="${path}/resources/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="${path}/resources/js/zTree_v3/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" href="${path}/resources/js/zTree_v3/css/demo.css" type="text/css">
	<script type="text/javascript" src="${path}/resources/js/zTree_v3/js/jquery.ztree.core.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
</c:if>

<c:if test="${param.jquery_ui_sortable=='true'}">
	<%-- <link rel="stylesheet" type="text/css" href="${path}/resources/js/jquery-ui/css/product/jquery-ui.min.css"></link> --%>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.core.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.widget.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.mouse.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.sortable.min.js"></script>
</c:if>

<c:if test="${param.validationEngine=='true'}">
	<link rel="stylesheet" type="text/css" href="${path}/resources/js/validationEngine/css/validationEngine.jquery.css"></link>
	<script type="text/javascript" src="${path}/resources/js/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${path}/resources/js/validationEngine/jquery.validationEngine.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		var forms = $("form");
		$.each(forms , function(i , form){ 
			$(form).validationEngine("attach",{
				//提示所在的位置，topLeft, topRight, bottomLeft,  centerRight, bottomRight
				promptPosition: "topRight",
				scroll:true,
				autoPositionUpdate: true,
				//addPromptClass:"formError-noArrow formError-text"
				autoHidePrompt:true,
				maxErrorsPerField:1,
				showOneMessage : true
				}
			); 
		});
	});
	</script>
</c:if>

<c:if test="${param.echarts=='true'}">
	<script type="text/javascript" src="${path}/resources/js/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/echarts/echarts-liquidfill.js"></script>
</c:if>

<c:if test="${param.cxselect=='true'}">
	<script type="text/javascript" src="${path}/resources/js/jquery.cxselect.min.js"></script>
</c:if>


<c:if test="${param.jquery_ui_tooltip=='true'}">
	<link rel="stylesheet" type="text/css" href="${path}/resources/js/jquery-ui/css/product/jquery-ui.min.css"></link>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.core.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.widget.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.effect.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.effect-fold.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.position.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery-ui/jquery.ui.tooltip.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$(document).tooltip({
				//hide: { Bounce : "blind", duration: 1000 } ,
				track: true,
				show:{ effect: "Fold", duration: 800 } ,
				events: {
					def: "mouseover,mouseout",
					input: "focus mouseover,blur mouseout",
					widget: "focus mouseover,blur mouseout",
					tooltip: "mouseover,mouseout"
				},
				content: function() {
			        var element = $( this );
			        if ( element.is( "[title]" ) ) {
			          return element.attr( "title" );
			        }
				}
			}
		);
	});
	</script>
</c:if>
