package com.aicall.schedulo.controller;

import com.aicall.schedulo.dto.CallLogDTO;
import com.aicall.schedulo.service.CallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller to manage call logs and interaction results.
 */
@RestController
@RequestMapping("/api/call-logs")
public class CallLogController {

    @Autowired
    private CallLogService callLogService;

    /**
     * Save a new call log entry.
     */
    @PostMapping
    public ResponseEntity<CallLogDTO> saveCallLog(@RequestBody CallLogDTO callLogDTO) {
        CallLogDTO saved = callLogService.saveCallLog(callLogDTO);
        if (saved == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(saved);
    }

    /**
     * Get a call log by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CallLogDTO> getCallLog(@PathVariable Long id) {
        CallLogDTO log = callLogService.getCallLogById(id);
        if (log == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(log);
    }

    /**
     * Get all call logs for a given student.
     */
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CallLogDTO>> getLogsByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(callLogService.getCallLogsByStudentId(studentId));
    }
}
