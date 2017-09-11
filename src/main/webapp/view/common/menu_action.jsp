<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar" id="leftbar">
	<div class="menu">
		<div class="vtitle active" data-type="dianyuan" id="dianyuan_manager">
			<a href="#"><i class="iconfont icon_menu icon-wangluo"></i>店员管理</a> <em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
		<div class="vcon" data-type="dianyuan">
			<ul class="menu_body clearfix">
				<li id="ipbased"><a id="dianyuan_01"
					href="${ctxPath}/dianyuan/info">店员查询</a></li>
				<li id="ipgw"><a id="dianyuan_02"
					href="${ctxPath}/dianyuan/discovery">店员观察</a></li>
				<li id="ipgw"><a id="dianyuan_03"
					href="${ctxPath}/dianyuan/performance">店员业务</a></li>
			</ul>
		</div>
		
		
		
		<div class="vtitle" data-type="tongji">
			<a href="#"><i class="iconfont icon_menu icon-tongjitubiao"></i>统计报表</a><em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
		<div class="vcon" data-type="tongji" style="display: none;">
			<ul class="menu_body clearfix">
				<li id="yxchart"><a href="#javascript:;">运行日志报表</a></li>
			</ul>
		</div>
		
		
		
		<div class="vtitle" data-type="fansmanager" id="wxuser_manager">
			<a href="#"><i class="iconfont icon_menu icon-fensi"></i>粉丝管理</a> <em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
		<div class="vcon" data-type="fansmanager" style="display: none;">
			<ul class="menu_body clearfix">
				<a id="wxuser_01" href="/wxuser/distribution">粉丝地理分布</a>
				<a id="wxuser_02" href="/wxuser/wxuserInfo">粉丝信息列表</a>
			</ul>
		</div>

        <div class="vtitle" data-type="member_ship" id="member_ship_set">
			<a href="#"><i class="iconfont icon_menu icon-fensi"></i>会员设置</a> <em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
        <div class="vcon" data-type="member_ship" style="display: none;">
			<ul class="menu_body clearfix">
				<a id="member_ship_01" href="${ctxPath}/member_ship/init">会员查询</a>
			</ul>
		</div>
		
		<div class="vtitle" data-type="point_records" id="point_records_set">
			<a href="#"><i class="iconfont icon_menu icon-fensi"></i>积分管理</a> <em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
        <div class="vcon" data-type="point_records" style="display: none;">
			<ul class="menu_body clearfix">
				<a id="point_records_01" href="${ctxPath}/point_records/init">积分查询</a>
			</ul>
		</div>
		
		<div class="vtitle" data-type="point_rules" id="point_rules_set">
			<a href="#"><i class="iconfont icon_menu icon-fensi"></i>等级管理</a> <em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
        <div class="vcon" data-type="point_rules" style="display: none;">
			<ul class="menu_body clearfix">
				<a id="point_rules_01" href="${ctxPath}/point_rules/init">等级查询</a>
			</ul>
		</div>
		
		<div class="vtitle" data-type="systemset" id="system_set">
			<a href="#"><i class="iconfont icon_menu icon-fensi"></i>系统设置</a> <em
				class=" iconfont icon_menu icon-unfold"></em>
		</div>
		<div class="vcon" data-type="systemset" style="display: none;">
			<ul class="menu_body clearfix">
				<a id="systemset_01" href="/points_rules">积分设置</a>
			</ul>
		</div>


		<!--<div class="vtitle">-->
		<!--<a href="#">-->
		<!--<i class="iconfont icon_menu icon-shezhi"></i>-->
		<!--系统管理-->
		<!--</a>-->
		<!--<em class=" iconfont icon_menu icon-unfold"></em>-->
		<!--</div>-->
		<!--<div class="vcon" style="display: none;">-->
		<!--<ul class="menu_body clearfix">-->
		<!--<li  id="role" ><a href="javascript:;" >角色管理</a></li>-->
		<!--<li id="user"><a href="javascript:;">管理员管理</a></li>-->
		<!--<li id="rolesq"><a href="javascript:;">角色授权</a></li>-->
		<!--</ul>-->
		<!--</div>-->

	</div>
</div>

<script type="text/javascript">
	$(".vtitle").click(function(){
		$(".vtitle").removeClass("active");
		$(this).addClass("active");
		
		var dataType = $(this).attr("data-type");
		$(".vcon").hide();
		$(".vcon[data-type= "+dataType+"]").show();
	});

</script>

