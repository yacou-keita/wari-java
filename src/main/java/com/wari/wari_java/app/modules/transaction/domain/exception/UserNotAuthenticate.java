package com.wari.wari_java.app.modules.transaction.domain.exception;

import com.wari.wari_java.app.core.domain.execption.DomainException;

public class UserNotAuthenticate extends DomainException {
    
    private UserNotAuthenticate() {
        super("User not authenticated");
    }

    public static UserNotAuthenticate create(){
        return new UserNotAuthenticate();
    }
}
