package com.solncev.services;

import com.solncev.model.enums.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateDao implements ScoreService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long getTotalScore(long id) {
        return jdbcTemplate.queryForObject("select sum(score) from scores WHERE student_id=?", Long.class, id);
    }

    @Override
    public double getAverageScore(long id) {
        return jdbcTemplate.queryForObject("select avg(score) from scores WHERE student_id=?", Double.class, id);
    }

    @Override
    public int getScoreBySubject(long id, Subject subject) {
        return jdbcTemplate.queryForObject("select score from scores WHERE student_id=? and subject=?",
                Integer.class, id, subject.toString());
    }
}
