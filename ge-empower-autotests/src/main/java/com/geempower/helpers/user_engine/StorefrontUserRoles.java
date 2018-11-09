package com.geempower.helpers.user_engine;

public enum StorefrontUserRoles implements UserRole {
    EXTERNALUSER1,
    EXTERNALUSER2,
    CAADMIN,
    EMPOWERADMIN,
    INTERNALUSER,
    INTERNALUSER1,
    INTERNALUSER2,
    REGIONALVIEW,
    SMADMIN,
    RMADMIN,
    MFGREPUSER,
    MFGREPUSER1,
    TESTROLEUSER,
    EMPADMIN,
    FIRSTEMPADMIN,
    SECONDEMPADMIN,
    HELPDESC;

    @Override
    public String toString() {
        return super.toString();
    }
}