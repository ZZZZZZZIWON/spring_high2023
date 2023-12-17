<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
<style>
.button {
	background-color: buttonface;
	border-radius: 5px;
	width: 200px;
	height: 50px;
	line-height: 50px;
	margin: 5px 5px;
	display: inline-block;
	text-align: center;
	font-size:2em;
}
#display { 
	background-color: gray;
	border-radius: 5px;
	width: 841px;
	height: 50px;
	line-height: 50px;
	margin: 5px 5px;
	display: inline-block;
	text-align: right;
	font-size:2em;
	padding-right:10px;
	color:white;
}
a {
	text-decoration: none;
	color:black;
}
</style>
</head>
<body>
	<div>
		<div>
			<div id="display"> ${display == null ? "0" : display}</div>
		</div>
		<div>
			<div class="button"><a href="?button=7">7</a></div>
			<div class="button"><a href="?button=8">8</a></div>
			<div class="button"><a href="?button=9">9</a></div>
			<div class="button"><a href="?button=div">/</a></div>
		</div>
		<div>
			<div class="button"><a href="?button=4">4</a></div>
			<div class="button"><a href="?button=5">5</a></div>
			<div class="button"><a href="?button=6">6</a></div>
			<div class="button"><a href="?button=mul">*</a></div>
		</div>
		<div>
			<div class="button"><a href="?button=1">1</a></div>
			<div class="button"><a href="?button=2">2</a></div>
			<div class="button"><a href="?button=3">3</a></div>
			<div class="button"><a href="?button=min">-</a></div>
		</div>
		<div>
			<div class="button"><a href="?button=0">0</a></div>
			<div class="button"><a href="?button=C">C</a></div>
			<div class="button"><a href="?button=calc">=</a></div>
			<div class="button"><a href="?button=pls">+</a></div>
		</div>
	</div>
</body>
</html>