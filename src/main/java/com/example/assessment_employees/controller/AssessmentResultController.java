package com.example.assessment_employees.controller;

import com.example.assessment_employees.dto.ApiResponse;
import com.example.assessment_employees.dto.request.AssessmentResultRequest;
import com.example.assessment_employees.dto.response.AssessmentResultResponse;
import com.example.assessment_employees.dto.response.AssessmentResultResponse;
import com.example.assessment_employees.entity.AssessmentResult;
import com.example.assessment_employees.service.AssessmentResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentResultController {

    @Autowired
    private AssessmentResultService assessmentResultService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<AssessmentResult>>> getAllAssessmentResults() {
        return ResponseEntity.ok(new ApiResponse<>(true,"Get assess result successfully", assessmentResultService.getAllResults()));
    }


    // API cập nhật kết quả đánh giá
    @PutMapping("/{id}")
    public ResponseEntity<AssessmentResult> updateResult(@PathVariable Integer id, @RequestBody AssessmentResultRequest dto) {
        return ResponseEntity.ok(assessmentResultService.updateAssessmentResult(id, dto));
    }

    // API xóa kết quả đánh giá
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Integer id) {
        assessmentResultService.deleteAssessmentResult(id);
        return ResponseEntity.ok("Assessment Result deleted successfully");
    }
}
