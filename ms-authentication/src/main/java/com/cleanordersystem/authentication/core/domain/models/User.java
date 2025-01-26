package com.cleanordersystem.authentication.core.domain.models;

import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;

import java.util.Objects;

public class User {

    private String username;
    private String email;
    private String password;
    private RolesEnum userRole;

    public User(String username, String email, String password, RolesEnum userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public RolesEnum getUserRole() {
        return userRole;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRole(RolesEnum userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
