package kr.ac.kopo;

import java.util.Vector;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatServer extends TextWebSocketHandler {
	
	Vector<WebSocketSession> list = new Vector<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		
		list.add(session);

		System.out.println("연결: " + session.getLocalAddress());
	
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("종료: " + session.getLocalAddress());
		super.afterConnectionClosed(session, status);
		
		list.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		
		String user = (String) session.getAttributes().get("user");
		
		System.out.println("메세지: (" + user + ") " + message.getPayload());
		
		for (WebSocketSession client : list) {
			client.sendMessage(new TextMessage(message.getPayload()));
		}
	}
}
