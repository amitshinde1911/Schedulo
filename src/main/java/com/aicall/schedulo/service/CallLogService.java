package com.aicall.schedulo.service;

import com.aicall.schedulo.dto.CallLogDTO;
import java.util.List;

public interface CallLogService {

    CallLogDTO saveCallLog(CallLogDTO callLogDTO);

    CallLogDTO getCallLogById(Long id);

    List<CallLogDTO> getCallLogsByStudentId(Long studentId);
}
