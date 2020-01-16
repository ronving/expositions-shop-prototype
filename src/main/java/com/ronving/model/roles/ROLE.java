package com.ronving.model.roles;

public enum ROLE {
    USER("USER"), ADMIN("ADMIN"), UNKNOWN("UNKNOWN");
    private String role;
    ROLE(String role) {
        this.role = role;
    }

    public String getString() {
        return role;
    }
}
