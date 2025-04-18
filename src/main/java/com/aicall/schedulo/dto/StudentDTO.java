package com.aicall.schedulo.dto;

/**
 * Data Transfer Object for creating or returning student details via REST APIs.
 */
public class StudentDTO {

    private String name;
    private String phoneNumber;
    private String email;
    private String college;
    private String interviewDate; // Format: "YYYY-MM-DD"
    private String jobRole;

    public StudentDTO() {}

    public StudentDTO(String name, String phoneNumber, String email, String college,
                      String interviewDate, String jobRole) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.college = college;
        this.interviewDate = interviewDate;
        this.jobRole = jobRole;
    }

    // --- Getters and Setters ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}
