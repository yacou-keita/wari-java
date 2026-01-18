package com.wari.wari_java.app.modules.transaction.domain.exception;

import com.wari.wari_java.app.core.domain.execption.DomainException;

final public class PhoneNumberAlreadyExists extends DomainException {

    protected PhoneNumberAlreadyExists() {
        super("Phone number already exists");
    }

    public static PhoneNumberAlreadyExists create() {
        return new PhoneNumberAlreadyExists();
    }
    
}
