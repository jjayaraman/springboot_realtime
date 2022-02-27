package com.wh.sportsbook.sportsbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SCORE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "TEAM")
    private String team;

    @Column(name = "SCORE")
    private Integer score;

    public Score(String team, Integer score) {
        this.team = team;
        this.score = score;
    }
}
