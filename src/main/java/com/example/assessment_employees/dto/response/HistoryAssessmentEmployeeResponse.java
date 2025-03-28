package com.example.assessment_employees.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HistoryAssessmentEmployeeResponse {
    private Integer id;
    private String fullName;
    private Integer resultId;
    private String assessmentperiod;
    private BigDecimal totalScore;
    private Integer detailId;
    private Integer criteriaScore;
    private String comment;
    private String criteriaName;
    private String categoryName;

    public HistoryAssessmentEmployeeResponse() {}

    // Constructor khớp với danh sách tham số


    public HistoryAssessmentEmployeeResponse(Integer id, String fullName, Integer resultId, String assessmentperiod, BigDecimal totalScore, Integer detailId, Integer criteriaScore, String comment, String criteriaName, String categoryName) {
        this.id = id;
        this.fullName = fullName;
        this.resultId = resultId;
        this.assessmentperiod = assessmentperiod;
        this.totalScore = totalScore;
        this.detailId = detailId;
        this.criteriaScore = criteriaScore;
        this.comment = comment;
        this.criteriaName = criteriaName;
        this.categoryName = categoryName;
    }
}


