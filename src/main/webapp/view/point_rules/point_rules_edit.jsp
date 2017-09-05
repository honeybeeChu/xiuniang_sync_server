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
				<span class="c333">规则管理</span><span class="pl10 pr10 ">·</span><a
					href="#" class="c999">规则信息编辑</a>
			</div>
			<div class="well2">
				<form action="edit.do" method="post">
					<input type="hidden" value="${pointsRule.id}" id="id" name="id"/>
					<table style="width:500px;" class="table table-bordered">
						<tbody>
							<tr>
	                            <td class="tbl_label">等级:</td>
	                            <td><input type="text" name="level" id="level" value="${pointsRule.level}"></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">规则名称:</td>
	                            <td><input type="text" name="name" id="name" value="${pointsRule.name}"></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">消费金额和积分的增加比例:</td>
	                            <td><input type="text" name="rate" id="rate" value="${pointsRule.rate}"></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">折扣率:</td>
	                            <td><input type="text" name="discount" id="rate2" value="${pointsRule.discount}"></td>
	                        </tr>
						</tbody>
					</table>
					<table style="width:500px;">
						<tbody>
							<tr>
	                            <td style="text-align:left;">
	                            	<input type="submit" id="editBtn" class="button  button-primary" value="修改"/>&nbsp;&nbsp;&nbsp;
	                            	<input type="button" id="returnBtn" class="button  button-primary" value="返回"/>
	                            </td>
	                        </tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${staticPath}/js/common.js"></script>
	<script type="text/javascript" src="${staticPath}/js/point_rules/point_rules_info.js"></script>
</body>
</html>