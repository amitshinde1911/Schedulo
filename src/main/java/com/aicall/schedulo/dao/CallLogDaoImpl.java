package com.aicall.schedulo.dao;

import com.aicall.schedulo.entity.CallLog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DAO implementation for CallLog entity using EntityManager.
 */
@Repository
@Transactional
public class CallLogDaoImpl implements CallLogDao {

    // Inject EntityManager to interact with the database
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save or update a CallLog record.
     */
    @Override
    public CallLog save(CallLog callLog) {
        return entityManager.merge(callLog);
    }

    /**
     * Find a CallLog record by ID.
     */
    @Override
    public Optional<CallLog> findById(Long id) {
        return Optional.ofNullable(entityManager.find(CallLog.class, id));
    }

    /**
     * Retrieve all CallLogs linked to a given student ID.
     */
    @Override
    public List<CallLog> findByStudentId(Long studentId) {
        return entityManager.createQuery(
                        "SELECT c FROM CallLog c WHERE c.student.id = :studentId", CallLog.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }
}
