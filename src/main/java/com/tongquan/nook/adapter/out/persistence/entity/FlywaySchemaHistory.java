package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.FlywaySchemaHistory")
@Table(name = "flyway_schema_history")
public class FlywaySchemaHistory {

    @Id
    @Nonnull
    @Column(name = "\"installed_rank\"", nullable = false)
    private Integer installedRank;

    @Nullable
    @Column(name = "\"version\"", nullable = true)
    private String version;

    @Nonnull
    @Column(name = "\"description\"", nullable = false)
    private String description;

    @Nonnull
    @Column(name = "\"type\"", nullable = false)
    private String type;

    @Nonnull
    @Column(name = "\"script\"", nullable = false)
    private String script;

    @Nullable
    @Column(name = "\"checksum\"", nullable = true)
    private Integer checksum;

    @Nonnull
    @Column(name = "\"installed_by\"", nullable = false)
    private String installedBy;

    @Nonnull
    @Column(name = "\"installed_on\"", nullable = false)
    private Timestamp installedOn;

    @Nonnull
    @Column(name = "\"execution_time\"", nullable = false)
    private Integer executionTime;

    @Column(name = "\"success\"", nullable = false)
    private boolean success;
}
