package com.ronving.model.roles;

/**
 * Account roles
 */
public enum ROLE {
    USER("USER"), ADMIN("ADMIN"), UNKNOWN("UNKNOWN");

    private String role;

    /**
     * ROLE constructor
     */
    ROLE(String role) {
        this.role = role;
    }

    /**
     * Getter for role
     *
     * @return string role value
     */
    public String getString() {
        return role;
    }
}
