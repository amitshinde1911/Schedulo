package com.aicall.schedulo.dao;

import com.aicall.schedulo.entity.Student;
import java.util.List;
import java.util.Optional;

/**
 * DAO interface for Student entity to abstract database operations.
 */
public interface StudentDao {

    // Save or update a student
    Student save(Student student);

    // Find a student by ID
    Optional<Student> findById(Long id);

    // Fetch all students
    List<Student> findAll();

    // Delete a student by ID
    void deleteById(Long id);
}
