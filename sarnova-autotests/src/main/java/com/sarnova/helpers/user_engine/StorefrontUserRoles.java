package com.sarnova.helpers.user_engine;

public enum StorefrontUserRoles implements UserRole {
    ADMIN("b2badmingroup"),
    BUYER("b2bcustomergroup"),
    MANAGER("b2bmanagergroup"),
    PURCHASE_APPROVER("b2bapprovergroup"),
    CONSUMER("b2bconsumer"),
    TEMP("b2btemp"),
    GUEST_CONSUMER("b2bguest");

    private final String roleCode;

    StorefrontUserRoles(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
