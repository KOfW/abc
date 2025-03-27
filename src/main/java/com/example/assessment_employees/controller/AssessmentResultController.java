package com.example.assessment_employees.controller;


import com.example.assessment_employees.dto.request.AssessmentResultRequest;
import com.example.assessment_employees.entity.AssessmentResult;
import com.example.assessment_employees.service.AssessmentResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessment-results")
@RequiredArgsConstructor
public class AssessmentResultController {

    private final AssessmentResultService service;

    // API lấy tất cả kết quả đánh giá
    @GetMapping
    public ResponseEntity<List<AssessmentResult>> getAllResults() {
        return ResponseEntity.ok(service.getAllResults());
    }

    // API lấy kết quả đánh giá theo ID
    @GetMapping("/{id}")
    public ResponseEntity<AssessmentResult> getResultById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getResultById(id));
    }

    // API tạo mới kết quả đánh giá
    @PostMapping
    public ResponseEntity<AssessmentResult> createResult(@RequestBody AssessmentResultRequest dto) {
        return ResponseEntity.ok(service.createAssessmentResult(dto));
    }

    // API cập nhật kết quả đánh giá
    @PutMapping("/{id}")
    public ResponseEntity<AssessmentResult> updateResult(@PathVariable Integer id, @RequestBody AssessmentResultRequest dto) {
        return ResponseEntity.ok(service.updateAssessmentResult(id, dto));
    }

    // API xóa kết quả đánh giá
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Integer id) {
        service.deleteAssessmentResult(id);
        return ResponseEntity.ok("Assessment Result deleted successfully");
    }
}
