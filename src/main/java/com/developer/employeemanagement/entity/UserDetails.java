package com.developer.employeemanagement.entity;

public class UserDetails {
    private Long id;
    private String username;
    private String role;

    public UserDetails(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    // Other methods, such as setters and toString(), could be implemented as well
}
