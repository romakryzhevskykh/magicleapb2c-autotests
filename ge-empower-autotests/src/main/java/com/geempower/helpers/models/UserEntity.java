package com.geempower.helpers.models;

import lombok.Getter;

public class UserEntity {
    @Getter
    String firstName;
    @Getter
    String lastName;
    @Getter
    String userId;
    @Getter
    String userRole;
    @Getter
    String companyName;
    @Getter
    String email;
    @Getter
    String alternateEmail;
    @Getter
    String phoneNumber;
    @Getter
    String language;
    @Getter
    String relationship;
    @Getter
    String region;
    @Getter
    boolean isInternalUser;

    public UserEntity(String firstName, String lastName, String userId, String userRole, String companyName,
                      String email, String phoneNumber, String language, String relationship, String region,
                      boolean isInternal, String alternateEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.userRole = userRole;
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.language = language;
        this.relationship = relationship;
        this.region = region;
        this.isInternalUser = isInternal;
        this.alternateEmail = alternateEmail;
    }

    public UserEntity(String firstName, String lastName, String userId, String userRole, String companyName,
                      String email, String phoneNumber, String language, String relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.userRole = userRole;
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.language = language;
        this.relationship = relationship;
    }
}