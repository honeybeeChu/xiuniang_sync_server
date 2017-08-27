<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/default.jsp"%>
<html>
<head>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Pricing Table</title>
<link href="${staticPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	  <h3 style="text-align:center">会员信息</h3>
	  <table class="table">
		<tbody>
		  <tr>
			<td style="font-weight:bold;">卡号：</td>
			<td>${membershipList.cardId}</td>
		</tr>
		<tr>
			<td style="font-weight:bold;">姓名：</td>
			<td>${membershipList.name}</td>
		</tr>
		<tr>
			<td style="font-weight:bold;">手机：</td>
			<td>${membershipList.phone}</td>
		</tr>
		<tr style="text-align:center">
			<td colspan=2><img src="${ctxPath}/bonus_points/toLookImage.do?cardId=${membershipList.cardId}"></td>
		</tr>
		</tbody>
	  </table>
	</div>
</body>
</html>