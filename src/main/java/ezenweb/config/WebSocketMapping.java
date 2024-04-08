package ezenweb.config;

import ezenweb.controller.ChatSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.reactive.GraphQlWebFluxAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;



@Configuration // 얘도 스프링 컨테이너에 빈을 등록하는 설정 객체.
@EnableWebSocket // 웹소켓 매핑
public class WebSocketMapping implements WebSocketConfigurer {
    // 스프링 버전에 따라 다를 수 있음.

    @Autowired
    private ChatSocket socket;
    @Override // 1. 웹소켓 매핑 등록 (핸들러 등록)
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // - ws로 요청된 url을 어디로 핸들러 할 건지 설정.
        registry.addHandler(socket, "/chat");
    }//



}
