<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绣娘管理平台－登录</title>
<link href="${staticPath}/css/dianyuan/dianyuan_info.css" rel="stylesheet" media="screen">
</head>
<body>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/menu_action.jsp"%>

	<div class="J_mainframe main">
		<div id="J_ajax_container" class="main-content">
			<div class="crumb_box">
				<span class="c333">等级管理</span><span class="pl10 pr10 ">·</span><a
					href="#" class="c999">等级信息查看</a>
			</div>
			<div class="well2 mt10">
				<div class="form-horizontal onlineTools">
					<div class="row-fluid" style="margin-left: 20px;">
						<div class="span10">
							<form action="init.do" method="GET">
								<input type="hidden" value="&#x2713;" /> <label
									for="DYMC">等级:</label> 
									<input type="text" name="dymc"
									id="DYMC" style="height: 28px;" value=${searchDYMC} > 
									<button type="submit" id="search_by_dymc_btn"
									 class="button  button-primary">查询</button>
									 <input 
									type="button" id="resetBtn" class="button ml10"
									 value="重置" />
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="well">
				<div class="mb10 clearfix">
					<!--<div class="fl"><h4>角色列表</h4></div>-->
					<!--<button href="#" class="button button-info fr"><i class="icon-white icon-plus"></i>新增角色</button>-->
					<div class="fl">
						共查询到 <span class="text-danger">${page.total} </span> 条等级信息
					</div>
				</div>
				<table
					class="table table-bordered table-striped table-head-bordered table-hover center ">
					<thead>
						<tr>
							<th>序号</th>
							<th>等级</th>
							<th>等级名称</th>
							<th>升级到此level的条件</th>
							<th>积分兑换比例</th>
							<th>打折率</th>
							<th>编辑</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach var="rule" items="${pointsRuleList}" varStatus="status">
							<tr>
							<td style="display:none;" class="id">${rule.id}</td>
							<td>${status.index + 1}</td>
							<td>${rule.level}</td>
							<td>${rule.name}</td>
							<td>${rule.conditions}</td>
							<td>${rule.rate}</td>
							<td>${rule.discount}</td>
							<td><button id="search_by_dymc_btn" class="button button-primary edit">编辑</button></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="js_pagebar" style="text-align: right;">
				<div class="pagination">
					<span class="page_nav_area"> <a href="${ctxPath}/point_rules/init.do?pageIndex=${page.pageNum > 1 ? page.pageNum -1 : 1}&dymc=${searchDYMC}"
						class="btn page_prev"><i class="arrow"></i></a> <span
						class="page_num"> <label>${page.pageNum}</label> <span class="num_gap">/</span>
							<label>${page.pages}</label>
					</span> <a href="${ctxPath}/point_rules/init.do?pageIndex=${page.pageNum + 1 < page.pages ? page.pageNum +1 :page.pages}&dymc=${searchDYMC}" class="btn page_next"><i
							class="arrow"></i></a>
					</span> <span class="goto_area"> <input id="page_index_input" page-total=${page.pages} type="text" value=${page.pageNum}> <a
						href="javascript:void(0);" class="btn page_go">跳转</a>
					</span>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${staticPath}/js/common.js"></script>
	<script type="text/javascript" src="${staticPath}/js/point_rules/point_rules_info.js"></script>
</body>
</html>