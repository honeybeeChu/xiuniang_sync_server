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
<link href="${staticPath}/css/pagechange.css" rel="stylesheet" media="screen">

</head>
<body>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/menu_action.jsp"%>
	<div class="J_mainframe main">
		<div id="J_ajax_container" class="main-content">
			<div class="crumb_box">
				<span class="c333">客户管理</span><span class="pl10 pr10 ">·</span><a
					href="#" class="c999">客户列表</a>
			</div>
			<div class=" ml10 mt20  clearfix">
				<div class=" mt10 clearfix">
					<div class="tag_box fl ">
						<a href="#" class=" tags  border-left tag_on">成交客户</a><a href="#"
							class=" tags  ">未成交客户</a> <a href="#" class=" tags border-right ">询单客户</a>
					</div>
				</div>
			</div>
			<form action="${ctxPath}/customer/index">
			<div class="well2 clearfix " style="margin-top: 5px;">
				<div class="form-horizontal onlineTools">
					<div class="row row-fluid">
						<div class="span8">
							<label class="control-label">客户昵称</label>
							<div class="controls">
								<input size="16" name="nickname" type="text" class=" input-medium" value="${nickname}" 
									placeholder="不限">
							</div>
						</div>
						<div class="span8">
							<label class="control-label">会员级别</label>
							<div class="controls">
								<select class="input-medium" name="is_membership" value="${is_membership}">
									<option value="is_is" ${is_membership=='is_is'?'selected':''}>会员</option>
									<option  value="is_not" ${is_membership=='is_not'?'selected':''}>非会员</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row row-fluid">
						<div class="span8">
							<label class="control-label">交易金额</label>
							<div class="controls">
								<input size="16" type="text" placeholder="0" name="trade_amount_from" value="${trade_amount_from}"
									class=" input-small"> - <input size="16" name="trade_amount_to" value="${trade_amount_to}" type="text"
									class=" input-small" placeholder="不限">
							</div>
						</div>
						<div class="span8">
							<label class="control-label">交易笔数</label>
							<div class="controls">
								<input size="16" type="text" name="trade_number_from" class=" input-small" value="${trade_number_from}" 
									placeholder="1"> - <input name="trade_number_to" size="16" type="text" value="${trade_number_to}"
									class=" input-small" placeholder="不限">
							</div>
						</div>
						<div class="span8">
							<label class="control-label">上次交易时间</label>
							<div class="controls">
								<input size="16" type="text" name="trade_date_from" value="${trade_date_from}"
									class="input-small" placeholder="不限"> - 
									<input
									size="16" type="text" name="trade_date_to" class="input-small" value="${trade_date_to}"
									placeholder="不限">
							</div>
						</div>
					</div>
					<div class="row row-fluid">
						<div class="span8">
							<label class="control-label">省份</label>
							<div class="controls">
								<select class="input-medium" name="province" value="${province}">
									<option>全部</option>
								</select>
							</div>
						</div>
						<div class="span8">
							<label class="control-label">城市</label>
							<div class="controls">
								<select class="input-medium" name="city" value="${city}">
									<option>不限</option>
								</select>
							</div>
						</div>
					</div>

					<div class="row row-fluid">
						<div class="span20">
							<div class="controls">
								<button type="submit" id="search_btn" class="button button-primary">搜索</button>
							</div>
						</div>

					</div>
				</div>
			</div>
			
			</form>


			<div class="well2 clearfix " style="margin-top: 5px;">
				<table class=" user_tab" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<th style="text-align: left;" width="40"><input type="checkbox"></th>
							<th style="text-align: left;" width="100">客户姓名</th>
							<th style="text-align: left;">会员级别</th>
							<th style="text-align: left;">交易总额（元）</th>
							<th style="text-align: left;">交易笔数（笔）</th>
							<th style="text-align: left;">平均交易金额（元）</th>
							<th style="text-align: left;">上次交易时间</th>
							<th style="text-align: left;" width="150">操作</th>
						</tr>
					</thead>
					
					<c:forEach var="customerInfo" items="${customerInfoList}">
						<tr>
								<td rowspan="2"><input type="checkbox"></td>
								<td rowspan="2"><i class="iconfont icon-wangwang "></i>${customerInfo.buyer_name}</td>
								<td>普通会员</td>
								<td>${customerInfo.amounter}</td>
								<td>${customerInfo.counter}</td>
								<td>${customerInfo.avger}</td>
								<td>${customerInfo.laster_timer}</td>
								<td><a class="J_user_edit pr10" href="#">详情</a><a
									class="J_delete pr10" href="#">交易记录</a></td>
							</tr>
							<tr>
								<td colspan="6" style="text-align: left;">
									<div class="tab_menu">
										<a href="#">昵称：${customerInfo.nickname}</a> <a href="#">号码：${customerInfo.phone}</a>
									</div>
								</td>
							</tr>
					</c:forEach>
				</table>
				<!--分页-->
				<div class="js_pagebar" style="text-align: right;">
					<div class="pagination">
						<span class="page_nav_area"> <a href="${ctxPath}/customer/index.do?pageIndex=${page.pageNum > 1 ? page.pageNum -1 : 1}"
							class="btn page_prev"><i class="arrow"></i></a> <span
							class="page_num"> <label>${page.pageNum}</label> <span class="num_gap">/</span>
								<label>${page.pages}</label>
						</span> <a href="${ctxPath}/customer/index.do?pageIndex=${page.pageNum + 1 < page.pages ? page.pageNum +1 :page.pages}" class="btn page_next"><i
								class="arrow"></i></a>
						</span> <span class="goto_area"> <input id="page_index_input" page-total=${page.pages} type="text" value=${page.pageNum}> <a
							href="javascript:void(0);" class="btn page_go">跳转</a>
						</span>
					</div>
				</div>
				<!--//分页-->
			</div>

			<script type="text/javascript"
				src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
			<script type="text/javascript" src="${staticPath}/js/moment.js"></script>
			<script
				src="https://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/daterangepicker.js"></script>
			<script type="text/javascript"
				src="${staticPath}/js/customer/customer_index.js"></script>
</body>

<style type="text/css">
.row {
	    margin-left: -56px;
}

</style>
</html>