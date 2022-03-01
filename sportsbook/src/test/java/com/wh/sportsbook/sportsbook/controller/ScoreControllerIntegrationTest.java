package com.wh.sportsbook.sportsbook.controller;

import com.google.gson.Gson;
import com.wh.sportsbook.sportsbook.dto.ScoreDto;
import com.wh.sportsbook.sportsbook.service.ScoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScoreControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/", port);
    }

    @Test
    void createScore() throws Exception {
        ScoreDto scoreDto = new ScoreDto("Team X", 0);

        HttpEntity<ScoreDto> body = new HttpEntity<>(scoreDto);
        ResponseEntity<ScoreDto> created = restTemplate.postForEntity(url + "/api/score", body, ScoreDto.class);

        Assertions.assertNotNull(created);
        Assertions.assertEquals(201, created.getStatusCodeValue());
        Assertions.assertNotNull(created.getBody());

        Assertions.assertEquals("Team X", created.getBody().getTeam());
        Assertions.assertEquals(3, created.getBody().getId());
        Assertions.assertEquals(0, created.getBody().getScore());

    }

    //
//    @Test
//    void getScores() throws Exception {
//
//        MvcResult result = mockMvc
//                .perform(get("/api/scores")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn();
//
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//
//    }
//
//    @Test
//    void getScoreById() throws Exception {
//        Integer id = 1;
//        MvcResult result = mockMvc
//                .perform(get("/api/score/" + id)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn();
//
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//    }
//
    @Test
    void updateScore() {
        Integer id = 1;
        ScoreDto scoreDto = new ScoreDto("Team X", 10);

        HttpEntity<ScoreDto> body = new HttpEntity<>(scoreDto);
        ResponseEntity<ScoreDto> updated = restTemplate.exchange(url + "/api/score/" +id, HttpMethod.PUT, body, ScoreDto.class);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(200, updated.getStatusCodeValue());
        Assertions.assertNotNull(updated.getBody());
    }
}