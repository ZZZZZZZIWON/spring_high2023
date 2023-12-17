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
		<h3>시간대 정보 변경</h3>
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<form method="post">
				<div class="row mb-3">
					<label class="col-3">구분 번호:</label>
					<div class="col">
						${item.timeId}
					</div>					
				</div>
				<div class="row mb-3">
					<label class="col-3">매장 아이디:</label>
					<div class="col">
						<input type="text" name="memberId" class="form-control col-9" value="${item.memberId}">
					</div>					
				</div>
				<div class="row mb-3">
					<label class="col-3">영업 시간대:</label>
					<div class="col">
						<input type="number" name="hour" min="0" max="23" class="form-control" value="${item.hour}">
					</div>
				</div>
				<div class="row mb-3">
					<div class="col"></div>
					<div class="row col">
						<button class="btn btn-primary">변경</button>
					</div>
					<div class="col"></div>
					<div class="row col">
						<a href="list" class="row"><button type="button" class="btn btn-secondary">취소</button></a>
					</div>
					<div class="col"></div>
				</div>			
			</form>
			<div>
		</div>
		</div>
	</div>
</body>
</html>