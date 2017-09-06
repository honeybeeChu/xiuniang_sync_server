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
				<table class="table center">
					<tbody>
						<tr>
							 <td><font size="5" style="color:red;">修改成功！</font></td>
			             </tr>
			             <tr>
			                 <td>
			                 	<input type="button" id="returnBtn" class="button  button-primary" value="返回"/>
			                 </td>
			             </tr>
					</tbody>
				</table>
				<script type="text/javascript" src="${staticPath}/js/common.js"></script>
				<script type="text/javascript" src="${staticPath}/js/point_rules/point_rules_info.js?k=1"></script>
		</div>
	</div>
</body>
</html>