package com.wari.wari_java.app.core.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class DomainEntity {
    protected UUID id;
    protected LocalDateTime createAt;
    protected LocalDateTime updateAt;
    protected LocalDateTime deleteAt;
    
}


