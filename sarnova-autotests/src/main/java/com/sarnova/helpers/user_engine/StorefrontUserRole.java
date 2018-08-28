package com.sarnova.helpers.user_engine;

import org.apache.commons.lang.StringUtils;

import java.util.Random;
import java.util.stream.Stream;

public enum StorefrontUserRole implements UserRole {
    ADMIN("b2badmingroup"),
    BUYER("b2bcustomergroup"),
    MANAGER("b2bmanagergroup"),
    PURCHASE_APPROVER("b2bapprovergroup"),
    CONSUMER("b2bconsumer"),
    TEMP("b2btemp"),
    GUEST_CONSUMER("b2bguest"),
    TEST_USER;

    private final String roleCode;
    private final boolean isTest;

    StorefrontUserRole(String roleCode) {
        this.roleCode = roleCode;
        this.isTest = false;
    }

    StorefrontUserRole() {
        this.roleCode = "";
        this.isTest = true;
    }

    @Override
    public boolean isTest() {
        return this.isTest;
    }

    public static StorefrontUserRole[] getRoles() {
        return Stream.of(values()).filter(role -> !role.isTest).toArray(StorefrontUserRole[]::new);
    }

    public String getRoleName() {
        return String.join(" ", Stream.of(this.name().split("_"))
                .map(String::toLowerCase)
                .map(StringUtils::capitalize)
                .toArray(String[]::new));
    }

    public static UserRole getRoleByRoleName(String roleName) {
        return Stream.of(getRoles()).filter(role -> role.getRoleName().equals(roleName)).findFirst().orElse(null);
    }

    public static UserRole getRoleByRoleCode(String roleCode) {
        return Stream.of(getRoles()).filter(role -> role.getRoleCode().equalsIgnoreCase(roleCode)).findFirst().orElse(null);
    }

    public String getRoleCode() {
        return roleCode;
    }

    public static StorefrontUserRole getRandom() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(StorefrontUserRole.getRoles().length);
        return StorefrontUserRole.getRoles()[randomIndex];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
