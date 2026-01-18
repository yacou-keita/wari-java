package com.wari.wari_java.app.core.domain.execption;

public abstract class DomainException extends RuntimeException {
    
     protected DomainException(String message) {
        super(message);
    }
}
