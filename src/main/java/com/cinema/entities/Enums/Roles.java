package com.cinema.entities.Enums;

public enum Roles {

    ROLES_ADMIN("ROLE_ADMIN"),
    ROLES_CASHIER("Cashier"),
    ROLES_BUYER("Buyer");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRoleName() { return role; }
}
