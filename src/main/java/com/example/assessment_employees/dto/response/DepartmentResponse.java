package com.example.assessment_employees.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DepartmentResponse {
    private Integer departmentId;
    private String departmentName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 