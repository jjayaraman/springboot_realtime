package com.wh.sportsbook.sportsbook.service;

import com.wh.sportsbook.sportsbook.entity.Score;

import java.util.List;

public interface ScoreService {

    Score createScore(Score score);

    Score updateScore(Integer id, Score score);

    List<Score> getScores();

    Score getScoreById(Integer id);

    boolean deleteScore(Integer id);

}
