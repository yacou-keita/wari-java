package com.wari.wari_java.app.modules.transaction.domain.entities;

import java.util.UUID;

final public class Owner {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;

    private Owner(UUID id,String firstName, String lastName,String email){
        this.email = email;
        this.firstName =  firstName;
        this.lastName = lastName;
        this.id =id;
    }

    public static Owner create(UUID id, String firstName, String lastName,String email) {
        return new Owner(id, firstName, lastName, email);
    }
}
