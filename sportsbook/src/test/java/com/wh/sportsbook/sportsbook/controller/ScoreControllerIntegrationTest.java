package com.wh.sportsbook.sportsbook.controller;

import com.wh.sportsbook.sportsbook.dto.ScoreDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

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


    @Test
    void getScores() throws Exception {

        ResponseEntity<List<ScoreDto>> response = restTemplate.exchange(url + "/api/scores", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<ScoreDto>>() {
                });

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(3, response.getBody().size());

        Assertions.assertEquals("Team A", response.getBody().get(0).getTeam());
        Assertions.assertEquals(0, response.getBody().get(0).getScore());

        Assertions.assertEquals("Team B", response.getBody().get(1).getTeam());
        Assertions.assertEquals(0, response.getBody().get(1).getScore());
    }

    @Test
    void getScoreById() throws Exception {
        Integer id = 1;
        ResponseEntity<ScoreDto> response = restTemplate.getForEntity(url + "/api/score/" + id, ScoreDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getId());
        Assertions.assertEquals("Team A", response.getBody().getTeam());
        Assertions.assertEquals(0, response.getBody().getScore());

    }

    @Test
    void updateScore() {
        Integer id = 1;
        ScoreDto scoreDto = new ScoreDto("Team X", 10);

        HttpEntity<ScoreDto> body = new HttpEntity<>(scoreDto);
        ResponseEntity<ScoreDto> updated = restTemplate.exchange(url + "/api/score/" + id, HttpMethod.PUT, body, ScoreDto.class);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(200, updated.getStatusCodeValue());
        Assertions.assertNotNull(updated.getBody());
    }
}