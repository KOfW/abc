package com.example.assessment_employees.controller;

import com.example.assessment_employees.dto.response.HistoryAssessmentEmployeeResponse;
import com.example.assessment_employees.service.AssessmentResultService;
import com.example.assessment_employees.service.HistoryAssessmentEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/assessmentsHistory")
public class HistoryAssessmentEmployeeController {
    @Autowired
    private HistoryAssessmentEmployeeService historyAssessmentEmployeeService;

    @GetMapping("/all")
    public List<HistoryAssessmentEmployeeResponse> getAllAssessmentResults() {
        return historyAssessmentEmployeeService.getAllAssessmentResults();
    }

    @GetMapping("/{userId}")
    public List<HistoryAssessmentEmployeeResponse> getAssessmentResultsByUserId(@PathVariable Long userId) {
        return historyAssessmentEmployeeService.getAssessmentResultsByUserId(userId);
    }
}
