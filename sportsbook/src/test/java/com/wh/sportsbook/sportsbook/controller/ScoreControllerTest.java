package com.wh.sportsbook.sportsbook.controller;

import com.wh.sportsbook.sportsbook.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ScoreController.class)
class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreService scoreService;

    @Test
    void createScore() {
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