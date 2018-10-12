package com.geempower.helpers.managers;

import com.geempower.helpers.models.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserManager {
    private ArrayList<UserEntity> userList = new ArrayList<>();

    public void createUserInstance(String firstName, String lastName, String userId, String userRole, String companyName, String email,
                                   String phoneNumber, String language) {
        userList.add(new UserEntity(firstName, lastName, userId, userRole, companyName, email, phoneNumber, language));
    }

    public UserEntity getUserByEmail(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }
}