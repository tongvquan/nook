package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.ActivityLogEntity")
@Table(name = "activity_logs")
public class ActivityLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    @Column(name = "\"id\"", nullable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"user_id\"", nullable = false)
    private Long userId;

    @Nonnull
    @Column(name = "\"activity_id\"", nullable = false)
    private Long activityId;

    @Nullable
    @Column(name = "\"location_id\"", nullable = true)
    private Long locationId;

    @Nonnull
    @Column(name = "\"action_taken\"", nullable = false)
    private String actionTaken;

    @Nonnull
    @Column(name = "\"event_timestamp\"", nullable = false)
    private Timestamp eventTimestamp;

    @Nullable
    @Column(name = "\"note\"", nullable = true)
    private String note;

    @Nullable
    @Column(name = "\"created_at\"", nullable = true)
    private Timestamp createdAt;
}
