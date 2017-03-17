package com.solncev.repository;

import com.solncev.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Марат on 28.02.2017.
 */
@Repository
public interface ScoresRepository extends CrudRepository<Score, Long> {
}
