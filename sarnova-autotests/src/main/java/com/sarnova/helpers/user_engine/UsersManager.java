package com.sarnova.helpers.user_engine;

import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.backoffice.models.SarnovaBackoffice;
import com.sarnova.hybris.hac.models.SarnovaHAC;
import com.sarnova.hybris.import_cockpit.models.SarnovaImportCockpit;
import com.sarnova.storefront.models.SarnovaStorefront;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class UsersManager {
    POSTRequest CREATE_REQUEST = new POSTRequest("Create new test user", "boundtree/en/USD/my-company/organization-management/manage-users/create");
    ArrayList<User> users = new ArrayList<>();

    public void createInstance(String username, String password, Cockpit userCockpit, ArrayList<String> cockpitRoles) {
        User user = new User(username, password, userCockpit);
        this.users.add(user);
        user.getUserRoles().addAll(parseUserRoles(userCockpit, cockpitRoles));
    }

    public void createTestInstance(String username, String password, Cockpit userCockpit, ArrayList<? extends UserRole> userRoles) {
        User user = new User(username, password, userCockpit);
        this.users.add(user);
        user.getUserRoles().addAll(userRoles);
        user.getUserRoles().add(getTestRole(userCockpit));
    }

    @SuppressWarnings("unchecked")
    public void createTestUserByApi(UserSession userSession) {
        POSTRequest createUser = CREATE_REQUEST.getClone();
        UserTitle userTitle = UserTitle.getRandom();
        String firstName = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
        String username = email;
        StorefrontUserRole role = StorefrontUserRole.getRandom();
        ArrayList<StorefrontUserRole> userRoles = new ArrayList<StorefrontUserRole>() {{
            add(role);
        }};
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("titleCode", userTitle.name().toLowerCase()));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("uid", ""));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("firstName", firstName));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("lastName", lastName));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("email", email));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("parentB2BUnit", "112395_ESHIP005"));
        userRoles.forEach(userRole -> createUser.addPostParameterAndValue(new API.PostParameterAndValue("roles", role.getRoleCode())));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("_roles", "on"));
        createTestInstance(username, "", userSession.getUser().getUserCockpit(), userRoles);
        User user = getUserByUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserTitle(userTitle);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getTestUser() {
        return users.stream().filter(user -> user.getUserRoles().stream().anyMatch(UserRole::isTest)).findFirst().orElse(null);
    }

    private UserRole getTestRole(Cockpit userCockpit) {
        if (userCockpit instanceof SarnovaStorefront) {
            return StorefrontUserRole.TEST_USER;
        } else return null;
    }

    public User getUserByUsername(String username) {
        return getUsers().stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    private ArrayList<UserRole> parseUserRoles(Cockpit userCockpit, ArrayList<String> userRoleNames) {
        ArrayList<UserRole> userRoles = new ArrayList<>();
        userRoleNames.forEach(userRoleName -> {
            UserRole userRole = null;
            if (userCockpit instanceof SarnovaStorefront) {
                switch (userRoleName) {
                    case "admin":
                        userRole = StorefrontUserRole.ADMIN;
                        break;
                    case "buyer":
                        userRole = StorefrontUserRole.BUYER;
                        break;
                    case "guest":
                        userRole = StorefrontUserRole.GUEST_CONSUMER;
                        break;
                    default:
                        break;
                }
            } else if (userCockpit instanceof SarnovaBackoffice) {
                switch (userRoleName) {
                    case "admin":
                        userRole = BackofficeUserRoles.ADMIN;
                        break;
                    case "warehouse agent":
                        userRole = BackofficeUserRoles.WAREHOUSE_AGENT;
                        break;
                    case "customer support agent":
                        userRole = BackofficeUserRoles.CUSTOMER_SUPPORT_AGENT;
                        break;
                    default:
                        break;
                }
            } else if (userCockpit instanceof SarnovaHAC) {
                switch (userRoleName) {
                    case "admin":
                        userRole = HACUserRoles.ADMIN;
                        break;
                    default:
                        break;
                }
            } else if (userCockpit instanceof SarnovaImportCockpit) {
                switch (userRoleName) {
                    case "admin":
                        userRole = ImportCockpitUserRoles.ADMIN;
                        break;
                    case "importmanager":
                        userRole = ImportCockpitUserRoles.IMPORT_MANAGER;
                        break;
                    default:
                        break;
                }
            }
            userRoles.add(userRole);
        });
        return userRoles;
    }
}
