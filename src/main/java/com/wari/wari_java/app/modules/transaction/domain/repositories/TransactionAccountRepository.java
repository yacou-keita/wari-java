package com.wari.wari_java.app.modules.transaction.domain.repositories;

import java.util.List;

import com.wari.wari_java.app.modules.transaction.domain.entities.TransactionAccount;


public interface  TransactionAccountRepository  {

    List<TransactionAccount> findAll();

    void save(TransactionAccount request);
}
