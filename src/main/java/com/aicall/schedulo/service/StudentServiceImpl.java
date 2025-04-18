package com.aicall.schedulo.service;

import com.aicall.schedulo.dao.StudentDao;
import com.aicall.schedulo.dto.StudentDTO;
import com.aicall.schedulo.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing student data.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convert DTO to entity, save it, then convert back to DTO.
     */
    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setInterviewDate(LocalDate.parse(studentDTO.getInterviewDate()));
        Student saved = studentDao.save(student);
        return modelMapper.map(saved, StudentDTO.class);
    }

    /**
     * Retrieve student by ID and convert to DTO.
     */
    @Override
    public StudentDTO getStudentById(Long id) {
        return studentDao.findById(id)
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .orElse(null);
    }

    /**
     * Fetch all students from DB and convert to list of DTOs.
     */
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDao.findAll().stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Delete a student by ID.
     */
    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteById(id);
    }
}
