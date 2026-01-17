package com.wari.wari_java.app.modules.transaction.domain.entities;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.wari.wari_java.app.core.domain.entities.DomainEntity;
import com.wari.wari_java.app.modules.transaction.domain.valueObjects.Balance;

public class TransactionAccount extends DomainEntity  {
    private final Owner owner;
    private final Balance balance;

    private TransactionAccount(
        UUID id,
        Owner owner,
        Balance balance,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updateAt,
        Optional<LocalDateTime> deletedAt
        ){
            super(id,createdAt,updateAt,deletedAt);
            this.owner = owner;
            this.balance = balance;
        }

    public static TransactionAccount create(
        UUID id,
        Owner owner,
        Balance balance,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updateAt,
        Optional<LocalDateTime> deletedAt
    ) {
       return new TransactionAccount(id, owner, balance, createdAt, updateAt, deletedAt);
    }
}
