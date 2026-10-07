package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.LocationEntity")
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    @Column(name = "\"id\"", nullable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"user_id\"", nullable = false)
    private Long userId;

    @Nonnull
    @Column(name = "\"name\"", nullable = false)
    private String name;

    @Nullable
    @Column(name = "\"latitude\"", nullable = true)
    private java.math.BigDecimal latitude;

    @Nullable
    @Column(name = "\"longitude\"", nullable = true)
    private java.math.BigDecimal longitude;

    @Nullable
    @Column(name = "\"radius_meters\"", nullable = true)
    private Integer radiusMeters;

    @Nullable
    @Column(name = "\"category\"", nullable = true)
    private String category;
}
