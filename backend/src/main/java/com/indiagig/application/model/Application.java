package com.indiagig.application.model;

import com.indiagig.gig.model.Gig;
import com.indiagig.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A Worker expressing interest in a Gig.
 * Owner sees applications and contacts workers.
 *
 * Unique constraint: one application per worker per gig (prevents spam).
 *
 * Relationships:
 * - Many Applications → One Gig
 * - Many Applications → One Worker (User)
 */
@Entity
@Table(name = "applications", uniqueConstraints = @UniqueConstraint(columnNames = { "gig_id", "worker_id" }))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gig_id", nullable = false)
    private Gig gig;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id", nullable = false)
    private User worker;

    @Column(name = "cover_note", columnDefinition = "TEXT")
    private String coverNote;

    @CreationTimestamp
    @Column(name = "applied_at", updatable = false)
    private LocalDateTime appliedAt;
}
