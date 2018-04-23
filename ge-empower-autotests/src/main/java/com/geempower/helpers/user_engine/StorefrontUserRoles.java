package com.geempower.helpers.user_engine;

public enum StorefrontUserRoles implements UserRole {
    SHOPPER,
    EMPOWERADMIN,
    INTERNALUSER,
    CUSTOMERADMIN;

    @Override
    public String toString() {
        return super.toString();
    }
}
