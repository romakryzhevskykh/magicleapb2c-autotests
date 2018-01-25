package com.template.helpers.user_engine;

import com.template.hybris.Cockpit;
import com.template.hybris.backoffice.models.TemplateBackoffice;
import com.template.hybris.hac.models.TemplateHAC;
import com.template.hybris.import_cockpit.models.TemplateImportCockpit;
import com.template.storefront.models.TemplateStorefront;

public class User {

    private String login;
    private String password;
    private UserRole userRole;
    private Cockpit userCockpit;

    public User(String login, String password, Cockpit userCockpit, String cockpitRole) {
        this.login = login;
        this.password = password;
        this.userCockpit = userCockpit;
        if (userCockpit instanceof TemplateStorefront) {
            switch (cockpitRole) {
                case "shopper":
                    userRole = StorefrontUserRoles.SHOPPER;
                    break;
                case "guest":
                    userRole = StorefrontUserRoles.GUEST;
                    break;
                default:
                    userRole = null;
                    break;
            }
        } else if (userCockpit instanceof TemplateBackoffice) {
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
        } else if (userCockpit instanceof TemplateHAC) {
            switch (cockpitRole) {
                case "admin":
                    userRole = HACUserRoles.ADMIN;
                    break;
                default:
                    userRole = null;
                    break;
            }
        } else if (userCockpit instanceof TemplateImportCockpit) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
