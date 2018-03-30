<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绣娘管理平台－登录</title>
<link href="${staticPath}/css/dpl.css" rel="stylesheet">
<link href="${staticPath}/css/bootstrap-datetimepicker.css"
	rel="stylesheet" media="screen">
<link href="${staticPath}/css/pagechange.css" rel="stylesheet"
	media="screen">

</head>
<body>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/menu_action.jsp"%>
	<div class="J_mainframe main">
		<div id="J_ajax_container" class="main-content">
			<div class="crumb_box">
				<span class="c333">客户管理</span><span class="pl10 pr10 ">·</span><a
					href="#" class="c999">客户详情</a>
			</div>
				<div class="well2 clearfix " style="margin-top: 5px;">
					<table
						class="table table-bordered  table-head-bordered table-hover  left">
						<tr>
							<td width="150"><span class="c999">真实姓名</span></td>
							<td width="250">${customer_info.buyer_name }</td>
							<td width="150"><span class="c999">平台</span></td>
							<td>${customer_info.sale_channel_code }</td>
							<td width="150"><span class="c999">手机</span></td>
							<td>${customer_info.phone}</td>
						</tr>
						<tr>
							<td><span class="c999">支付方式</span></td>
							<td>${customer_info.pay_code}</td>
							<td><span class="c999">生日</span></td>
							<td>2009-12-02</td>
							<td><span class="c999">省份城市</span></td>
							<td>${customer_info.receiver_province}</td>
						</tr>
					</table>
					<table
						class="table table-bordered  table-head-bordered table-hover  left">
						<tr>
							<td width="150"><span class="c999">会员级别</span></td>
							<td width="250">普通会员</td>
							<td width="150"><span class="c999">会员状态</span></td>
							<td colspan="3">普通会员</td>
						</tr>
						<tr>
							<td><span class="c999">信用等级</span></td>
							<td><i class="iconfont icon-xingji cred"></i><i
								class="iconfont icon-xingji cred"></i><i
								class="iconfont icon-xingji cred"></i><i
								class="iconfont icon-xingji cred"></i><i
								class="iconfont icon-xingji cred"></i></td>
							<td><span class="c999">交易次数</span></td>
							<td>${customer_info.counter}次</td>
							<td width="150"><span class="c999">交易额</span></td>
							<td>${customer_info.amounter}（元）</td>
						</tr>
						<tr>
							<td><span class="c999">上次交易时间</span></td>
							<td>${customer_info.laster_timer}</td>
							<td><span class="c999">宝贝件数</span></td>
							<td>${customer_info.counter}件</td>
							<td><span class="c999">平均订单金额</span></td>
							<td>${customer_info.avger}（元）</td>
						</tr>
						<tr>
							<td><span class="c999">交易关闭数</span></td>
							<td>1笔</td>
							<td><span class="c999">客户来源</span></td>
							<td colspan="3">百盛订单系统</td>
						</tr>
						<tr>
							<td><span class="c999">收货地址</span></td>
							<td colspan="5">${customer_info.receiver_address}</td>
						</tr>
					</table>
				</div>

</body>

<style type="text/css">
.row {
	margin-left: -56px;
}
</style>
</html>