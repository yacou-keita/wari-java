package com.wari.wari_java.app.modules.transaction.domain.gateway;

import java.util.Optional;

import com.wari.wari_java.app.modules.transaction.domain.entities.User;

public interface AuthenticatorGatway {

    void authenticate(User user);

    Optional<User> currentUser();
    
}
