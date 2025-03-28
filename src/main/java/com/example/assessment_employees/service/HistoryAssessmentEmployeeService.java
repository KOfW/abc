package com.example.assessment_employees.service;

import com.example.assessment_employees.dto.response.HistoryAssessmentEmployeeResponse;
import com.example.assessment_employees.repository.HistoryAssessmentEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryAssessmentEmployeeService {
    @Autowired
    private HistoryAssessmentEmployeeRepository historyAssessmentEmployeeRepository;

    public List<HistoryAssessmentEmployeeResponse> getAllAssessmentResults() {
        return historyAssessmentEmployeeRepository.getAssessmentResultsWithDetails();
    }

    public List<HistoryAssessmentEmployeeResponse> getAssessmentResultsByUserId(Long userId) {
        return historyAssessmentEmployeeRepository.getAssessmentResultsByUserId(userId);
    }
}
