package com.sarnova.helpers.user_engine;

import com.sarnova.helpers.managers.DepartmentsManager;
import com.sarnova.helpers.managers.UserGroupsManager;
import com.sarnova.helpers.models.users.Department;
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
    @Autowired DepartmentsManager departmentsManager;

    GETRequest USER_GROUPS = new GETRequest("Add user groups page", "my-company/organization-management/manage-users/usergroups?user=%s");
    GETRequest CREATE_PAGE = new GETRequest("Create new test user page", "my-company/organization-management/manage-users/create");
    POSTRequest CREATE_REQUEST = new POSTRequest("Create new test user", "my-company/organization-management/manage-users/create");
    GETRequest RESET_PASSWORD_PAGE = new GETRequest("Reset password to User page", "my-company/organization-management/manage-users/resetpassword?user=%s");
    POSTRequest RESET_PASSWORD = new POSTRequest("Reset password to User", "my-company/organization-management/manage-users/resetpassword?user=%s");
    POSTRequest REMOVE_GROUP_FROM_USER = new POSTRequest("Remove group from user", "my-company/organization-management/manage-users/usergroups/deselect/");
    POSTRequest REMOVE_ROLE_FROM_USER = new POSTRequest("Remove role from user", "my-company/organization-management/manage-users/globalRoles/deselect/");
    POSTRequest ADD_GROUP_TO_USER = new POSTRequest("Add group to user", "my-company/organization-management/manage-users/usergroups/select/");
    GETRequest USER_DETAILS_PAGE = new GETRequest("User details page", "my-company/organization-management/manage-users/details/");
    ArrayList<User> users = new ArrayList<>();

    public String getManageUserGroupsPageCsrfToken(UserSession userSession, User user) {
        GETRequest getManageGroupsSource = USER_GROUPS.getClone();
        getManageGroupsSource.setValue(user.getUsername());
        try {
            getManageGroupsSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getManageGroupsSource.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//input[@name=CSRFToken]/@value").list().stream().findAny().orElse(null);
    }

    public String getCreateUserPageCsrfToken(UserSession userSession) {
        GETRequest getCartPageSource = CREATE_PAGE.getClone();
        try {
            getCartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getCartPageSource.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//input[@name=CSRFToken]/@value").list().stream().findAny().orElse(null);
    }

    public String getResetPasswordPageCsrfToken(UserSession userSession, User userToResetPassword) {
        GETRequest getResetPasswordPageSource = RESET_PASSWORD_PAGE.getClone();
        getResetPasswordPageSource.setValue(userToResetPassword.getUsername());
        try {
            getResetPasswordPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getResetPasswordPageSource.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//input[@name=CSRFToken]/@value").list().stream().findAny().orElse(null);
    }

    public void createInstance(String username, String password, Cockpit userCockpit, ArrayList<String> cockpitRoles) {
        User user = new User(username, password, userCockpit);
        this.users.add(user);
        user.getUserRoles().addAll(parseUserRoles(userCockpit, cockpitRoles));
    }

    public void createInstance(String username, String password, Cockpit userCockpit, Department department, ArrayList<String> cockpitRoles) {
        User user = new User(username, password, userCockpit);
        user.setDepartment(department);
        this.users.add(user);
        user.getUserRoles().addAll(parseUserRoles(userCockpit, cockpitRoles));
    }

    public void createTestInstance(String username, String password, Cockpit userCockpit, Department department, ArrayList<? extends UserRole> userRoles) {
        User user = new User(username, password, userCockpit);
        user.setDepartment(department);
        this.users.add(user);
        user.getUserRoles().addAll(userRoles);
        user.getUserRoles().add(getTestRole(userCockpit));
    }

    @SuppressWarnings("unchecked")
    @Step("Create user with random parameters.")
    public void createTestUserByApi(UserSession userSession) {
        POSTRequest createUser = CREATE_REQUEST.getClone();
        String csrfToken = getCreateUserPageCsrfToken(userSession);
//        UserTitle userTitle = UserTitle.getRandom();
        String firstName = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
        String username = RandomStringUtils.randomAlphabetic(10);
        StorefrontUserRole role = StorefrontUserRole.ORGANIZATION_TEST_USER;
//        StorefrontUserRole adminRole = StorefrontUserRole.ADMIN;
        Department organization = userSession.getUser().getDepartment();
        ArrayList<StorefrontUserRole> userRoles = new ArrayList() {{
            add(role);
//            add(adminRole);
        }};
//        createUser.addPostParameterAndValue(new API.PostParameterAndValue("titleCode", userTitle.name().toLowerCase()));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("uid", username));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("firstName", firstName));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("lastName", lastName));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("email", email));
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("parentB2BUnit", organization.getId()));
        userRoles.forEach(userRole -> createUser.addPostParameterAndValue(new API.PostParameterAndValue("roles", userRole.getRoleCode())));//.stream().filter(userRole1 -> !userRole1.isTest())
        createUser.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        createUser.setHeader("Upgrade-Insecure-Requests", "1");
        try {
            createUser.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createTestInstance(username, "", userSession.getUser().getUserCockpit(), userSession.getUser().getDepartment(), userRoles);
        User user = getUserByUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
//        user.setUserTitle(userTitle);
    }

    @SuppressWarnings("unchecked")
    public void resetPassword(UserSession activeUserSession, User userToResetPassword) {
        POSTRequest resetPassword = RESET_PASSWORD.getClone();
        String passwordToSet = RandomStringUtils.randomAlphanumeric(10);
        String csrfToken = getResetPasswordPageCsrfToken(activeUserSession, userToResetPassword);
        resetPassword.setValue(userToResetPassword.getUsername());
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("uid", userToResetPassword.getUsername()));
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("newPassword", passwordToSet));
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("checkNewPassword", passwordToSet));
        resetPassword.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
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
                .filter(element -> Xsoup.select(element, "div[@class=account-cards-actions]/span/a/@data-action-confirmation-modal-id").get() != null)
                .filter(element ->
                        Xsoup.select(element, "div[@class=account-cards-actions]/span/a/@data-action-confirmation-modal-id")
                                .get()
                                .contains("removeUserGroup"))
                .filter(element -> StorefrontUserRole.getRoleByRoleCode(Xsoup.select(element, "ul/li").getElements().get(0).text()) == null)
                .forEach(element -> {
                    String groupName = Xsoup.select(element, "ul/li/a").getElements().get(0).text().trim();
                    if (userGroupsManager.getUserGroupByUid(groupName) == null) {
                        userGroupsManager.createInstance(groupName);
                    }
                    user.getUserGroups().add(userGroupsManager.getUserGroupByUid(groupName));
                });
        elements.stream()
                .filter(element -> Xsoup.select(element, "div[@class=account-cards-actions]/span/a/@data-action-confirmation-modal-id").get() != null)
                .filter(element ->
                        Xsoup.select(element, "div[@class=account-cards-actions]/span/a/@data-action-confirmation-modal-id")
                                .get()
                                .contains("removeUserGroup"))
                .filter(element -> StorefrontUserRole.getRoleByRoleCode(Xsoup.select(element, "ul/li").getElements().get(0).text()) != null)
                .forEach(element -> {
                    String roleName = Xsoup.select(element, "ul/li").getElements().get(0).text().trim();
                    user.getUserRoles().add(StorefrontUserRole.getRoleByRoleCode(roleName));
                });
        user.setInitialized(true);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getTestUser(Cockpit cockpit) {
        return users.stream()
                .filter(user -> user.getUserRoles().stream().anyMatch(UserRole::isTest))
                .filter(user -> user.getUserRoles().stream().anyMatch(userRole -> userRole.equals(getTestRole(cockpit))))
                .findFirst().orElse(null);
    }

    private UserRole getTestRole(Cockpit userCockpit) {
        if (userCockpit instanceof SarnovaStorefront) {
            return StorefrontUserRole.ORGANIZATION_TEST_USER;
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
                    case "purchase_approver":
                        userRole = StorefrontUserRole.PURCHASE_APPROVER;
                        break;
                    case "guest":
                        userRole = StorefrontUserRole.GUEST_CONSUMER;
                        break;
                    case "independent_test":
                        userRole = StorefrontUserRole.INDEPENDENT_TEST_USER;
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

    @Step("Remove all user {1} user groups.")
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

    @Step("Remove all user {1} user roles.")
    @SuppressWarnings("unchecked")
    public void removeAllUserRolesForUser(UserSession activeUserSession, User user) {
        user.getUserRoles().forEach(userRole -> {
            if (!userRole.equals(StorefrontUserRole.ORGANIZATION_TEST_USER)) {
                String csrfToken = getCreateUserPageCsrfToken(activeUserSession);
                POSTRequest removeGroup = REMOVE_ROLE_FROM_USER.getClone();
                removeGroup.setGetParameterAndValue("user", user.getUsername());
                removeGroup.setGetParameterAndValue("usergroup", userRole.getRoleCode());

                removeGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
                try {
                    removeGroup.sendPostRequest(activeUserSession);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        boolean isTestRolePresent = false;
        if (user.getUserRoles().contains(StorefrontUserRole.ORGANIZATION_TEST_USER)) {
            isTestRolePresent = true;
        }
        user.getUserRoles().clear();
        if (isTestRolePresent) {
            user.getUserRoles().add(StorefrontUserRole.ORGANIZATION_TEST_USER);
        }
    }

    @Step("Set user group {2} to user {1}.")
    @SuppressWarnings("unchecked")
    public void setUserGroupForUser(UserSession activeUserSession, User user, UserGroup userGroup) {
        String csrfToken = getCreateUserPageCsrfToken(activeUserSession);
        POSTRequest addGroup = ADD_GROUP_TO_USER.getClone();
        addGroup.setGetParameterAndValue("user", user.getUsername());
        addGroup.setGetParameterAndValue("usergroup", userGroup.getUId());

        addGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
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
