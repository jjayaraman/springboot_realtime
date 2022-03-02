package com.wh.sportsbook.sportsbook.data;

import com.wh.sportsbook.sportsbook.entity.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

/**
 * Integration testing Repository layer with in-memory H2 database
 *
 * @author Jayakumar Jayaraman
 */
@DataJpaTest
class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllScores() {
        List<Score> scores = repository.findAll();
        Assertions.assertNotNull(scores);
        Assertions.assertEquals(2, scores.size());
    }

    @Test
    void deleteScore() {
        List<Score> scores = repository.findAll();
        Assertions.assertNotNull(scores);
        Assertions.assertEquals(2, scores.size());

        Optional<Score> scoreOptional = repository.findById(1);
        Assertions.assertTrue(scoreOptional.isPresent());
        Score score = scoreOptional.get();

        Assertions.assertNotNull(score);
        repository.delete(score);

        List<Score> scores2 = repository.findAll();
        Assertions.assertNotNull(scores2);
        Assertions.assertEquals(1, scores2.size());
    }


}