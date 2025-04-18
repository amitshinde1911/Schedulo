package com.aicall.schedulo.controller;

import com.aicall.schedulo.service.VoiceCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller to trigger a Twilio voice call.
 */
@RestController
@RequestMapping("/api/voice")
public class VoiceCallController {

    @Autowired
    private VoiceCallService voiceCallService;

    @PostMapping("/call")
    public ResponseEntity<String> makeCall(
            @RequestParam String toPhone,
            @RequestParam String message
    ) {
        String result = voiceCallService.initiateCall(toPhone, message);
        return ResponseEntity.ok(result);
    }
}
