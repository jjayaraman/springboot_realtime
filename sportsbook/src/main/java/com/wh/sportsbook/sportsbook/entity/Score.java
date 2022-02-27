package com.wh.sportsbook.sportsbook.entity;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
