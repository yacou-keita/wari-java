package com.wari.wari_java.app.modules.transaction.domain.features.createTransactionAccount;

import java.util.Optional;

import com.wari.wari_java.app.core.domain.features.Command;
import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.entities.User;
import com.wari.wari_java.app.modules.transaction.domain.gateway.AuthenticatorGatway;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;

public class CreateTransactionAccount implements Command<TransactionAccount> {

   private final TransactionAccountRepository transactionAccountRepository;
   private final AuthenticatorGatway authenticatorGatway;

   public CreateTransactionAccount(
    TransactionAccountRepository transactionAccountRepository,
    AuthenticatorGatway authenticatorGatway
    ){
        this.transactionAccountRepository = transactionAccountRepository;
        this.authenticatorGatway = authenticatorGatway;
    }

    public void execute(TransactionAccount transactionAccount) {
       Optional<User> currentUser =  this.authenticatorGatway.currentUser();
       currentUser.ifPresent(userAuthenticated -> {
        transactionAccount.addOwner(userAuthenticated);
        transactionAccountRepository.save(transactionAccount);
       });
    }
    
}

