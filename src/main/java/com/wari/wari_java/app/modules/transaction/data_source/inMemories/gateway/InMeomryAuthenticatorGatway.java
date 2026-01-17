package com.wari.wari_java.app.modules.transaction.data_source.inMemories.gateway;

import java.util.Optional;

import com.wari.wari_java.app.modules.transaction.domain.entities.User;
import com.wari.wari_java.app.modules.transaction.domain.gateway.AuthenticatorGatway;

public class InMeomryAuthenticatorGatway implements AuthenticatorGatway {

    private  User userAuthenticate;

    @Override
    public void authenticate(User user) {
      this.userAuthenticate = user;
    }

    @Override
    public Optional<User> currentUser() {
        return Optional.ofNullable(userAuthenticate);
    }

    
}
