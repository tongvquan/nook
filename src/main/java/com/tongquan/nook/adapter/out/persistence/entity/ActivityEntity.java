package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.ActivityEntity")
@Table(name = "activities")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    @Column(name = "\"id\"", nullable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"user_id\"", nullable = false)
    private Long userId;

    @Nullable
    @Column(name = "\"location_id\"", nullable = true)
    private Long locationId;

    @Nonnull
    @Column(name = "\"title\"", nullable = false)
    private String title;

    @Nullable
    @Column(name = "\"description\"", nullable = true)
    private String description;

    @Nullable
    @Column(name = "\"category\"", nullable = true)
    private String category;

    @Nonnull
    @Column(name = "\"type\"", nullable = false)
    private String type;

    @Nullable
    @Column(name = "\"priority\"", nullable = true)
    private Integer priority;

    @Nullable
    @Column(name = "\"status\"", nullable = true)
    private String status;

    @Nullable
    @Column(name = "\"due_date\"", nullable = true)
    private Timestamp dueDate;

    @Nullable
    @Column(name = "\"start_time\"", nullable = true)
    private Time startTime;

    @Nullable
    @Column(name = "\"end_time\"", nullable = true)
    private Time endTime;

    @Nullable
    @Column(name = "\"repeat_rule\"", nullable = true)
    private String repeatRule;

    @Nullable
    @Column(name = "\"location_event\"", nullable = true)
    private String locationEvent;

    @Nullable
    @Column(name = "\"created_at\"", nullable = true)
    private Timestamp createdAt;

    @Nullable
    @Column(name = "\"updated_at\"", nullable = true)
    private Timestamp updatedAt;
}
