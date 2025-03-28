package com.example.assessment_employees.controller;

import com.example.assessment_employees.dto.response.AssessmentResultResponse;
import com.example.assessment_employees.dto.response.AssessmentResultResponse;
import com.example.assessment_employees.service.AssessmentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentResultController {

    @Autowired
    private AssessmentResultService assessmentResultService;

    @GetMapping("/all")
    public List<AssessmentResultResponse> getAllAssessmentResults() {
        return assessmentResultService.getAllAssessmentResults();
    }

    @GetMapping("/{userId}")
    public List<AssessmentResultResponse> getAssessmentResultsByUserId(@PathVariable Long userId) {
        return assessmentResultService.getAssessmentResultsByUserId(userId);
    }
}

