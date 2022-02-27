package com.wh.sportsbook.sportsbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDto {

    private Integer id;

    private String team;

    private Integer score;
}
