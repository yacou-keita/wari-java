package com.wari.wari_java.app.modules.transaction.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.wari.wari_java.app.core.domain.entities.DomainEntity;

final public class User extends DomainEntity {
    
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    private User(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updatedAt,
        Optional<LocalDateTime> deletedAt
        ){
        super(id,createdAt,updatedAt,deletedAt);
        this.email = email;
        this.firstName =  firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public static User create(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updatedAt,
        Optional<LocalDateTime> deletedAt
    ) {
        return new User(
            id,
            firstName, 
            lastName, 
            email, 
            password, 
            createdAt, 
            updatedAt, 
            deletedAt);
    }

    public Owner createOwner() {
        return Owner.create(id, firstName, lastName, email);
    }
}
