<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>店铺信息</title>
<link href="${staticPath}/css/navigate/index.css" rel="stylesheet"
	type="text/css" />
<body>
	<div class="u_body">
		<div id="sdetail_box">
			<header class="u_header">
				<span class="overflow">${'' == wx_shop.branchName ? wx_shop.businessName : wx_shop.branchName}</span> <a
					class="icon l icon3" href="javascript:history.go(-1);"></a>
			</header>
			<div class="u_box" style="padding: 0px;">
				<div style="padding: 10px;">
					<section id="l-map" class="amap-container"
						style="height: 245px; position: relative;"></section>
				</div>
				<article class="u_store_info" style="background: #fff;"
					id="u_store_info">
					<div>
						<h1>${wx_shop.branchName}</h1>
						<address>${wx_shop.province}${wx_shop.city}${ wx_shop.address }</address>
						<tel>${wx_shop.telephone}</tel>
					</div>
					<div>
						<a href="tel:${wx_shop.telephone}"
							style="text-indent: 2em; background: url(http://m.uniqlo.cn/html5/images/SDetail_phone.png) no-repeat #FAFAFA 25% center; background-size: 30px auto;">拨打电话</a>
						<a id="to_navigate_page"
							style="text-indent: 2em; background: url(http://m.uniqlo.cn/html5/images/SDetail_path.png) no-repeat #FAFAFA 25% center; background-size: 30px auto;"
							href="http://xiuniang.yaxin-nanjing.com/navigate/shopnavigate.do?fromLongitude=${fromLongitude}&fromLatitude=${fromLatitude}&toLongitude=${toLongitude}&toLatitude=${toLatitude}&shopid=${wx_shop.id}">线路导航</a>
					</div>
					

					<div>
						<div>
							<p style="font-size: 13px; line-height: 20px; color: #737373;">营业时间</p>
							${wx_shop.openTime }
						</div>
					</div>
					<div>
						<div>
							<p style="font-size: 13px; line-height: 20px; color: #737373;">销售范围</p>
							${wx_shop.categories }
						</div>
					</div>
				</article>
			</div>
		</div>
		<div id="bigmap_box" class="u_hidden">
			<header class="u_header">
				<span class="overflow">${wx_shop.branchName}</span> <a
					class="icon l icon3"
					href="javascript:$('#sdetail_box').show();$('#bigmap_box').hide();"></a>
			</header>
			<div id="l-map-big" style="height: 573px;"></div>
		</div>
	</div>

	<script type="text/javascript"
		src="http://webapi.amap.com/maps?v=1.4.4&key=8dff034d77689b8f862d870f0e586da0"></script>
	<script>
		//基本地图加载
		var marker, map = new AMap.Map('l-map', {
			icon : "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
			resizeEnable : true,
			zoom : 11,
			center : [ getQueryString("toLongitude"), getQueryString("toLatitude") ]
		});

		marker = new AMap.Marker({
			icon : "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
			position : [ getQueryString("toLongitude"), getQueryString("toLatitude") ]
		});
		marker.setMap(map);
		
		function getQueryString(name) { 
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r != null) return unescape(r[2]); return null; 
		} 
		
	</script>
</body>
</html>
