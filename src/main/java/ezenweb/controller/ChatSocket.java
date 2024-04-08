package ezenweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component
public class ChatSocket extends TextWebSocketHandler {

    //0. 접속 성공한 session들을 모아두기 (접속 명단)
    private List<WebSocketSession> 접속명단 = new Vector<>(); // ArrayList vs Vector
    //1. 접속한 세션정보를 리스트에 담기
    @Override   // 접속한 사람들의 세션
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        접속명단.add(session);
        System.out.println("접속명단 = " + 접속명단);
    }

    //2. 클라이언트로부터 메세지를 받았을 때.
    @Override // 여기 매개변수의 session은 보낸사람!, + 보낸 메세지 message
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("session = " + session + ", message = " + message);
        System.out.println("message = " + message.getPayload());
        // 1. 접속명단의 클라이언트 소켓들에게 메세지 보내기
        for(WebSocketSession 각클라이언트 : 접속명단){
            각클라이언트.sendMessage(message);
        }
    }

    // 3. 클라이언트 소켓과 접속 종료되었을 때(session: 접속이 종료된 세션)

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        접속명단.remove(session);
    }
}
