package com.geempower.helpers.user_engine;

public enum StorefrontUserRoles implements UserRole {
    EXTERNALUSER1,
    CAADMIN,
    EMPOWERADMIN,
    INTERNALUSER,
    INTERNALUSER1,
    REGIONALVIEW,
    SMADMIN,
    RMADMIN,
    MFGREPUSER,
    TESTROLEUSER;

    @Override
    public String toString() {
        return super.toString();
    }
}