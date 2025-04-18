package com.aicall.schedulo.entity;

import jakarta.persistence.*;

/**
 * Entity class representing the log of a call made to a student.
 * It stores the call status, audio recording, and AI-parsed response.
 */
@Entity
public class CallLog {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many call logs can belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Status of the call: Pending or Completed
    private String status;

    // URL of the voice recording from Twilio
    private String recordingUrl;

    // Transcript of the student's voice response
    @Lob
    private String transcript;

    // AI-extracted name (optional verification)
    private String aiParsedName;

    // AI-extracted availability info
    private String aiParsedAvailability;

    // Final confirmation: Yes / No
    private String confirmationStatus;

    // --- Constructors (Optional) ---

    public CallLog() {
    }

    public CallLog(Student student, String status, String recordingUrl,
                   String transcript, String aiParsedName, String aiParsedAvailability,
                   String confirmationStatus) {
        this.student = student;
        this.status = status;
        this.recordingUrl = recordingUrl;
        this.transcript = transcript;
        this.aiParsedName = aiParsedName;
        this.aiParsedAvailability = aiParsedAvailability;
        this.confirmationStatus = confirmationStatus;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    // --- Optional: toString() for debugging ---

    @Override
    public String toString() {
        return "CallLog{" +
                "id=" + id +
                ", student=" + student +
                ", status='" + status + '\'' +
                ", recordingUrl='" + recordingUrl + '\'' +
                ", transcript='" + transcript + '\'' +
                ", aiParsedName='" + aiParsedName + '\'' +
                ", aiParsedAvailability='" + aiParsedAvailability + '\'' +
                ", confirmationStatus='" + confirmationStatus + '\'' +
                '}';
    }
}
