package com.wh.sportsbook.sportsbook.service;

import com.wh.sportsbook.sportsbook.controller.exception.EntityNotFoundException;
import com.wh.sportsbook.sportsbook.data.ScoreRepository;
import com.wh.sportsbook.sportsbook.entity.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score createScore(Score score) {
        Score created = scoreRepository.save(score);
        log.info("New score created successfully. " + score);
        return created;
    }

    @Override
    public Score updateScore(Integer id, Score score) {
        Score updated;
        Optional<Score> scoreOptional = scoreRepository.findById(id);
        if (scoreOptional.isPresent()) {
            updated = scoreRepository.saveAndFlush(scoreOptional.get());
            log.info("Score updated successfully for id : " + id + ". Updated to : " + updated);

            Optional<Score> updatedOptional = scoreRepository.findById(id);
            if (updatedOptional.isPresent()) {
                return updatedOptional.get();
            }
            log.error("No data exists for the given id : " + id);
            throw new EntityNotFoundException("Score not found for the given id : " + id);
        }
        log.error("No data exists for the given id : " + id);
        throw new EntityNotFoundException("Score not found for the given id : " + id);
    }

    @Override
    public List<Score> getScores() {
        List<Score> scores = scoreRepository.findAll();
        log.info("getScores returning data of size : " + scores.size());
        return scores;
    }

    @Override
    public Score getScoreById(Integer id) {
        Score score = null;
        Optional<Score> scoreOptional = scoreRepository.findById(id);
        if (scoreOptional.isPresent()) {
            score = scoreOptional.get();
            log.info("getScoreById returning data : " + score);
        } else {
            log.error("No data found for the given id: " + id);
            throw new EntityNotFoundException("Score not found for the given id : " + id);
        }
        return score;
    }

    @Override
    public boolean deleteScore(Integer id) {
        Optional<Score> scoreOptional = scoreRepository.findById(id);
        if (scoreOptional.isPresent()) {
            scoreRepository.delete(scoreOptional.get());
            log.info("Record deleted for the given id : " + id);
            return true;
        } else {
            log.error("No data exists for the given id : " + id);
            throw new EntityNotFoundException("Score not found for the given id : " + id);
        }
    }
}
