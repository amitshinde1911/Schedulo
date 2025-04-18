package com.aicall.schedulo.service;

import com.aicall.schedulo.dto.StudentDTO;
import java.util.List;

public interface StudentService {

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long id);

    List<StudentDTO> getAllStudents();

    void deleteStudent(Long id);
}
