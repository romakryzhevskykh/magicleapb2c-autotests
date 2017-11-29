package com.template.helpers.user_engine;

public class UserCredentials {

    private String login;
    private String password;
    private UserRole userRole;

    public UserCredentials(String login, String password, String cockpitType, String cockpitRole) {
        this.login = login;
        this.password = password;
        if (cockpitType.equalsIgnoreCase("storefront")) {
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
        } else if (cockpitType.equalsIgnoreCase("backoffice")) {
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
        } else if (cockpitType.equalsIgnoreCase("hac")) {
            switch (cockpitRole) {
                case "admin":
                    userRole = HACUserRoles.ADMIN;
                    break;
                default:
                    userRole = null;
                    break;
            }
        } else if (cockpitType.equalsIgnoreCase("importcockpit")) {
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
}
