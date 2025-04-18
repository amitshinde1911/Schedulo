package com.aicall.schedulo.dto;

/**
 * Data Transfer Object for viewing call logs and AI-processed results.
 */
public class CallLogDTO {

    private Long studentId;
    private String status;
    private String recordingUrl;
    private String transcript;
    private String aiParsedName;
    private String aiParsedAvailability;
    private String confirmationStatus;

    public CallLogDTO() {}

    public CallLogDTO(Long studentId, String status, String recordingUrl,
                      String transcript, String aiParsedName, String aiParsedAvailability,
                      String confirmationStatus) {
        this.studentId = studentId;
        this.status = status;
        this.recordingUrl = recordingUrl;
        this.transcript = transcript;
        this.aiParsedName = aiParsedName;
        this.aiParsedAvailability = aiParsedAvailability;
        this.confirmationStatus = confirmationStatus;
    }

    // --- Getters and Setters ---

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecordingUrl() {
        return recordingUrl;
    }

    public void setRecordingUrl(String recordingUrl) {
        this.recordingUrl = recordingUrl;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public String getAiParsedName() {
        return aiParsedName;
    }

    public void setAiParsedName(String aiParsedName) {
        this.aiParsedName = aiParsedName;
    }

    public String getAiParsedAvailability() {
        return aiParsedAvailability;
    }

    public void setAiParsedAvailability(String aiParsedAvailability) {
        this.aiParsedAvailability = aiParsedAvailability;
    }

    public String getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(String confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }
}
