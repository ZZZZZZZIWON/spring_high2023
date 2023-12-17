<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<label>좌항: </label>${left}
		</div>
		<div>
			<label>연산자: </label>${op}
		</div>
		<div>
			<label>우항: </label>${right}
		</div>
		<div>
			<label>계산 결과:</label>${result}
		</div>
		<div>
			<a href="calc">처음으로</a>
		</div>
	</div>
</body>
</html>