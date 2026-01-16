package com.wari.wari_java.app.modules.transaction.data_source.inMemories.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;

public class InMemoryTransactionAccountRepository implements TransactionAccountRepository {

   private Map<UUID, TransactionAccount> _transactionAccounts = new HashMap<>();

    @Override
    public List<TransactionAccount> findAll() {
        return new ArrayList<>(_transactionAccounts.values());
    }

    @Override
    public void save(TransactionAccount request) {
        _transactionAccounts.put(null, request);
    }
    
}
