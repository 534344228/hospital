<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath }" /> 
<style type="text/css">

	.panel>.list-group .list-group-item, .panel>.panel-collapse>.list-group .list-group-item{
		border-color:#85B8EC;
	}
    a {
     cursor: pointer;
    }
    a.onUrl{
        background-color: #85B8EC;
        color:black;
    }
    a.offUrl{
        background-color: #85B8EC;
        color: black;
    }
     span.off{
        background-color: #85B8EC;
        color: black;
    }
    a.offUrl:link{
        background-color: #85B8EC;
        color: black;
    }
    a.offUrl:hover{
        background-color: #85B8EC;
        color: #fff;
    }
    #left-panel{
    	background-color:#85B8EC;
    }
    .right_menu{ width:12px;height:12px;margin-top:0px;float:left;display: block;background: url(${path}/resources/images/right_menu.png) no-repeat;}
    .left_menu{ width:12px;height:12px;margin-top:0px;float:right;display: block;background: url(${path}/resources/images/left_menu.png) no-repeat;}
    .icon-left{ width:14px;height:14px;margin-top:4px;float:left;display: block;background: url(${path}/resources/images/left.png) no-repeat;}
    .icon-down{ width:14px;height:14px;margin-top:4px;float:left;display: block;background: url(${path}/resources/images/down.png) no-repeat;}
    .black_service{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_service.png) no-repeat;}
    .write_service{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_service.png) no-repeat;}
    .black_webVersion{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_webVersion.png) no-repeat;}
    .write_webVersion{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_webVersion.png) no-repeat;}
    .black_functionReport{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_functionReport.png) no-repeat;}
    .write_functionReport{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_functionReport.png) no-repeat;}
    .black_moreAppium{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_mutiequip.png) no-repeat;}
    .write_moreAppium{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_mutiequip.png) no-repeat;}
    .black_excelModel{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_excelModel.png) no-repeat;}
    .write_excelModel{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_excelModel.png) no-repeat;}
    .black_user{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_user.png) no-repeat;}
    .write_user{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_user.png) no-repeat;}
    .black_userMenuPower{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_userMenuPower.png) no-repeat;}
    .write_userMenuPower{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_userMenuPower.png) no-repeat;}
    .black_openValidate{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_openValidate.png) no-repeat;}
    .write_openValidate{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_openValidate.png) no-repeat;}
    .black_cfg{ width:20px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_cfg.png) no-repeat;}
    .write_cfg{ width:20px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_cfg.png) no-repeat;}
    .black_logRecord{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_logRecord.png) no-repeat;}
    .write_logRecord{ width:18px;height:18px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_logRecord.png) no-repeat;}
    .black_updateCache{ width:20px;height:18px;margin-top:0px;float:left;display: block;background: url(${path}/resources/images/black_updateCache.png) no-repeat;}
    .write_updateCache{ width:20px;height:18px;margin-top:0px;float:left;display: block;background: url(${path}/resources/images/write_updateCache.png) no-repeat;}
    .black_medicine{ width:18px;height:19px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_medicine.png) no-repeat;}
    .write_medicine{ width:18px;height:19px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_medicine.png) no-repeat;}
    .black_prescription{ width:18px;height:20px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/black_prescription.png) no-repeat;}
    .write_prescription{ width:18px;height:20px;margin-top:2px;float:left;display: block;background: url(${path}/resources/images/write_prescription.png) no-repeat;}
    .black_report{ width:18px;height:20px;margin-top:0px;float:left;display: block;background: url(${path}/resources/images/black_report.png) no-repeat;}
    .write_report{ width:18px;height:20px;margin-top:0px;float:left;display: block;background: url(${path}/resources/images/write_report.png) no-repeat;}
    
</style>
<script type="text/javascript">
$(function() {
	var height = $(document).height();
	var menuHeight = $('#menu_list').offset().top;
	var listHeight = height - menuHeight;
	$('#menu_list').height(height - menuHeight);
    $('#menu_list').mCustomScrollbar();
	
    var flag = false;
    $("#hide-btn").click(function() {
        if (!flag) {
            $(".title-txt").hide();
            $("#hide-btn").find('i').removeClass('left_menu').addClass('right_menu');
            $('.group-item > i').css('margin-left','0px');
            $(".list-group-txt").hide();
            $('#left-panel').css('width', '50px');
            $('.container-fluid').css('margin-left', '50px');
            flag = true;
        } else {                
            $('#left-panel').css('width','189px');
            $('.container-fluid').css('margin-left', '189px');
            $(".title-txt").show();
            $('.group-item > i').css('margin-left','10px');
            $("#hide-btn").find('i').removeClass('right_menu').addClass('left_menu');
            $(".list-group-txt").show();
            flag = false;
        }           
    });
    
    showChildMenu();// 显示子菜单
    
    showCurrentMenu();//显示当前菜单
});




function operManage(childPath){
    loadingOpen();
    var url = "${path }" + childPath;
    window.location.href = url;
}

//显示当前菜单
function showCurrentMenu() {
    var requestUrl = window.location.href.split('${path}' + '/')[1];
    var requestUrlArray = requestUrl.split('/');
    var prevUrl = requestUrlArray[0];
    var a = $("div.child-list").find('a');
    for (var i = 0; i < a.length; i++) {
        var leftUrlArray = $(a[i]).attr('id').split('/');
        var leftPrevUrl = leftUrlArray[1];
        if (prevUrl == leftPrevUrl) {
            $(a[i]).removeClass('offUrl list-group-item p-group-item');
            $(a[i]).find('i').removeClass('black_'+leftPrevUrl);
            $(a[i]).addClass('onUrl list-group-item p-group-item');
            $(a[i]).find('i').addClass('write_'+leftPrevUrl);
            $(a[i]).parent().css({"display":"block"});
            var downIcon = $(a[i]).parent().prev().find(":first-child");
            if($(downIcon).hasClass("icon-left")){
                $(downIcon).removeClass("icon-left");
                $(downIcon).addClass("icon-down");
            }else{
                $(downIcon).removeClass("icon-down");
                $(downIcon).addClass("icon-left");
            }
            break;
        }
    }
}
    
/**
 * 显示子菜单
 * @return
 */
function showChildMenu() {
    var menu =  $("#left-panel .p-group-item");
    var flag = false;
    for(var i = 0;i < menu.length;i++){
        var count = 0;
        $(menu[i]).on('click',function(){
            $(this).next().slideToggle(300);
            var downIcon = $(this).find(":first-child");
            if($(downIcon).hasClass("icon-left")){
                $(downIcon).removeClass("icon-left");
                $(downIcon).addClass("icon-down");
            }else{
                $(downIcon).removeClass("icon-down");
                $(downIcon).addClass("icon-left");
            }
        });
    }
}
</script>
<!-- 左侧菜单 -->
<div id="left-panel" class="panel col-md-2 col-sm-12" style="top:51px;width:189px;">
   <div id="menu_list" class="list-group text-left bar_scroll">
        <a class="offUrl list-group-item" id="hide-btn" style="font-size: 12px; height:35px;line-height: 11px;"><i class="left_menu"></i></a>
 
        <c:forEach items="${userMenuList}" var="s">
           <a class="offUrl list-group-item p-group-item"><i class="icon-left"></i>&#12288;<span class="title-txt">${s.menu.menuName }</span></a>
           <c:if test="${not empty secondMenuMap[s.menuId]}">
                <div class="list-group child-list">
                    <c:forEach items="${secondMenuMap[s.menuId]}"  var="a">
                        <a class="offUrl list-group-item group-item" href="javascript:void(0)" id="menu_${a.menu.menuUrl }" onclick="operManage('${a.menu.menuUrl }')"><i class="${a.menu.menuIconUrl}" style="margin-left:10px;"></i>&#12288;<span class="list-group-txt">${a.menu.menuName }</span></a>
                    </c:forEach>
                </div>
            </c:if>
        </c:forEach>
    </div>  
</div>