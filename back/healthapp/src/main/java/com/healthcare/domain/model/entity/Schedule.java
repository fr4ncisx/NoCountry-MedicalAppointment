package com.healthcare.domain.model.entity;

import com.healthcare.domain.dto.request.ScheduleRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private DayOfWeek dayOfWeek;
    @ManyToOne
    @JoinColumn(name = "medic_id", nullable = false)
    private Medic medic;

    public Schedule(ScheduleRequest scheduleRequest, Medic medic) {
        this.startDate = scheduleRequest.getStartDate();
        this.endDate = scheduleRequest.getEndDate();
        this.startTime = scheduleRequest.getStartTime();
        this.endTime = scheduleRequest.getEndTime();
        // this.dayOfWeek = scheduleRequest.getDayOfWeek();
        this.medic = medic;
    }

    public Schedule(ScheduleRequest scheduleRequest) {
        this.startDate = scheduleRequest.getStartDate();
        this.endDate = scheduleRequest.getEndDate();
        this.startTime = scheduleRequest.getStartTime();
        this.endTime = scheduleRequest.getEndTime();
        // this.dayOfWeek = scheduleRequest.getDayOfWeek();
    }
}