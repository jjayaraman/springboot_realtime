//package com.wh.sportsbook.sportsbook.controller;
//
//import com.wh.sportsbook.sportsbook.dto.ScoreDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class WebSocketController {
//
//
//    @Autowired
//    private SimpMessagingTemplate template;
//
//    @PostMapping("/send")
//    public ResponseEntity<ScoreDto> sendMessage(@RequestBody ScoreDto scoreDto) {
//        log.info("/api/send called with body : " + scoreDto);
//        template.convertAndSend("/topic/message", scoreDto);
//        log.info("msg posted to ws clients using /topic/message destination");
//        return ResponseEntity.ok(scoreDto);
//    }
//
//    @SendTo("/topic/message")
//    public ScoreDto broadcastMessage(@Payload ScoreDto scoreDto) {
//        log.info(" @SendTo(/topic/message) called... with payload " + scoreDto);
//        return scoreDto;
//    }
//}
