package com.wari.wari_java.app.modules.transaction.domain.features.createTransactionAccount;

import java.util.Optional;

import com.wari.wari_java.app.core.domain.features.Command;
import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;
import com.wari.wari_java.app.modules.transaction.domain.entities.User;
import com.wari.wari_java.app.modules.transaction.domain.gateway.AuthenticatorGatway;
import com.wari.wari_java.app.modules.transaction.domain.repositories.TransactionAccountRepository;
import com.wari.wari_java.app.modules.transaction.domain.exception.PhoneNumberAlreadyExists;
import com.wari.wari_java.app.modules.transaction.domain.exception.UserNotAuthenticate;

public class CreateTransactionAccount implements Command<TransactionAccount> {

    private final TransactionAccountRepository transactionAccountRepository;
    private final AuthenticatorGatway authenticatorGatway;

    public CreateTransactionAccount(
            TransactionAccountRepository transactionAccountRepository,
            AuthenticatorGatway authenticatorGatway) {
        this.transactionAccountRepository = transactionAccountRepository;
        this.authenticatorGatway = authenticatorGatway;
    }

    public void execute(TransactionAccount transactionAccount) {
       Optional<User> currentUser =  this.authenticatorGatway.currentUser();
       if(currentUser.isEmpty()) throw UserNotAuthenticate.create();
       Optional<TransactionAccount> alreadyTransactionAccount = transactionAccountRepository
       .findByPhoneNumber(transactionAccount
       .getPhone());
       if(alreadyTransactionAccount.isPresent()) throw PhoneNumberAlreadyExists.create();
       currentUser.ifPresent(userAuthenticated -> {
        transactionAccount.addOwner(userAuthenticated);
        transactionAccountRepository.save(transactionAccount);
       });
    }

}
