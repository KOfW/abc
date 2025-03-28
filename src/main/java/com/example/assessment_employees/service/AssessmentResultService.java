package com.example.assessment_employees.service;

import com.example.assessment_employees.dto.response.AssessmentResultResponse;
import com.example.assessment_employees.repository.AssessmentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssessmentResultService {

    @Autowired
    private AssessmentResultRepository assessmentResultRepository;

    public List<AssessmentResultResponse> getAllAssessmentResults() {
        return assessmentResultRepository.getAssessmentResultsWithDetails();
    }

    public List<AssessmentResultResponse> getAssessmentResultsByUserId(Long userId) {
        return assessmentResultRepository.getAssessmentResultsByUserId(userId);
    }
}

