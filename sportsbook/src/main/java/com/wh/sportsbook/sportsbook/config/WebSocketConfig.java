package com.wh.sportsbook.sportsbook.config;

import com.wh.sportsbook.sportsbook.websocket.ScoreWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@Slf4j
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        log.info(">>>>>>>>  registry ::  " +registry);
        registry.addHandler(scoreWebSocketHandler(), "/hello")
                .setAllowedOrigins("*");
    }

    @Bean
    public ScoreWebSocketHandler scoreWebSocketHandler() {
        return new ScoreWebSocketHandler();
    }

}
