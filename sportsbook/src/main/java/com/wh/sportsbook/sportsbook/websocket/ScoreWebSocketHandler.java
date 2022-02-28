package com.wh.sportsbook.sportsbook.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class ScoreWebSocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> webSocketSessions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        webSocketSessions.forEach(s -> {
            try {
                s.sendMessage(message);
                log.debug("handleTextMessage....sending msg :: " +message);
            } catch (IOException e) {
                log.error("handleTextMessage error :::  " +e.getMessage());
            }
        });

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSessions.add(session);
        log.debug("afterConnectionEstablished... " + session);

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.debug("handleMessage....");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.debug("handleTransportError....");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.debug("afterConnectionClosed....");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
