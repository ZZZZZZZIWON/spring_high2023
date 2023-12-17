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
		<form method="post">
			<div>
				<input type="number" name="left"> 
					<select name="op">
						<option value="pls">+</option>
						<option value="min">-</option>
						<option value="mul">*</option>
						<option value="div">/</option>
					</select> 
					<input type="number" name="right">
				<button>계산</button>
			</div>
		</form>
	</div>
</body>
</html>