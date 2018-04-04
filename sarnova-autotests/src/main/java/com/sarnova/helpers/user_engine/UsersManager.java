package com.sarnova.helpers.user_engine;

import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.backoffice.models.SarnovaBackoffice;
import com.sarnova.hybris.hac.models.SarnovaHAC;
import com.sarnova.hybris.import_cockpit.models.SarnovaImportCockpit;
import com.sarnova.storefront.models.SarnovaStorefront;

import java.util.ArrayList;

public class UsersManager {
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

    public ArrayList<User> getUsers() {
        return users;
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
