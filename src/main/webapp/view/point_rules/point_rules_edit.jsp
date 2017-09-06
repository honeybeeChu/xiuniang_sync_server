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
					href="#" class="c999">等级信息编辑</a>
			</div>
			<div class="well2">
				<form action="edit.do" method="post" onsubmit="return checksubmit()">
					<input type="hidden" value="${pointsRule.id}" id="id" name="id"/>
					<table style="width:800px;" class="table table-bordered">
						<tbody>
	                        <tr>
	                            <td class="tbl_label">等级名称:</td>
	                            <td><input type="text" maxlength="20" name="name" id="name" value="${pointsRule.name}"><span style="color:red;font-size:10px;">※等级名称，如预备会员，金卡会员</span></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">消费金额和积分的增加比例:</td>
	                            <td><input type="text" maxlength="5" name="rate" id="rate" value="${pointsRule.rate}"><span style="color:red;">※此等级下的会员，消费金额和积分的增加比例，如1.2  表示1元给1.2个积分</span></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">折扣率:</td>
	                            <td><input type="text" maxlength="5" name="discount" id="discount" value="${pointsRule.discount}"><span style="color:red;">※此等级下的会员，线下消费时享受的折扣率，0~1</span></td>
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
	<script type="text/javascript" src="${staticPath}/js/point_rules/point_rules_info.js?k=2"></script>
</body>
</html>