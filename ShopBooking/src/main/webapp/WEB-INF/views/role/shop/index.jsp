<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<nav>
			<jsp:include page="../../nav.jsp"></jsp:include>
		</nav>
		<ul>
			<li><a href="shop/list">매장정보 관리</a></li>
			<li><a href="time_table/list">영업시간 관리</a></li>
			<li><a href="booking/list">예약 관리</a></li>
		</ul>
	</div>
</body>
</html>