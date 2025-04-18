package com.aicall.schedulo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity class representing a student who is being contacted
 * by the voice-based interview calling agent.
 */
@Entity
public class Student {

    // Primary key with auto-generated value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Student's full name
    private String name;

    // Mobile number to contact the student
    private String phoneNumber;

    // Email for sending calendar invite and confirmations
    private String email;

    // College or university name
    private String college;

    // Scheduled interview date (date only, no time)
    private LocalDate interviewDate;

    // Role for which the student is being interviewed
    private String jobRole;

    // --- Constructors (Optional) ---

    public Student() {
    }

    public Student(String name, String phoneNumber, String email, String college,
                   LocalDate interviewDate, String jobRole) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.college = college;
        this.interviewDate = interviewDate;
        this.jobRole = jobRole;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    // --- Optional: toString() for logging/debugging ---

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", college='" + college + '\'' +
                ", interviewDate=" + interviewDate +
                ", jobRole='" + jobRole + '\'' +
                '}';
    }
}
