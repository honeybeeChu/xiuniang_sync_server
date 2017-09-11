<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/default.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>绣娘管理平台－登录</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<script type="text/javascript" src="${staticPath}/js/echarts.common.min.js"></script>
</head>
<body>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/menu_action.jsp"%>

	<div class="J_mainframe main">
		<div id="J_ajax_container" class="main-content">
			<div class="crumb_box">
				<span class="c333">店员管理</span><span class="pl10 pr10 ">·</span><a
					href="#" class="c999">店员观察</a>
			</div>
			<div class="well mt5">
			
			  <div class=" fl" style=" width: 50%;">
			    <div id='chart1' class="chart " style="height: 450px;"></div>
			  </div>
			  <div class=" fl" style=" width: 50%;">
			    <div id='chart2' class="chart " style="height: 450px;"></div>
			  </div>

		</div>
	</div>
	
	<script type="text/javascript" src="${staticPath}/js/dianyuan/dianyuan_discovery.js"></script>
</body>
</html>