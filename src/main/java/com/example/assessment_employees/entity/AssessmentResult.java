package com.example.assessment_employees.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "assessment_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @ManyToOne
    @JoinColumn(name = "assessed_user_id", nullable = false)
    private User assessedUser;

    @ManyToOne
    @JoinColumn(name = "assessor_user_id", nullable = false)
    private User assessorUser;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private AssessmentTemplate template;

    @Column(name = "assessment_period")
    private String assessmentPeriod;

    @Column(name = "total_score", precision = 10, scale = 2)
    private BigDecimal totalScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AssessmentStatus status = AssessmentStatus.DRAFT;

    @Column(name = "comment")
    private String comment;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
} 