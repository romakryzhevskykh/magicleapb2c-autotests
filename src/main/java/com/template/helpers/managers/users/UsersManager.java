package com.template.helpers.managers.users;

import com.template.helpers.models.users.*;
import com.template.hybris.Cockpit;
import com.template.hybris.backoffice.models.TemplateBackoffice;
import com.template.hybris.hac.models.TemplateHAC;
import com.template.hybris.import_cockpit.models.TemplateImportCockpit;
import com.template.storefront.models.TemplateStorefront;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
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

    public User getTestUser() {
        return users.stream().filter(user -> user.getUserRoles().stream().anyMatch(UserRole::isTest)).findFirst().orElse(null);
    }

    private UserRole getTestRole(Cockpit userCockpit) {
        if (userCockpit instanceof TemplateStorefront) {
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
            if (userCockpit instanceof TemplateStorefront) {
                switch (userRoleName) {
                    case "shopper":
                        userRole = StorefrontUserRole.SHOPPER;
                        break;
                    case "guest":
                        userRole = StorefrontUserRole.GUEST;
                        break;
                    default:
                        userRole = null;
                        break;
                }
            } else if (userCockpit instanceof TemplateBackoffice) {
                switch (userRoleName) {
                    case "admin":
                        userRole = BackofficeUserRole.ADMIN;
                        break;
                    case "warehouse agent":
                        userRole = BackofficeUserRole.WAREHOUSE_AGENT;
                        break;
                    case "customer support agent":
                        userRole = BackofficeUserRole.CUSTOMER_SUPPORT_AGENT;
                        break;
                    default:
                        userRole = null;
                        break;
                }
            }else if (userCockpit instanceof TemplateImportCockpit) {
                switch (userRoleName) {
                    case "admin":
                        userRole = ImportCockpitUserRole.ADMIN;
                        break;
                    case "import_manager":
                        userRole = ImportCockpitUserRole.IMPORT_MANAGER;
                        break;
                    default:
                        userRole = null;
                        break;
                }
            } else if (userCockpit instanceof TemplateHAC) {
                switch (userRoleName) {
                    case "admin":
                        userRole = HACUserRole.ADMIN;
                        break;
                    default:
                        userRole = null;
                        break;
                }
            }
            userRoles.add(userRole);
        });
        return userRoles;
    }
}
