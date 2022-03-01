package com.wh.sportsbook.sportsbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScoreDto {

    private Integer id;

    private String team;

    private Integer score;

    public ScoreDto(String team, Integer score) {
        this.team = team;
        this.score = score;
    }
}
