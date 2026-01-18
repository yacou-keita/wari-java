package com.wari.wari_java.app.modules.transaction.data_source.inMemories.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;

public class InMemoryTransactionAccountRepository implements TransactionAccountRepository {

   private Map<UUID, TransactionAccount> transactionAccounts = new HashMap<>();

    @Override
    public List<TransactionAccount> findAll() {
        return new ArrayList<TransactionAccount>(transactionAccounts.values());
    }

    @Override
    public void save(TransactionAccount request) {
        transactionAccounts.put(request.getId(), request);
    }

    @Override
    public Optional<TransactionAccount> findByPhoneNumber(String phone) {
        Optional<TransactionAccount> transactionAccountFound = findAll()
        .stream()
        .filter((transactionAccount) -> transactionAccount.getPhone().equals(phone))
        .findFirst();
        return transactionAccountFound;
    }
    
}
