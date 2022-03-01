package com.wh.sportsbook.sportsbook.controller;

import com.google.gson.Gson;
import com.wh.sportsbook.sportsbook.dto.ScoreDto;
import com.wh.sportsbook.sportsbook.service.ScoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ScoreController.class)
class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreService scoreService;

    @MockBean
    private SimpMessagingTemplate template;

    Gson gson = new Gson();

    @Test
    void createScore() throws Exception {
        ScoreDto scoreDto = new ScoreDto("Team X", 0);
        String body = gson.toJson(scoreDto);

        MvcResult result = mockMvc
                .perform(post("/api/score")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());


    }

    @Test
    void getScores() throws Exception {

        MvcResult result = mockMvc
                .perform(get("/api/scores")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

    }

    @Test
    void getScoreById() throws Exception {
        Integer id = 1;
        MvcResult result = mockMvc
                .perform(get("/api/score/" + id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
    }

    @Test
    void updateScore() throws Exception {
        Integer id = 1;
        ScoreDto scoreDto = new ScoreDto("Team X", 0);
        String body = gson.toJson(scoreDto);
        MvcResult result = mockMvc
                .perform(put("/api/score/" + id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), result.getResponse().getStatus());
    }
}