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
					href="#" class="c999">客户订单详情</a>
			</div>
			<div class="well2 clearfix " style="margin-top: 5px;">
				<div class="order_box">
					<table class="order_tab " cellpadding="0" cellspacing="0">
						<thead>
							<tr>
								<th width="100">宝贝</th>
								<th>单价</th>
								<th>数量</th>
								<th>姓名</th>
								<th>昵称</th>
								<th>交易平台</th>
								<th>实收款</th>
								<th>快递</th>
								<th width="100">买家留言</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach  var="orderInfo" items="${orderlist}">
								<tr>
								<td colspan="9">
									<p>订单编号： ${orderInfo.sellRecordCode }</p>
									<p>成交时间：${orderInfo.payTime }</p>
								</td>
							</tr>
							<tr>
								<td class="text-left"><a href="" target="_blank"><img
										src="../images/ex.jpg" class="fl mr10" alt="80x80"
										data-src="hd.js/80x80" style="width: 80px; height: 80px;"></a>
									<h5>
										<a href="" target="_blank">${orderInfo.goodsName }</a>
									</h5>
								</td>
								<td width="130">
									<div class="s_price">￥${orderInfo.payableMoney }</div>
								</td>
								<td width="100">${orderInfo.goodsNum ==null? 1 : orderInfo.goodsNum }</td>
								<td  width="130"><a href="#">${orderInfo.receiverName }</a></td>
								<td><a href="#">${orderInfo.buyerName }</a><br> 
								</td>
								<td>
									<div>${orderInfo.saleChannelCode }</div>
								</td>
								<td>
									<div>
										<b>￥${orderInfo.payableMoney }</b>
									</div>
									<div>(含快递：￥${orderInfo.expressMoney==null? 0 : orderInfo.expressMoney })</div>
								</td>
								
								<td>
									<c:if test="${orderInfo.expressCode == 'SF' }">
										顺丰
									</c:if>
									<c:if test="${orderInfo.expressCode == 'YTO' }">
										圆通
									</c:if>
								</td>
								
								<td>
									${orderInfo.buyerRemark == '' ? '无' :  orderInfo.buyerRemark}
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--分页-->
				<div class="ad-page-outer ">
					<div id="kkpager" class="fr"></div>
				</div>
			</div>
</body>

<style type="text/css">
.row {
	margin-left: -56px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#customer_manager").trigger("click");
		$("#customer_list >a").addClass("on");
		
	});
</script>
</html>