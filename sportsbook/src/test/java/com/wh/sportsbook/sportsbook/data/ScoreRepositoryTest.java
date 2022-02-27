package com.wh.sportsbook.sportsbook.data;

import com.wh.sportsbook.sportsbook.model.Score;
import org.junit.jupiter.api.*;
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
    public void findAllScores() {
        List<Score> scores = repository.findAll();
        Assertions.assertNotNull(scores);
        Assertions.assertEquals(2, scores.size());
    }

    @Test
    public void deleteScore() {
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


    @Disabled
    @Test
    public void addScore() {
        Score score = new Score(3, "Team C", 0);
        Score created = repository.saveAndFlush(score);
//        entityManager.clear();
        Assertions.assertNotNull(created);
        Assertions.assertEquals(3, created.getId());

        List<Score> scores2 = repository.findAll();
        Assertions.assertNotNull(scores2);
        Assertions.assertEquals(1, scores2.size());
    }
}