<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>店铺信息</title>
<link rel="stylesheet"
	href="http://cache.amap.com/lbs/static/main1119.css" />
<link href="${staticPath}/css/navigate/show.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
#l-map {
	position: absolute;
	top: 0;
	left: 0;
	display: block;
	width: 100%;
	height: 100%;
}
</style>
<script type="text/javascript"
	src="http://webapi.amap.com/maps?v=1.3&key=8fd27fadc7a12297f415896aed9fe4bf&plugin=AMap.Driving"></script>
<script type="text/javascript"
	src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
	<div class="u_body">
		<div id="sdetail_box">
			<header class="u_header" style="z-index: 100;">
				<span class="overflow">${shopname}</span> <a class="icon l icon3"
					href="javascript:history.go(-1);"></a>
			</header>
			<div id="l-map" style="height: 100%; min-height: 100%;"></div>
		</div>
	</div>

	<script type="text/javascript">
		//基本地图加载
		var map = new AMap.Map("l-map", {
			resizeEnable : true,
			center : [ getQueryString("fromLongitude"), getQueryString("fromLatitude") ],//地图中心点
			zoom : 13
		//地图显示的缩放级别
		});
		//构造路线导航类
		var driving = new AMap.Driving({
			map : map,
			panel : "l-map"
		});
		// 根据起终点名称规划驾车导航路线
		driving.search([ getQueryString("fromLongitude"), getQueryString("fromLatitude") ], [ getQueryString("toLongitude"), getQueryString("toLatitude") ]);
		
		function getQueryString(name) { 
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r != null) return unescape(r[2]); return null; 
		} 
	</script>
</body>
</html>