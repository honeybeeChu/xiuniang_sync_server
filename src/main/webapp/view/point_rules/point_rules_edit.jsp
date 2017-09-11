<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绣娘管理平台－登录</title>
<link href="${staticPath}/css/dianyuan/dianyuan_info.css?k=1" rel="stylesheet" media="screen">
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
	                            <td><input type="text" maxlength="20" style="width:220px;" name="name" id="name" value="${pointsRule.name}"><span style="color:red;font-size:10px;">※等级名称，如预备会员，金卡会员</span></td>
	                        </tr>
	                        <tr id="tr_1">
	                            <td class="tbl_label">消费累计金额:</td>
	                            <td><input type="text" maxlength="9" style="width:220px;" name="consumption" id="consumption" value="${pointsRule.consumption}"></td>
	                        </tr>
	                        <tr id="tr_2">
	                            <td class="tbl_label">单次消费金额:</td>
	                            <td><input type="text" maxlength="9" style="width:220px;" name="onceConsumption" id="onceConsumption" value="${pointsRule.onceConsumption}"></td>
	                        </tr>
	                        <tr id="tr_3">
	                            <td class="tbl_label">消费笔数:</td>
	                            <td><input type="text" maxlength="5" style="width:220px;" name="tradeNum" id="tradeNum" value="${pointsRule.tradeNum}"></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">升级到此level的条件:</td>
	                            <td>
		                            <select name="conditions" id="conditions" style="width:230px;">
		                            	<c:choose>
											<c:when test="${pointsRule.conditions == '0'}">
												<option value="0" selected>消费累计金额满足即可</option>
											</c:when>
											<c:otherwise>
												<option value="0">消费累计金额满足即可</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${pointsRule.conditions == '1'}">
												<option value="1" selected>消费笔数满足即可</option>
											</c:when>
											<c:otherwise>
												<option value="1">消费笔数满足即可</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${pointsRule.conditions == '2'}">
												<option value="2" selected>消费累计金额和消费笔数有一个满足即可</option>
											</c:when>
											<c:otherwise>
												<option value="2">消费累计金额和消费笔数有一个满足即可</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${pointsRule.conditions == '3'}">
												<option value="3" selected>消费累计金额和消费笔数同事满足即可</option>
											</c:when>
											<c:otherwise>
												<option value="3">消费累计金额和消费笔数同事满足即可</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${pointsRule.conditions == '4'}">
												<option value="4" selected>单笔消费金额满足即可</option>
											</c:when>
											<c:otherwise>
												<option value="4">单笔消费金额满足即可</option>
											</c:otherwise>
										</c:choose>
									</select>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">积分兑换比例:</td>
	                            <td><input type="text" maxlength="5" style="width:220px;" name="rate" id="rate" value="${pointsRule.rate}"><span style="color:red;">※此等级下的会员，消费金额和积分的增加比例，如1.2  表示1元给1.2个积分</span></td>
	                        </tr>
	                        <tr>
	                            <td class="tbl_label">折扣率:</td>
	                            <td><input type="text" maxlength="5" style="width:220px;" name="discount" id="discount" value="${pointsRule.discount}"><span style="color:red;">※此等级下的会员，线下消费时享受的折扣率，0~1</span></td>
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
	<script type="text/javascript" src="${staticPath}/js/point_rules/point_rules_info.js?k=11211"></script>
</body>
</html>