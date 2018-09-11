package com.geempower.helpers.user_engine;

public enum StorefrontUserRoles implements UserRole {
    EXTERNALUSER1,
    CAADMIN,
    EMPOWERADMIN,
    INTERNALUSER,
    REGIONALVIEW,
    SMADMIN,
    RMADMIN,
    TESTROLEUSER;

    @Override
    public String toString() {
        return super.toString();
    }
}