package com.wh.sportsbook.sportsbook.service;

import com.wh.sportsbook.sportsbook.model.Score;

import java.util.List;

public interface ScoreService {

    Score createScore(Score score);

    Score updateScore(Integer id, Score score);

    List<Score> getScores();

    Score getScoreById(Integer id);

    void deleteScore(Integer id);

}
