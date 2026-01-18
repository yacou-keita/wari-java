package com.wari.wari_java.app.modules.transaction.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.wari.wari_java.app.core.domain.entities.DomainEntity;
import com.wari.wari_java.app.modules.transaction.domain.valueObjects.Balance;

final public class TransactionAccount extends DomainEntity  {
    private  Owner owner;
    private final Balance balance;
    private final String phoneNumber;

    private TransactionAccount(
        UUID id,
        Balance balance,
        String phoneNumber,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updateAt,
        Optional<LocalDateTime> deletedAt
        ){
            super(id,createdAt,updateAt,deletedAt);
            this.balance = balance;
            this.phoneNumber = phoneNumber;
        }

    public static TransactionAccount create(
        UUID id,
        Balance balance,
        String phoneNumber,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updateAt,
        Optional<LocalDateTime> deletedAt
    ) {
       return new TransactionAccount(id, balance, phoneNumber ,createdAt, updateAt, deletedAt);
    }

    public void addOwner(User userAuthenticated) {
        this.owner  = userAuthenticated.createOwner();
    }

    public UUID getId() {
        return id;
    }

    public String getPhone() {
        return phoneNumber;
    }
}
