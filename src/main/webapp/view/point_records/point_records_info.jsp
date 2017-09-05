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
				<span class="c333">积分管理</span><span class="pl10 pr10 ">·</span><a
					href="#" class="c999">积分信息查看</a>
			</div>
			<div class="well2 mt10">
				<div class="form-horizontal onlineTools">
					<div class="row-fluid" style="margin-left: 20px;">
						<div class="span10">
							<form action="init.do" method="GET">
								<input type="hidden" value="&#x2713;" /> <label
									for="DYMC">手机号码:</label> 
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
						共查询到 <span class="text-danger">${page.total} </span> 条积分信息
					</div>
				</div>
				<table
					class="table table-bordered table-striped table-head-bordered table-hover center ">
					<thead>
						<tr>
							<th>序号</th>
							<th>用户手机号</th>
							<th>有赞昵称</th>
							<th>积分变动值</th>
							<th>积分变动后总值</th>
							<th>变动描述</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${pointsRecordList}" varStatus="status">
							<tr>
							<td>${status.index + 1}</td>
							<td>${record.mobile}</td>
							<td>${record.kdtName}</td>
							<td>${record.amount}</td>
							<td>${record.total}</td>
							<td>${record.description}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="js_pagebar" style="text-align: right;">
				<div class="pagination">
					<span class="page_nav_area"> <a href="${ctxPath}/point_records/init.do?pageIndex=${page.pageNum > 1 ? page.pageNum -1 : 1}&dymc=${searchDYMC}"
						class="btn page_prev"><i class="arrow"></i></a> <span
						class="page_num"> <label>${page.pageNum}</label> <span class="num_gap">/</span>
							<label>${page.pages}</label>
					</span> <a href="${ctxPath}/point_records/init.do?pageIndex=${page.pageNum + 1 < page.pages ? page.pageNum +1 :page.pages}&dymc=${searchDYMC}" class="btn page_next"><i
							class="arrow"></i></a>
					</span> <span class="goto_area"> <input id="page_index_input" page-total=${page.pages} type="text" value=${page.pageNum}> <a
						href="javascript:void(0);" class="btn page_go">跳转</a>
					</span>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${staticPath}/js/common.js"></script>
	<script type="text/javascript" src="${staticPath}/js/point_records/point_records_info.js"></script>
</body>
</html>