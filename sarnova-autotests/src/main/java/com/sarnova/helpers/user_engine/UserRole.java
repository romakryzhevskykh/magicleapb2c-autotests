package com.sarnova.helpers.user_engine;

public interface UserRole {
    default boolean isTest(){
        return false;
    }
    default String getRoleName() {
        return "";
    }

    default String getRoleCode() {
        return "";
    }
}
