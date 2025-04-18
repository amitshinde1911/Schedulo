package com.aicall.schedulo.dao;

import com.aicall.schedulo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DAO implementation for Student entity using EntityManager.
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    // Inject EntityManager to perform DB operations
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save or update a student.
     * If the student exists, it updates; otherwise, it inserts a new record.
     */
    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    /**
     * Find a student by primary key ID.
     */
    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    /**
     * Retrieve all students.
     */
    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    /**
     * Delete a student record by ID if it exists.
     */
    @Override
    public void deleteById(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
