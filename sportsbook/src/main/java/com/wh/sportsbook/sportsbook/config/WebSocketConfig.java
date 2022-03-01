package com.wh.sportsbook.sportsbook.config;

import com.wh.sportsbook.sportsbook.websocket.ScoreWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-message").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // Destination prefix - to carry messages to client
        registry.enableSimpleBroker("/topic");

        // Prefix for the server - to receive message from the client
        registry.setApplicationDestinationPrefixes("/app");
    }
}
