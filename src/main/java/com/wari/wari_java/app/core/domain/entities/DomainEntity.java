package com.wari.wari_java.app.core.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public abstract class DomainEntity {
    protected UUID id;
    protected LocalDateTime createdAt;
    protected Optional<LocalDateTime> updatedAt;
    protected Optional<LocalDateTime> deletedAt;

    protected DomainEntity(
            UUID id,
            LocalDateTime createdAt,
            Optional<LocalDateTime> updatedAt,
            Optional<LocalDateTime> deletedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

}
