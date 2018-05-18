package com.geempower.helpers.user_engine;

public enum StorefrontUserRoles implements UserRole {
    SHOPPER,
    EMPOWERADMIN,
    INTERNALUSER,
    REGIONALVIEW,
    SMADMIN,
    RMADMIN;

    @Override
    public String toString() {
        return super.toString();
    }
}
