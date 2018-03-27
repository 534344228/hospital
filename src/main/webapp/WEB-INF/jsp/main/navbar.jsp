<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<script type="text/javascript"src="${path }/resources/js/select2/js/select2.min.js"></script>
	<link rel="stylesheet" href="${path }/resources/js/select2/css/select2.min.css">

<script type="text/javascript">
	function logout() {
		var url = "${path}/login/exit";
		window.location.href = url;
	}
	function toMain() {
	    window.location.href = "${path }/main/main";
	}
	$(function(){
		
		$('#swidth').width($('#mwidth').innerWidth()).css('min-width',$('#mwidth').innerWidth())
		$('#se').select2({
			 placeholder: "请输入关键字",
			    allowClear: true,placeholderOption: "first",
			width:'100%',
			minimumInputLength:1,
			ajax:{
				url:'${path}/prescription/getSearchAll',
				dataType: 'json',
				
			    data:function(params){
			    	debugger
			    	var query = {
			    	        para: encodeURI(params.term),
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
		
		function replaceStr(str){ // 正则法
			
			 str = str.toLowerCase();
			 var reg = /\b(\w)|\s(\w)/g; //  \b判断边界\s判断空格
			 return str.replace(reg,function(m){ 
			  return m.toUpperCase()
			 });
			}
		
		$("#se").next().on("click",function(e){
	
		$("#se").val('').trigger('change');
		})
		$("#se").on("select2:select",function(e){
			var url = "${path}/"+e.params.data.table_name+"/edit"+replaceStr(e.params.data.table_name)+"?"+e.params.data.table_name+"Id="+e.params.data.id+"&pageFlag=true";
 openDialog(url,"查看详情",1000,600,true);  
	
		})
		
	})

</script>
	
<style type="text/css">
.navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:focus, .navbar-default .navbar-nav>.open>a:hover {
   color: #555;
   background-color: #0087b4;
}
.brand{
	margin-top:-7px;
	margin-left:-15px;
	margin-right:15px;
}


</style>
<form id="modifySelfForm" action="${path}/user/editUser" method="post" target="_self">
	<input type="hidden" id="userId" name="userId"/>
	<input type="hidden" name="modifySelf" value="Y"/>
</form>

<div class="navbar navbar-default navbar-fixed-top" style="z-index: 1;background:#1c99d3;color:#fff;border-color:#1c99d3;">
	<nav>
		<div class="container" style="margin: 0px;padding: 0px; width: 100%">
	
			<div class="navbar-header">
			
				<a class="navbar-brand"  style="padding-top: 8px; margin: 0px;" onclick="toMain()">
					
					<span style="line-height: 33px; margin-left: 0px;color:#fff;">
						<img alt="江苏省中西医结合医院" class="brand" src="${path }/images/brand.png" onclick="toMain()" height="50px;">名老中医药专家医案管理系统
					</span>
				</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-navbar" style="margin-right: 30px;">
			<ul class="nav navbar-nav navbar-right pull-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" id="mwidth" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="color:#fff;float: right;">
							${sessionScope.currUser.userName }
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" id="swidth">
							
							<li><a href="javascript:void(0);" onclick="logout()">退出</a></li>
						</ul>
					</li>
				</ul>
			
				
				
			 <div class="pull-right col-lg-2" style="margin-top: 8px;float: left;margin-right: 20px;">
			
					  <select class="form-control validate[required]" id="se" style="height: 36px;margin-top: 11px">
					  <option value="">
					  </option>			  
					  </select> 
					
					  
				
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>