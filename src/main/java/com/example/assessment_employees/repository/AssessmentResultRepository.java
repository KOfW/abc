package com.example.assessment_employees.repository;

import com.example.assessment_employees.dto.response.AssessmentResultResponse;
import com.example.assessment_employees.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Integer> {

    @Query("SELECT new com.example.assessment_employees.dto.response.AssessmentResultResponse( " +
            "u.userId, u.fullName, ar.resultId, ar.assessmentPeriod, ar.totalScore, " +
            "ard.detailId, ard.score, ard.comments, cb.criteriaName, cb.category) " +
            "FROM User u " +
            "JOIN AssessmentResult ar ON u.userId = ar.assessedUser.userId " +
            "JOIN AssessmentResultDetail ard ON ar.resultId = ard.result.resultId " +
            "JOIN CriteriaBank cb ON ard.criteria.criteriaId = cb.criteriaId " +
            "ORDER BY u.userId, ar.resultId, ard.detailId")
    List<AssessmentResultResponse> getAssessmentResultsWithDetails();


    @Query("SELECT new com.example.assessment_employees.dto.response.AssessmentResultResponse( " +
            "u.userId, u.fullName, ar.resultId, ar.assessmentPeriod, ar.totalScore, " +
            "ard.detailId, ard.score, ard.comments, cb.criteriaName, cb.category) " +
            "FROM User u " +
            "JOIN AssessmentResult ar ON u.userId = ar.assessedUser.userId " +
            "JOIN AssessmentResultDetail ard ON ar.resultId = ard.result.resultId " +
            "JOIN CriteriaBank cb ON ard.criteria.criteriaId = cb.criteriaId " +
            "WHERE u.userId = :userId " +
            "ORDER BY ar.resultId, ard.detailId")
    List<AssessmentResultResponse> getAssessmentResultsByUserId(@Param("userId") Long userId);
}

