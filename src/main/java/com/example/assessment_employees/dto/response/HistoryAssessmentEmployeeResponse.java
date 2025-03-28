package com.example.assessment_employees.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HistoryAssessmentEmployeeResponse {
    private Integer id;
    private String name;
    private Integer departmentId;
    private String jobTitle;
    private BigDecimal score;
    private Integer assessmentId;
    private Integer performanceRating;
    private String feedback;
    private String assessmentDate;
    private String comments;

    public HistoryAssessmentEmployeeResponse() {}

    // Constructor khớp với danh sách tham số
    public HistoryAssessmentEmployeeResponse(Integer id, String name, Integer departmentId, String jobTitle,
                                             BigDecimal score, Integer assessmentId, Integer performanceRating,
                                             String feedback, String assessmentDate, String comments){

        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.score = score;
        this.assessmentId = assessmentId;
        this.performanceRating = performanceRating;
        this.feedback = feedback;
        this.assessmentDate = assessmentDate;
        this.comments = comments;
    }


}


