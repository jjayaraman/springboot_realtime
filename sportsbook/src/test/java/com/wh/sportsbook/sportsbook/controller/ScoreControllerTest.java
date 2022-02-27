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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ScoreController.class)
class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreService scoreService;

    Gson gson = new Gson();

    @Test
    void createScore() throws Exception {
        ScoreDto scoreDto = new ScoreDto(1, "Team X", 0);
        String body = gson.toJson(scoreDto);

        MvcResult result = mockMvc
                .perform(post("/api/score").content(body).content(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());


    }

    @Test
    void getScores() {


    }

    @Test
    void getScoreById() {
    }

    @Test
    void updateScore() {
    }
}