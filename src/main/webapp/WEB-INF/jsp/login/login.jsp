<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<style>
.iconball {
    height: 100%;
    width: 100%;
    background: url(${path}/resources/images/2.png) no-repeat 50%;
    animation: rotateFsash 8s linear infinite;
    -webkit-animation: rotateFsash 8s linear infinite;
    background-size: 70%;
    /*Safari and Chrome*/
}

.ballDiv {
    height: 323px;
    width: 420px;
    background-color: #074771;
    border-radius: 20px;
}

.bigball {
    float: right;
}

@-webkit-keyframes rotateFsash { 0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg)
}

to {
    -webkit-transform: rotate(1turn);
    transform: rotate(1turn)
}

}
@keyframes rotateFsash { 0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg)
}

to {
    -webkit-transform: rotate(1turn);
    transform: rotate(1turn)
}

}
.loginDiv {
    float: right;
    height: 303px;
    width: 38%;
    margin-right: 7%;
    background-color: #1B93B7;
    border-radius: 20px;
    padding: 20px 20px 0px 20px;
}
</style>
<!DOCTYPE html>
<html>
<head>
<title>中医药专家医案管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${path}/resources/css/login.css">
<link href="${path}/resources/css/jquery.confirm.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="login-content">
		<div class="wrapper">
			<div class="login-main">
				<div class="login" style="width: 1000px; height: 380px">
					<div class="loginDiv">
						<div style="font-size: 24px; color: #fff; margin-bottom: 9px;">中医药专家医案管理系统</div>
						<form method="post" action="${path}/login/accessLogin.action">
							<ul>
								<li class="icon-left">
									<i class="icon ion-user"></i>
									<input name="userAcc" id="username" type="text" placeholder="用户名" required="required">
								</li>
								<div id="user"></div>
								<li class="icon-left">
									<i class="icon ion-pwd"></i>
									<input name="userPwd" id="password" type="password" placeholder="密码" required="required">
								</li>
								<div id="pwd"></div>
								<c:if test="${openValidate.cfgValue eq 'Y'}">
									<li>
										<input name="verifyCode" id="vercode" class="authCode" type="text" placeholder="验证码" required="required">
										<span class="qcode">
											<img id="verifyImage" src="${path}/login/captcha.action" onclick="reloadVerifyCode()" width="100%" height="40px" style="background-color: #fff;">
										</span>
										<span onclick="reloadVerifyCode()" class="next-btn">换一张</span>
									</li>
								</c:if>
								<div id="chk"></div>
								<li>
									<button type="submit" class="button button-block button-color1">登录</button>
								</li>
							</ul>
							<c:if test="${!empty loginErrorMessage}">
								<div class="form-group col-md-12">
									<font color="red">登录失败：${loginErrorMessage }</font>
								</div>
							</c:if>
						</form>

					</div>

					<div class="bigball">
						<div class="ballDiv">
							<div class="iconball"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${path}/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${path}/resources/js/slidecop.js" type="text/javascript"></script>
	<script src="${path}/resources/js/jquery.confirm.js" type="text/javascript"></script>
	<script>
		$(function() {
			var openValidate = "${openValidate.cfgValue}";
			if (openValidate == 'Y') {
				$("#chk").hide();
			}
		})
		function reloadVerifyCode() {
			$("#verifyImage").attr("src",
					"${path}/login/captcha.action?random=" + Math.random());
		}
		function checkform1() {

			document.getElementById('tishi').innerHTML = "<label></label>";
		}

		function getRightDate() {
			$("#loginBtn").attr({
				'disabled' : true
			});
			var var1 = document.getElementById("username").value;
			var var2 = document.getElementById("password").value;
			var var3 = document.getElementById("vercode").value;
			document.getElementById('user').innerHTML = "";
			document.getElementById('pwd').innerHTML = "";
			document.getElementById('chk').innerHTML = "";
			if (var1.length == 0) {
				document.getElementById('user').innerHTML = "<label style='color: red'>请输入您的用户名!</label>";
				changge();
				return false;
			} else {
				var pattern = /^[0-9a-zA-Z]+$/;
				if (!pattern.test(document.getElementById("username").value)) {
					document.getElementById('user').innerHTML = "<label style='color: red'>用户名只可输入数字或者字母!</label>";
					document.getElementById("username").value = "";
					document.getElementById("password").value = "";
					document.getElementById("vercode").value = "";
					changge();
					return false;
				}
			}

			if (var2.length == 0) {
				document.getElementById('pwd').innerHTML = "<label style='color: red'>请输入您的口令!</label>";
				changge();
				return false;
			}

			if (var3.length == 0) {
				document.getElementById('chk').innerHTML = "<label style='color: red'>请输入验证码!</label>";
				changge();
				return false;
			}
			$.ajax({
				url : "login2_ajax.jsp?var1=" + var1 + "&var2=" + var2
						+ "&var3=" + var3 + "&type=1",
				type : "post",
				data : {},
				success : function(result) {
					var data = result.split("||");
					var data0 = data[0];
					var data1 = data[1];
					var data2 = data[2];
					document.getElementById('user').innerHTML = "";
					document.getElementById('pwd').innerHTML = "";
					document.getElementById('chk').innerHTML = "";
					data0 = data0 == null ? "" : $.trim(data0);
					data1 = data1 == null ? "" : $.trim(data1);
					data2 = data2 == null ? "" : $.trim(data2);
					if (data0.length == 0) {
						window.location.href = ("index.jsp");
					} else {
						if (data0.indexOf('您输入的用户名或密码有误')) {
							document.getElementById('pwd').innerHTML = data0;
						} else if (data0.indexOf('验证码不匹配')) {
							document.getElementById('chk').innerHTML = data0;
						} else {
							document.getElementById('chk').innerHTML = data0;
						}
						document.getElementById("username").value = "";
						document.getElementById("password").value = "";
						document.getElementById("vercode").value = "";
						changge();
					}
					$("#loginBtn").attr({
						'disabled' : false
					});
				},
				error : function(result) {
					$("#loginBtn").attr({
						'disabled' : false
					});
				}
			});
		}

		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				getRightDate();
			}
		});
	</script>
</body>
</html>