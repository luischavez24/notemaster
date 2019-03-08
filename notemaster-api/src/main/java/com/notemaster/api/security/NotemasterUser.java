package com.notemaster.api.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class NotemasterUser extends User {

    private static final long serialVersionUID = -3531439484732724601L;

    private String firstName;
    private String middleName;
    private String lastName;

    public NotemasterUser(String firstName, String middleName , String lastName,
                          String username, String password, List<GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}