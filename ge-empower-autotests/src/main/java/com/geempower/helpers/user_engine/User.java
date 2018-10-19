package com.geempower.helpers.user_engine;

import com.geempower.hybris.Cockpit;
import com.geempower.hybris.backoffice.models.TemplateBackoffice;
import com.geempower.hybris.hac.models.TemplateHAC;
import com.geempower.storefront.models.EmpowerStorefront;

public class User {

    private String username;
    private String password;
    private UserRole userRole;
    private Cockpit userCockpit;

    public User(String username, String password, Cockpit userCockpit, String cockpitRole) {
        this.username = username;
        this.password = password;
        this.userCockpit = userCockpit;
        if (userCockpit instanceof EmpowerStorefront) {
            switch (cockpitRole) {
                case "externaluser1":
                    userRole = StorefrontUserRoles.EXTERNALUSER1;
                    break;
                case "empoweradmin":
                    userRole = StorefrontUserRoles.EMPOWERADMIN;
                    break;
                case "internaluser":
                    userRole = StorefrontUserRoles.INTERNALUSER;
                    break;
                case "internaluser1":
                    userRole = StorefrontUserRoles.INTERNALUSER1;
                    break;
                case "regionalview":
                    userRole = StorefrontUserRoles.REGIONALVIEW;
                    break;
                case "smadmin":
                    userRole = StorefrontUserRoles.SMADMIN;
                    break;
                case "rmadmin":
                    userRole = StorefrontUserRoles.RMADMIN;
                    break;
                case "testroleuser":
                    userRole = StorefrontUserRoles.TESTROLEUSER;
                    break;
                case "caadmin":
                    userRole = StorefrontUserRoles.CAADMIN;
                    break;
                case "mfgrepuser":
                    userRole = StorefrontUserRoles.MFGREPUSER;
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