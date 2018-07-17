package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.users.Organization;
import com.sarnova.helpers.models.users.UserGroup;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.user_engine.Permission;
import com.sarnova.helpers.user_engine.UserSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class UserGroupsManager {
    GETRequest PERMISSIONS_PAGE_FOR_GROUP = new GETRequest("User group permissions page", "my-company/organization-management/manage-usergroups/permissions/?usergroup=%s");
    GETRequest CREATE_USER_GROUP_PAGE = new GETRequest("Create new user group page", "my-company/organization-management/manage-usergroups/create");
    POSTRequest ADD_PERMISSION = new POSTRequest("Add permission to user", "my-company/organization-management/manage-usergroups/permissions/select/");
    POSTRequest REMOVE_PERMISSION = new POSTRequest("Remove permission to user", "my-company/organization-management/manage-usergroups/permissions/deselect/");
    POSTRequest CREATE_USER_GROUP = new POSTRequest("Create new user group", "my-company/organization-management/manage-usergroups/create/");
    POSTRequest DELETE_USER_GROUP = new POSTRequest("Delete user group", "my-company/organization-management/manage-usergroups/remove/");
    GETRequest PERMISSIONS_PAGE = new GETRequest("User group Permissions page", "my-company/organization-management/manage-usergroups/permissions/");

    private ArrayList<UserGroup> userGroups = new ArrayList<>();

    public ArrayList<UserGroup> getUserGroups() {
        return userGroups;
    }

    @SuppressWarnings("unchecked")
    @Step("Create User group.")
    public void createUserGroup(UserSession activeUserSession) {
//        String groupUID = RandomStringUtils.randomAlphabetic(10);
        String csrfToken = getCreateGroupPageCsrfToken(activeUserSession);
        String groupName = RandomStringUtils.randomAlphabetic(10);
        Organization organization = activeUserSession.getUser().getOrganization();
        POSTRequest createUserGroup = CREATE_USER_GROUP.getClone();
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("originalUid", ""));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("uid", "uid"));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("name", groupName));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("parentUnit", organization.getId()));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            createUserGroup.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(createUserGroup.getResponse().getResponseHeaders());

        createInstance(createUserGroup.getResponse().getResponseHeaders().get("Location").get(0).split("=")[1], groupName);
    }

    @SuppressWarnings("unchecked")
    @Step("Delete {1}.")
    public void deleteUserGroup(UserSession activeUserSession, UserGroup userGroup) {
        POSTRequest deleteUserGroup = DELETE_USER_GROUP.getClone();
        deleteUserGroup.setGetParameterAndValue("usergroup", userGroup.getUId());
        try {
            deleteUserGroup.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void deleteAllCreatedUserGroups(UserSession activeUserSession) {
        userGroups.forEach(userGroup -> deleteUserGroup(activeUserSession, userGroup));
        userGroups.clear();
    }

    public UserGroup getUserGroupByUid(String uid) {
        return getUserGroups().stream().filter(userGroup -> userGroup.getUId().equalsIgnoreCase(uid)).findAny().orElse(null);
    }

    public void createInstance(String uid) {
        userGroups.add(new UserGroup(uid));
    }

    public void createInstance(String uid, String name) {
        userGroups.add(new UserGroup(uid, name));
    }

    @SuppressWarnings("unchecked")
    public void addPermissionsToUserGroup(UserSession activeUserSession, UserGroup editingUserGroup, ArrayList<Permission> permissions) {
        permissions.forEach(permission -> addPermissionToUserGroup(activeUserSession, editingUserGroup, permission));
        editingUserGroup.getPermissions().addAll(permissions);
    }

    @SuppressWarnings("unchecked")
    @Step("Add {2} to {1}")
    public void addPermissionToUserGroup(UserSession activeUserSession, UserGroup editingUserGroup, Permission permission) {
        String csrfToken = getCreateGroupPageCsrfToken(activeUserSession);
        POSTRequest addPermission = ADD_PERMISSION.getClone();
        addPermission.setGetParameterAndValue("usergroup", editingUserGroup.getUId());
        addPermission.setGetParameterAndValue("permission", permission.getPermissionCode());
        addPermission.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            addPermission.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Add permission after api is involved
    }

    public void removePermissionsToUserGroup(UserSession activeUserSession, UserGroup editingUserGroup, ArrayList<Permission> permissions) {
        permissions.forEach(permission -> removePermissionToUserGroup(activeUserSession, editingUserGroup, permission));
        editingUserGroup.getPermissions().removeAll(permissions);
    }

    @SuppressWarnings("unchecked")
    @Step("Remove {2} from {1}")
    public void removePermissionToUserGroup(UserSession activeUserSession, UserGroup editingUserGroup, Permission permission) {
        String csrfToken = getCreateGroupPageCsrfToken(activeUserSession);
        POSTRequest removePermission = REMOVE_PERMISSION.getClone();
        removePermission.setGetParameterAndValue("usergroup", editingUserGroup.getUId());
        removePermission.setGetParameterAndValue("permission", permission.getPermissionCode());
        removePermission.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            removePermission.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Remove permission after api is involved
    }

    @Step("Initiate {1} permissions.")
    public void initPermissionsToTheUserGroup(UserSession activeUserSession, UserGroup userGroup) {
        userGroup.getPermissions().clear();
        for (int i = 0; i <= Math.round(Permission.values().length / 9.0); i++) {
            GETRequest permissionsPage = PERMISSIONS_PAGE.getClone();
            permissionsPage.setGetParameterAndValue("usergroup", userGroup.getUId());
            permissionsPage.setGetParameterAndValue("page", String.valueOf(i));
            try {
                permissionsPage.sendGetRequest(activeUserSession);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Document htmlResponse = permissionsPage.getResponse().getHTMLResponseDocument();
            Xsoup.select(htmlResponse, "//div[@class=account-list]/div/div/div").getElements()
                    .forEach(element -> {
                        if (element.className().contains("selected")) {
                            userGroup.getPermissions().add(Permission.getPermissionByCode(element.id().replaceFirst("row-", "")));
                        }
                    });
        }
        userGroup.setInitiated(true);
    }

    public String getCreateGroupPageCsrfToken(UserSession userSession) {
        GETRequest getCartPageSource = CREATE_USER_GROUP_PAGE.getClone();
        try {
            getCartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getCartPageSource.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//input[@name=CSRFToken]/@value").list().stream().findAny().orElse(null);
    }
}
