package com.aicall.schedulo.service;

import com.aicall.schedulo.dao.CallLogDao;
import com.aicall.schedulo.dao.StudentDao;
import com.aicall.schedulo.dto.CallLogDTO;
import com.aicall.schedulo.entity.CallLog;
import com.aicall.schedulo.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service implementation for handling call log operations.
 */
@Service
public class CallLogServiceImpl implements CallLogService {

    @Autowired
    private CallLogDao callLogDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Save a call log linked to a student.
     */
    @Override
    public CallLogDTO saveCallLog(CallLogDTO callLogDTO) {
        Optional<Student> studentOpt = studentDao.findById(callLogDTO.getStudentId());
        if (studentOpt.isEmpty()) return null;

        CallLog callLog = modelMapper.map(callLogDTO, CallLog.class);
        callLog.setStudent(studentOpt.get());
        CallLog saved = callLogDao.save(callLog);
        return modelMapper.map(saved, CallLogDTO.class);
    }

    /**
     * Fetch a call log by ID.
     */
    @Override
    public CallLogDTO getCallLogById(Long id) {
        return callLogDao.findById(id)
                .map(log -> modelMapper.map(log, CallLogDTO.class))
                .orElse(null);
    }

    /**
     * Get all call logs related to a student.
     */
    @Override
    public List<CallLogDTO> getCallLogsByStudentId(Long studentId) {
        return callLogDao.findByStudentId(studentId).stream()
                .map(log -> modelMapper.map(log, CallLogDTO.class))
                .collect(Collectors.toList());
    }
}
