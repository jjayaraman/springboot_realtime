package com.wh.sportsbook.sportsbook.controller;

import com.wh.sportsbook.sportsbook.dto.ScoreDto;
import com.wh.sportsbook.sportsbook.entity.Score;
import com.wh.sportsbook.sportsbook.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/score")
    public ResponseEntity<ScoreDto> createScore(@RequestBody ScoreDto scoreDto) {
        log.debug("Creating /score record with input : " + scoreDto);
        Score created = scoreService.createScore(convertToEntity(scoreDto));
        return ResponseEntity.ok(convertToDto(created));
    }

    @GetMapping(value = "/scores", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ScoreDto>> getScores() {
        log.debug("Calling /scores api... ");
        List<ScoreDto> scoreDtos = scoreService.getScores().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(scoreDtos);
    }


    @GetMapping(value = "/score/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ScoreDto> getScoreById(@PathVariable Integer id) {
        log.debug("Calling getScoreById() GET /score/{id} api... ");
        Score score = scoreService.getScoreById(id);
        return ResponseEntity.ok(convertToDto(score));
    }

    @PutMapping(value = "/scoreDto/{id}")
    public ResponseEntity<ScoreDto> updateScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
        log.debug("Updating /scoreDto record with input : " + scoreDto + " and the id : " + id);
        Score updated = scoreService.updateScore(id, convertToEntity(scoreDto));
        return ResponseEntity.ok(convertToDto(updated));
    }


    private Score convertToEntity(ScoreDto scoreDto) {
        return modelMapper.map(scoreDto, Score.class);
    }

    private ScoreDto convertToDto(Score score) {
        return modelMapper.map(score, ScoreDto.class);
    }
}
