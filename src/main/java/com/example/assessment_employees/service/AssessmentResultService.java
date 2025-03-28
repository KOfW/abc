package com.example.assessment_employees.service;

import com.example.assessment_employees.dto.request.AssessmentResultRequest;
import com.example.assessment_employees.entity.AssessmentResult;
import com.example.assessment_employees.entity.AssessmentTemplate;
import com.example.assessment_employees.entity.User;
import com.example.assessment_employees.repository.HistoryAssessmentEmployeeRepository;
import com.example.assessment_employees.repository.AssessmentTemplateRepository;
import com.example.assessment_employees.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentResultService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HistoryAssessmentEmployeeRepository resultRepository;
    @Autowired
    private AssessmentTemplateRepository templateRepository;

    public List<AssessmentResult> getAllResults() {
        return resultRepository.findAll();
    }

    // Lấy một kết quả theo ID
    public AssessmentResult getResultById(Integer id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assessment Result not found"));
    }

    // Cập nhật kết quả đánh giá
    public AssessmentResult updateAssessmentResult(Integer id, AssessmentResultRequest dto) {
        Optional<AssessmentResult> optionalResult = resultRepository.findById(id);
        if (optionalResult.isPresent()) {
            AssessmentResult result = optionalResult.get();

            User assessedUser = userRepository.findById(dto.getAssessedUserId())
                    .orElseThrow(() -> new RuntimeException("Assessed user not found"));
            User assessorUser = userRepository.findById(dto.getAssessorUserId())
                    .orElseThrow(() -> new RuntimeException("Assessor user not found"));
            AssessmentTemplate template = templateRepository.findById(dto.getTemplateId())
                    .orElseThrow(() -> new RuntimeException("Template not found"));

            result.setAssessedUser(assessorUser);
            result.setAssessorUser(assessorUser);
            result.setTemplate(template);
            result.setAssessmentPeriod(dto.getAssessmentPeriod());
            result.setTotalScore(dto.getTotalScore());
            result.setStatus(dto.getStatus());

            return resultRepository.save(result);
        } else {
            throw new RuntimeException("Assessment Result not found");
        }
    }

    // Xóa kết quả đánh giá
    public void deleteAssessmentResult(Integer id) {
        if (!resultRepository.existsById(id)) {
            throw new RuntimeException("Assessment Result not found");
        }
        resultRepository.deleteById(id);
    }
}
