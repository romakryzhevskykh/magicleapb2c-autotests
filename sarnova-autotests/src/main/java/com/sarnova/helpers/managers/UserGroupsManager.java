package com.sarnova.helpers.managers;

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
import java.util.List;

import static com.sarnova.RegexUtils.matchPattern;

@Component
public class UserGroupsManager {
    private static final String DEPARTMENT_ID_REGEX_PATTERN = "id=\"department-radio-(.*)\"\\s*class.*\\s*checked";
    private static final String CSRFTOKEN_REGEX_PATTERN = "CSRFToken\\s*=\\s*\"(.+)\";";

    private GETRequest PERMISSIONS_PAGE_FOR_GROUP = new GETRequest("User group permissions page", "my-company/organization-management/manage-usergroups/permissions/?usergroup=%s");
    private GETRequest CREATE_USER_GROUP_PAGE = new GETRequest("Create new user group page", "my-company/organization-management/manage-usergroups/create");
    private POSTRequest ADD_PERMISSION = new POSTRequest("Add permission to user", "my-company/organization-management/manage-usergroups/permissions/select/");
    private POSTRequest REMOVE_PERMISSION = new POSTRequest("Remove permission to user", "my-company/organization-management/manage-usergroups/permissions/deselect/");
    private POSTRequest CREATE_USER_GROUP = new POSTRequest("Create new user group", "my-company/organization-management/manage-usergroups/create/");
    private POSTRequest DELETE_USER_GROUP = new POSTRequest("Delete user group", "my-company/organization-management/manage-usergroups/remove/");
    private GETRequest PERMISSIONS_PAGE = new GETRequest("User group Permissions page", "my-company/organization-management/manage-usergroups/permissions/");

    private List<UserGroup> userGroups = new ArrayList<>();

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    @SuppressWarnings("unchecked")
    @Step("Create User group.")
    public UserGroup createUserGroup(UserSession activeUserSession) {
        String csrfToken = getCreateGroupPageCsrfToken(activeUserSession);
        String departmentId = getSelectedUserDepartmentId(activeUserSession);
        String groupName = RandomStringUtils.randomAlphabetic(10);
        POSTRequest createUserGroup = CREATE_USER_GROUP.getClone();
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("originalUid", ""));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("uid", "uid"));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("name", groupName));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("parentUnit", departmentId));
        createUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            createUserGroup.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(createUserGroup.getResponse().getResponseHeaders());

       UserGroup userGroup = createInstance(createUserGroup.getResponse().getResponseHeaders().get("Location").get(0).split("=")[1], groupName);
       activeUserSession.getUser().getUserGroups().add(userGroup);
       return userGroup;
    }

    @SuppressWarnings("unchecked")
    @Step("Delete {1}.")
    public void deleteUserGroup(UserSession activeUserSession, UserGroup userGroup) {
        POSTRequest deleteUserGroup = DELETE_USER_GROUP.getClone();
        String csrfToken = getCreateGroupPageCsrfToken(activeUserSession);
        deleteUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("usergroup", userGroup.getUId()));
        deleteUserGroup.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            deleteUserGroup.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void deleteAllCreatedUserGroups(UserSession activeUserSession) {
        activeUserSession.getUser().getUserGroups().forEach(userGroup -> deleteUserGroup(activeUserSession, userGroup));
        userGroups.clear();
    }

    public UserGroup getUserGroupByUid(String uid) {
        return getUserGroups().stream().filter(userGroup -> userGroup.getUId().equalsIgnoreCase(uid)).findAny().orElse(null);
    }

    public UserGroup createInstance(String uid) {
        UserGroup userGroup =  new UserGroup(uid);
        userGroups.add(userGroup);
        return userGroup;
    }

    public UserGroup createInstance(String uid, String name) {
        UserGroup userGroup =  new UserGroup(uid, name);
        userGroups.add(userGroup);
        return userGroup;
    }

    @SuppressWarnings("unchecked")
    public void addPermissionsToUserGroup(UserSession activeUserSession, UserGroup editingUserGroup, List<Permission> permissions) {
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

    public void removePermissionsToUserGroup(UserSession activeUserSession, UserGroup editingUserGroup, List<Permission> permissions) {
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

    private String getCreateGroupPageCsrfToken(UserSession userSession) {
        String htmlResponse = getUserGroupsPage(userSession);
        return matchPattern(htmlResponse, CSRFTOKEN_REGEX_PATTERN, 1);
    }

    private String getUserGroupsPage(UserSession userSession){
        GETRequest userGroupRequest = CREATE_USER_GROUP_PAGE.getClone();
        userGroupRequest.setIsShortLogResponse(true);
        try {
            userGroupRequest.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userGroupRequest.getResponse().getHTMLResponseDocument().outerHtml();
    }

    private String getSelectedUserDepartmentId(UserSession userSession){
        String htmlResponse = getUserGroupsPage(userSession);
        return matchPattern(htmlResponse, DEPARTMENT_ID_REGEX_PATTERN, 1);
    }
}
