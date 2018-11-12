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