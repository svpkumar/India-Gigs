package com.indiagig.notification.model;

/**
 * Types of system-generated notifications.
 * NEW_APPLICATION — sent to Owner when a Worker applies.
 * GIG_CLOSED — sent to all applicants when Owner closes a gig.
 */
public enum NotificationType {
    NEW_APPLICATION,
    GIG_CLOSED
}
