<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
	const url = "ws://" + window.location.hostname + ":" + window.location.port + "/kopo/chatserver";
	
	const socket = new WebSocket(url);
	
	let connect = false;
	
	socket.onopen = () => {
		connect = true;
		alert("Server Connected")
	};

	socket.onclose = () => {
		connect = false;
		alert("Server Closed")
	};
	
	socket.onmessage = msg => {		
		console.dir(msg)
		
		const chat = document.getElementById("chat");		
		chat.innerHTML += "<li>" + msg.data + "</li>";
	}
	
	function send() {
		if(connect) {
			const msg = document.getElementById("msg");
		
			socket.send(msg.value);
		
			msg.value = "";
		}
		
	}
</script>
</head>
<body>
	<div>
		<div>
			<ul id="chat" style="list-style-type: circle"></ul>
		</div>
		<hr>
		<div>
			<label>메세지:</label> <input id="msg" type="text" size="80">
			<button onclick="send()">보내기</button>
		</div>
	</div>
</body>
</html>