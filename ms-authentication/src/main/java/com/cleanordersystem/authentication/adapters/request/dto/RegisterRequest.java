package com.cleanordersystem.authentication.adapters.request.dto;


import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;

public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private RolesEnum userRole;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String email, String password, RolesEnum userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolesEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RolesEnum userRole) {
        this.userRole = userRole;
    }
}
