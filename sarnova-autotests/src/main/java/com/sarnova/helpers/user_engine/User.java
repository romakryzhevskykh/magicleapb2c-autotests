package com.sarnova.helpers.user_engine;

import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.backoffice.models.SarnovaBackoffice;
import com.sarnova.hybris.hac.models.SarnovaHAC;
import com.sarnova.hybris.import_cockpit.models.SarnovaImportCockpit;
import com.sarnova.storefront.models.SarnovaStorefront;

public class User {

    private String username;
    private String password;
    private UserRole userRole;
    private Cockpit userCockpit;

    public User(String username, String password, Cockpit userCockpit, String cockpitRole) {
        this.username = username;
        this.password = password;
        this.userCockpit = userCockpit;
        if (userCockpit instanceof SarnovaStorefront) {
            switch (cockpitRole) {
                case "admin":
                    userRole = StorefrontUserRoles.ADMIN;
                    break;
                case "buyer":
                    userRole = StorefrontUserRoles.BUYER;
                    break;
                case "guest":
                    userRole = StorefrontUserRoles.GUEST_CONSUMER;
                    break;
                default:
                    userRole = null;
                    break;
            }
        } else if (userCockpit instanceof SarnovaBackoffice) {
            switch (cockpitRole) {
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
                    userRole = null;
                    break;
            }
        } else if (userCockpit instanceof SarnovaHAC) {
            switch (cockpitRole) {
                case "admin":
                    userRole = HACUserRoles.ADMIN;
                    break;
                default:
                    userRole = null;
                    break;
            }
        } else if (userCockpit instanceof SarnovaImportCockpit) {
            switch (cockpitRole) {
                case "admin":
                    userRole = ImportCockpitUserRoles.ADMIN;
                    break;
                case "importmanager":
                    userRole = ImportCockpitUserRoles.IMPORT_MANAGER;
                    break;
                default:
                    userRole = null;
                    break;
            }
        } else {
            userRole = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Cockpit getUserCockpit() {
        return userCockpit;
    }
}
