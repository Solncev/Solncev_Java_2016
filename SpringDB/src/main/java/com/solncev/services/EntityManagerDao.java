package com.solncev.services;

import com.solncev.model.enums.Subject;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Repository
@Transactional
public class EntityManagerDao implements ScoreService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManagerDao(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public long getTotalScore(long id) {
        return entityManager.createQuery("select sum(s.score) from Score s WHERE s.student_id= :student_id", Long.class)
                .setParameter("student_id", id).getSingleResult();
    }

    @Override
    public double getAverageScore(long id) {
        return entityManager.createQuery("select avg(s.score) from Score s WHERE s.student_id= :student_id", Double.class)
                .setParameter("student_id", id).getSingleResult();
    }

    @Override
    public int getScoreBySubject(long id, Subject subject) {
        return entityManager.createQuery("select s.score from Score s WHERE s.student_id= :student_id " +
                "and s.subject= :subject", Integer.class)
                .setParameter("student_id", id).setParameter("subject", subject).getSingleResult();
    }
}
