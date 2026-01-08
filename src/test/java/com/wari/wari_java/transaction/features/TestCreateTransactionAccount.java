package com.wari.wari_java.transaction.features;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wari.wari_java.app.modules.transaction.data_source.inMemories.repositories.InMemoryTransactionAccountRepository;
import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.features.createTransactionAccount.CreateTransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;

public class TestCreateTransactionAccount {

    CreateTransactionAccount createTransactionAccount;
    TransactionAccountRepository transactionAccountRepository;

    @BeforeEach
    void setUp() {
        this.transactionAccountRepository = new InMemoryTransactionAccountRepository();
        this.createTransactionAccount = new CreateTransactionAccount(this.transactionAccountRepository);
    }

    @Test
    void shouldCreateTransactionAccountWhenOwnerIsAuthenticate() {

        TransactionAccount transactionAccount = new TransactionAccount();

        this.createTransactionAccount.execute(transactionAccount);

        List<TransactionAccount> transactionAccounts = this.transactionAccountRepository.findAll();

        assertTrue(transactionAccounts.contains(transactionAccount));
    }

}
