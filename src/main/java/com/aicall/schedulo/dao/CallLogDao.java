package com.aicall.schedulo.dao;

import com.aicall.schedulo.entity.CallLog;
import java.util.List;
import java.util.Optional;

/**
 * DAO interface for CallLog entity to abstract database operations.
 */
public interface CallLogDao {

    // Save or update a call log
    CallLog save(CallLog callLog);

    // Find call log by ID
    Optional<CallLog> findById(Long id);

    // Get all call logs related to a specific student
    List<CallLog> findByStudentId(Long studentId);
}
