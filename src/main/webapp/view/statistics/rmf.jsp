<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绣娘管理平台－登录</title>
<link href="${staticPath}/css/global.css" rel="stylesheet"
	media="screen">
<link href="${staticPath}/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${staticPath}/css/bootstrap-datetimepicker.css"
	rel="stylesheet" media="screen">
<link href="${staticPath}/css/dpl.css" rel="stylesheet" media="screen">
<link href="${staticPath}/css/global.css" rel="stylesheet"
	media="screen">

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
			<div class="well2 mt10" style="margin: -5px 10px 10px;">
				<table class=" rmf_tab " cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<th width="250">
								<div class="fr">最近交易时间R（天）</div> <br>
								<div class="fl">F（次）交易次数</div>
							</th>
							<th>0＜R≤30</th>
							<th>30＜R≤90</th>
							<th>90＜R≤180</th>
							<th>180＜R≤360</th>
							<th>R＞360</th>
							<th>行合计</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>0＜F≤1</th>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>1532人
								<p>5.04%</p>
							</td>
						</tr>
						<tr>
							<th>1＜F≤1</th>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>1532人
								<p>5.04%</p>
							</td>
						</tr>

						<tr>
							<th>2＜F＜=4</th>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>1532人
								<p>5.04%</p>
							</td>
						</tr>
						<tr>
							<th>4＜F＜=8</th>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>1532人
								<p>5.04%</p>
							</td>
						</tr>
						<tr>
							<th>F＞8</th>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td class="rmf_tab_td">532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>1532人
								<p>5.04%</p>
							</td>
						</tr>
						<tr>
							<th>列合计</th>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>532人
								<p>5.04%</p>
							</td>
							<td>1532人
								<p>5.04%</p>
							</td>
						</tr>
					</tbody>
				</table>

				<div class="mt10 clearfix">
					<div class="fl">
						<input type="checkbox">显示占比
					</div>
					<div class="fr">
						<span class="pr10"><input type="radio">活跃客户</span><span
							class="pr10"><input type="radio">沉睡客户</span><span
							class="pr10"><input type="radio">流失客户</span><span
							class="pr10"><input type="radio">全部</span>
					</div>
				</div>

			</div>
		</div>
		<script type="text/javascript" src="${staticPath}/js/common.js"></script>
		<script type="text/javascript"
			src="${staticPath}/js/point_rules/point_rules_info.js"></script>
</body>
</html>