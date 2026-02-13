package com.indiagig.gig.model;

/**
 * Simple two-state lifecycle for a Gig.
 * ACTIVE — live, accepting applications.
 * CLOSED — owner manually closed, no more applications.
 */
public enum GigStatus {
    ACTIVE,
    CLOSED
}
