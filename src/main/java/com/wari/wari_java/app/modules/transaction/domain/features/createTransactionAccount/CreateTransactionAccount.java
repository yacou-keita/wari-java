package com.wari.wari_java.app.modules.transaction.domain.features.createTransactionAccount;

import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;

public class CreateTransactionAccount {

   private final TransactionAccountRepository _transactionAccountRepository;

   public CreateTransactionAccount(TransactionAccountRepository transactionAccountRepository){
        this._transactionAccountRepository = transactionAccountRepository;
    }

    public void execute(TransactionAccount request) {

        _transactionAccountRepository.save(request);
    }
    
}
