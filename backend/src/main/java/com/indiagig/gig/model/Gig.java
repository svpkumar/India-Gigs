package com.indiagig.gig.model;

import com.indiagig.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A gig opportunity posted by an Owner.
 * Workers browse and apply to gigs.
 *
 * Status lifecycle:
 * ACTIVE → CLOSED (owner manually closes)
 *
 * Relationships:
 * - Many Gigs → One Owner (User)
 * - One Gig → Many Applications
 */
@Entity
@Table(name = "gigs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private GigCategory category;

    @Column(name = "business_name", nullable = false, length = 200)
    private String businessName;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Builder.Default
    private GigStatus status = GigStatus.ACTIVE;

    @Column(name = "hourly_pay", nullable = false, precision = 8, scale = 2)
    private BigDecimal hourlyPay;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
