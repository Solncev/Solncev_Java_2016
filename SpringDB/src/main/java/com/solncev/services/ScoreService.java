package com.solncev.services;

import com.solncev.model.enums.Subject;

/**
 * Created by Марат on 28.02.2017.
 */
public interface ScoreService {
    long getTotalScore(long id);

    double getAverageScore(long id);

    int getScoreBySubject(long id, Subject subject);
}
