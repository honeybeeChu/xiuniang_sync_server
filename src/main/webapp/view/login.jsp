<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/default.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>绣娘管理平台－登录</title>
<meta name="description" content="">
<meta name="keywords" contents="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="static/css/login.css" />	
</head>
<body>
	<div class="bg_box"
		style="position: relative; width: 100%; height: 100%; z-index: -1">
		 <img style="position:fixed;" src="static/images/login_bg.jpg" height="100%" width="100%" /> 
	</div>
	<div class="main">
		<div class="box clearfix">
			<form action="${ctxPath}/login">
				<div class=" login_left fl">
					<div style="padding-top: 80px;">
						<img src="static/images/ico.png" style="height:190px;width:150px;">
					</div>
					<p style="padding-top: 10px;">日志留存平台</p>
				</div>
				<div class="login_right  fl">
					<div style="margin-top: 20px;">登&nbsp;录</div>
					<!--<div class="errors_box" >-->
					<!--<div  class="errors" style="display: blcok">用户名或密码错误，请确认！</div>-->
					<!--</div>-->
					<div class="row mt15">
						<input type="text" autocomplete="off" size="25" value=""
							placeholder="账号" accesskey="u" tabindex="1" class="required"
							name="username" id="username" style="color: #333;"
							onfocus="if(value=='账号'){this.style.color='#000';value=''}"
							onblur="if(value==''){this.style.color='#333';value='账号'}">
					</div>
					<div class="row">
						<input type="password" autocomplete="off" size="25" value=""
							accesskey="p" tabindex="2" class="required password"
							name="password" id="password" placeholder="密码"
							style="color: #333;"
							onfocus="if(value=='密码'){this.style.color='#000';value=''}"
							onblur="if(value==''){this.style.color='#333';value='密码'}">
					</div>
					<div class="row btn-row">
						<input value="登 录" type="submit" class="btn-submit" id="loginBtn">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="foot">版权所有©绣娘丝绸（中国）有限公司</div>

</body>
</html>