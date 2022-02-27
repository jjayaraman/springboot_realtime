package com.wh.sportsbook.sportsbook.data;

import com.wh.sportsbook.sportsbook.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
