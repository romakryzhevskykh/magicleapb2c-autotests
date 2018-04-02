package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.ThreadVarsHashMap;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.user_engine.StorefrontUserRoles;
import com.sarnova.helpers.user_engine.UserSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.HashMap;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs {
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;
    @Autowired protected UserSessions userSessions;

    @SuppressWarnings("unchecked")
    protected HashMap<UnitOfMeasure, Integer> getSelectedUOMS() {
        HashMap<UnitOfMeasure, Integer> selectedUOMs;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            selectedUOMs = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, selectedUOMs);
        } else {
            selectedUOMs = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        return selectedUOMs;
    }

    @SuppressWarnings("unchecked")
    protected ArrayList<StorefrontUserRoles> getSelectedUserRoles() {
        ArrayList<StorefrontUserRoles> selectedUserRoles;
        if(threadVarsHashMap.get(TestKeyword.EDIT_USER_ROLES) == null) {
            selectedUserRoles = new ArrayList<>();
            threadVarsHashMap.put(TestKeyword.EDIT_USER_ROLES, selectedUserRoles);
        } else {
            selectedUserRoles = (ArrayList<StorefrontUserRoles>) threadVarsHashMap.get(TestKeyword.EDIT_USER_ROLES);
        }
        return selectedUserRoles;
    }
}
