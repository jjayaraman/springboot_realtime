package com.wh.sportsbook.sportsbook.service;

import com.wh.sportsbook.sportsbook.data.ScoreRepository;
import com.wh.sportsbook.sportsbook.entity.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ScoreServiceImplTest {

    @Autowired
    private ScoreServiceImpl scoreService;

    @MockBean
    private ScoreRepository scoreRepository;

    @TestConfiguration
    static class ScoreServiceImplTestContextConfiguration {
        @Bean
        public ScoreService scoreService() {
            return new ScoreServiceImpl();
        }
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void updateScore() {
        Integer id = 10;
        Score score = new Score(1, "Team Z", 2);
        Mockito.when(scoreRepository.findById(id)).thenReturn(Optional.of(score));
        Assertions.assertNotNull(scoreService.getScoreById(id));

        Score modified = new Score("Team Z", 5);
        Score updated = scoreService.updateScore(id, modified);
        // No exceptions should be thrown
        Assertions.assertNotNull(updated);
    }


    @Test
    void getScoreById() {
        Integer id = 10;
        Score score = new Score(1, "Team Z", 2);
        Mockito.when(scoreRepository.findById(id)).thenReturn(Optional.of(score));
        Assertions.assertNotNull(scoreService.getScoreById(id));
        Assertions.assertEquals(1, scoreService.getScoreById(id).getId());
        Assertions.assertEquals("Team Z", scoreService.getScoreById(id).getTeam());
        Assertions.assertEquals(2, scoreService.getScoreById(id).getScore());
    }

    @Test
    void deleteScore() {
        Integer id = 10;
        Score score = new Score(1, "Team Z", 2);
        Mockito.when(scoreRepository.findById(id)).thenReturn(Optional.of(score));
        Assertions.assertTrue(scoreService.deleteScore(id));
    }
}