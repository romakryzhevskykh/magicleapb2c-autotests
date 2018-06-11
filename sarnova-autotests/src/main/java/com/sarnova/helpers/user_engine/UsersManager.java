package com.sarnova.helpers.user_engine;

import com.sarnova.helpers.managers.OrganizationsManager;
import com.sarnova.helpers.managers.UserGroupsManager;
import com.sarnova.helpers.models.users.Organization;
import com.sarnova.helpers.models.users.UserGroup;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.backoffice.models.SarnovaBackoffice;
import com.sarnova.hybris.hac.models.SarnovaHAC;
import com.sarnova.hybris.import_cockpit.models.SarnovaImportCockpit;
import com.sarnova.pay_fabric.models.PayFabric;
import com.sarnova.storefront.models.SarnovaStorefront;
import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;

public class UsersManager {
    @Autowired UserGroupsManager userGroupsManager;
    @Autowired OrganizationsManager organizationsManager;

    POSTRequest CREATE_REQUEST = new POSTRequest("Create new test user", "boundtree/en/USD/my-company/organization-management/manage-users/create");
    POSTRequest RESET_PASSWORD = new POSTRequest("Reset password to User", "my-company/organization-management/manage-users/resetpassword?user=%s");
    POSTRequest REMOVE_GROUP_FROM_USER = new POSTRequest("Remove group from user", "my-company/organization-management/manage-users/usergroups/deselect/");
    POSTRequest ADD_GROUP_TO_USER = new POSTRequest("Add group to user", "my-company/organization-management/manage-users/usergroups/select/");
    GETRequest USER_DETAILS_PAGE = new GETRequest("User details page", "my-company/organization-management/manage-users/details/");
    ArrayList<User> users = new ArrayList<>();

    public void createInstance(String username, String password, Cockpit userCockpit, ArrayList<String> cockpitRoles) {
        User user = new User(username, password, userCockpit);
        user.setOrganization(organizationsManager.getOrganization());
        this.users.add(user);
        user.getUserRoles().addAll(parseUserRoles(userCockpit, cockpitRoles));
    }

    public void createTestInstance(String username, String password, Cockpit userCockpit, ArrayList<? extends UserRole> userRoles) {
        User user = new User(username, password, userCockpit);
        user.setOrganization(organizationsManager.getOrganization());
        this.users.add(user);
        user.getUserRoles().addAll(userRoles);
        user.getUserRoles().add(getTestRole(userCockpit));
    }

    @SuppressWarnings("unchecked")
    @Step("Create user with random parameters.")
    public void createTestUserByApi(UserSession userSession) {
        POSTRequest createUser = CREATE_REQUEST.getClone();
        UserTitle userTitle = UserTitle.getRandom();
        String firstName = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
        String username = RandomStringUtils.randomAlphabetic(10);
        StorefrontUserRole role = StorefrontUserRole.TEST_USER;
        Organization organization = userSession.getUser().getOrganization();
        ArrayList<StorefrontUserRole> userRoles = new ArrayList<StorefrontUserRole>() {{
            add(role);
        }};
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("titleCode", userTitle.name().toLowerCase()));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("uid", username));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("firstName", firstName));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("lastName", lastName));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("email", email));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("parentB2BUnit", organization.getId()));
//        userRoles.forEach(userRole -> createUser.addPostParameterAndValue(new API.PostParameterAndValue("roles", role.getRoleCode())));
        createUser.setHeader("Upgrade-Insecure-Requests", "1");
        try {
            createUser.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createTestInstance(username, "", userSession.getUser().getUserCockpit(), userRoles);
        User user = getUserByUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserTitle(userTitle);
    }

    @SuppressWarnings("unchecked")
    public void resetPassword(UserSession activeUserSession, User userToResetPassword) {
        POSTRequest resetPassword = RESET_PASSWORD.getClone();
        String passwordToSet = RandomStringUtils.randomAlphanumeric(10);
        resetPassword.setValue(userToResetPassword.getUsername());
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("uid", userToResetPassword.getUsername()));
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("newPassword", passwordToSet));
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("checkNewPassword", passwordToSet));
        resetPassword.setHeader("Upgrade-Insecure-Requests", "1");
        try {
            resetPassword.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userToResetPassword.setPassword(passwordToSet);
    }

    public void initUserGroups(UserSession activeUserSession, User user) {
        user.getUserGroups().clear();
        GETRequest userDetailsPage = USER_DETAILS_PAGE.getClone();
        userDetailsPage.setGetParameterAndValue("user", user.getUsername());
        try {
            userDetailsPage.sendGetRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = userDetailsPage.getResponse().getHTMLResponseDocument();
        Elements elements = Xsoup.select(htmlResponse, "//div[@class=account-list]/div[@class=account-cards]/div[@class=row]/div[contains(@class,card)]").getElements();
        elements.stream()
                .filter(element ->
                        Xsoup.select(element, "div[@class=account-cards-actions]/span/a/@data-action-confirmation-modal-id")
                                .get()
                                .contains("removeUserGroup"))
                .filter(element -> StorefrontUserRole.getRoleByRoleCode(Xsoup.select(element, "ul/li/a/text()").get()) == null)
                .forEach(element -> {
                    if (userGroupsManager.getUserGroupByUid(element.text().trim()) == null) {
                        userGroupsManager.createInstance(element.text().trim());
                    }
                    user.getUserGroups().add(userGroupsManager.getUserGroupByUid(element.text().trim()));
                });
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
            } else if (userCockpit instanceof PayFabric) {
                switch (userRoleName) {
                    case "agent":
                        userRole = PayFabricUserRoles.AGENT;
                        break;
                    default:
                        break;
                }
            }
            userRoles.add(userRole);
        });
        return userRoles;
    }

    @SuppressWarnings("unchecked")
    public void removeAllUserGroupsForUser(UserSession activeUserSession, User user) {
        user.getUserGroups().forEach(userGroup -> {
            POSTRequest removeGroup = REMOVE_GROUP_FROM_USER.getClone();
            removeGroup.setGetParameterAndValue("user", user.getUsername());
            removeGroup.setGetParameterAndValue("usergroup", userGroup.getUId());

            removeGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", ""));
            try {
                removeGroup.sendPostRequest(activeUserSession);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        user.getUserGroups().clear();
    }

    @SuppressWarnings("unchecked")
    public void setUserGroupForUser(UserSession activeUserSession, User user, UserGroup userGroup) {
        POSTRequest addGroup = ADD_GROUP_TO_USER.getClone();
        addGroup.setGetParameterAndValue("user", user.getUsername());
        addGroup.setGetParameterAndValue("usergroup", userGroup.getUId());

        addGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", ""));
        try {
            addGroup.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.getUserGroups().add(userGroup);
    }

    public User getUserByRole(StorefrontUserRole userRole) {
        return getUsers().stream()
                .filter(user -> user.getUserRoles().stream().noneMatch(UserRole::isTest))
                .filter(user -> user.getUserRoles().contains(userRole))
                .findAny().orElse(null);
    }
}
