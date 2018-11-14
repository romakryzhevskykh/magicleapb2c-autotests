package com.geempower.helpers.managers;

import com.geempower.helpers.models.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserManager {
    private ArrayList<UserEntity> userList = new ArrayList<>();

    public void createUserInstance(String firstName, String lastName, String userId, String userRole, String companyName, String email,
                                   String phoneNumber, String language, String relationship, String region, boolean isInternalUser, String alternateEmail) {
        userList.add(new UserEntity(firstName, lastName, userId, userRole, companyName, email, phoneNumber, language, relationship, region, isInternalUser, alternateEmail));
    }

    public void createUserInstance(String firstName, String lastName, String userId, String userRole, String companyName, String email,
                                   String phoneNumber, String language, String relationship) {
        userList.add(new UserEntity(firstName, lastName, userId, userRole, companyName, email, phoneNumber, language, relationship));
    }

    public UserEntity getUserByEmail(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }

    public UserEntity getUserBySso(String sso) {
        return userList.stream().filter(user -> user.getUserId().equals(sso)).findAny().orElse(null);
    }
}