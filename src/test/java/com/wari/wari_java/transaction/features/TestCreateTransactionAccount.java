package com.wari.wari_java.transaction.features;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import com.wari.wari_java.app.core.domain.features.Command;
import com.wari.wari_java.app.modules.transaction.data_source.inMemories.gateway.InMeomryAuthenticatorGatway;
import com.wari.wari_java.app.modules.transaction.data_source.inMemories.repositories.InMemoryTransactionAccountRepository;
import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.entities.User;
import com.wari.wari_java.app.modules.transaction.domain.features.createTransactionAccount.CreateTransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.gateway.AuthenticatorGatway;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;
import com.wari.wari_java.app.modules.transaction.domain.valueObjects.Balance;
import com.wari.wari_java.app.modules.transaction.domain.exception.PhoneNumberAlreadyExists;
import com.wari.wari_java.app.modules.transaction.domain.exception.UserNotAuthenticate;

public class TestCreateTransactionAccount {

    Command<TransactionAccount> createTransactionAccount;
    TransactionAccountRepository transactionAccountRepository;
    AuthenticatorGatway authenticatorGatway = new InMeomryAuthenticatorGatway();
    User userYacouKeita;
    TransactionAccount transactionAccount;

    @BeforeEach
    void setUp() {
        this.transactionAccountRepository = new InMemoryTransactionAccountRepository();
        this.createTransactionAccount = new CreateTransactionAccount(
            this.transactionAccountRepository,
            this.authenticatorGatway
            );

        Balance balance = new Balance(BigDecimal.valueOf(0),"cfa");
        transactionAccount = TransactionAccount.create(
            UUID.randomUUID(),
            balance,
            "0700000034",
            LocalDateTime.now(),
            Optional.empty(),
            Optional.empty()
        );

        userYacouKeita = User.create(
        UUID.randomUUID(),
        "keita",
        "yacou",
        "yacou@gmail.com", 
        "1234", 
        LocalDateTime.now(), 
        Optional.empty(), 
        Optional.empty());
    }


    @Test
    void shouldCreateTransactionAccountWhenUserIsAuthenticate() {

        authenticatorGatway.authenticate(this.userYacouKeita);

        this.createTransactionAccount.execute(transactionAccount);

        List<TransactionAccount> transactionAccounts = this.transactionAccountRepository.findAll();

        assertTrue(transactionAccounts.contains(transactionAccount));
    }

    @Test
    void shouldFailToCreateTransactionAccountWhenPhoneNumberAlreadyExistsAndWhenUserIsAuthenticate(){

        authenticatorGatway.authenticate(this.userYacouKeita);

        this.createTransactionAccount.execute(transactionAccount);
        
        assertThrows(
            PhoneNumberAlreadyExists.class,
            () -> this.createTransactionAccount.execute(transactionAccount)
            );
    }

    @Test
    void shouldFailToCreateTransactionAccountWhenUserNotAuthenticate(){
        
        assertThrows(
            UserNotAuthenticate.class,
            () -> this.createTransactionAccount.execute(transactionAccount)
            );
    }

}
