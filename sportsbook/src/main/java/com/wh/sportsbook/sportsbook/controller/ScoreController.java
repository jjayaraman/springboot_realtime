package com.wh.sportsbook.sportsbook.controller;

import com.wh.sportsbook.sportsbook.model.Score;
import com.wh.sportsbook.sportsbook.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping(value = "/score")
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        log.debug("Creating /score record with input : " + score);
        Score created = scoreService.createScore(score);
        return ResponseEntity.ok(created);
    }

    @GetMapping(value = "/scores", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Score>> getScores() {
        log.debug("Calling /scores api... ");
        List<Score> scores = scoreService.getScores();
        return ResponseEntity.ok(scores);
    }


    @GetMapping(value = "/score/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Score> getScoreById(@PathVariable Integer id) {
        log.debug("Calling getScoreById() GET /score/{id} api... ");
        Score score = scoreService.getScoreById(id);
        return ResponseEntity.ok(score);
    }

    @PutMapping(value = "/score/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable Integer id, @RequestBody Score score) {
        log.debug("Updating /score record with input : " + score + " and the id : " + id);
        Score updated = scoreService.updateScore(id, score);
        return ResponseEntity.ok(updated);
    }

}
