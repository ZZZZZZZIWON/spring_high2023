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
		<h3>사용자 정보 변경</h3>
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<form method="post">
				<div class="row mb-3">
					<label class="col-3">아이디:</label>
					<div class="col">
						${item.id}
					</div>					
				</div>
				<div class="row mb-3">
					<label class="col-3">비밀번호:</label>
					<div class="col">
						<input type="text" name="passwd" class="form-control" value="${item.passwd}">
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-3">상호:</label>
					<div class="col">
						<input type="text" name="title" class="form-control" value="${item.title}">
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-3">역할:</label>
					<div class="col">
						<select name="role">
							<option value="1" ${item.role == 1 ? 'selected' : ''}>고객</option>
							<option value="2" ${item.role == 2 ? 'selected' : ''}>가맹점</option>
							<option value="99" ${item.role == 99 ? 'selected' : ''}>관리자</option>
						</select>
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