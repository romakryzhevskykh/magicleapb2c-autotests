package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.categories.Category;
import com.sarnova.helpers.models.categories.ChildCustomCategory;
import com.sarnova.helpers.models.categories.CustomCategory;
import com.sarnova.helpers.models.categories.ParentCustomCategory;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UserSession;
import com.sarnova.helpers.user_engine.UserSessions;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomCategoriesManager {
    @Autowired private UserSessions userSessions;

    private POSTRequest ADD_NEW_CUSTOM_CATEGORY = new POSTRequest("Create new Custom category", "custom-category/add");
    private GETRequest GET_CSRF_TOKEN = new GETRequest("Get CSRF token for Custom categories", "");
    private GETRequest GET_TREE_VIEW = new GETRequest("Get Custom categories tree info", "custom-category/treeView");
    private POSTRequest DELETE_CUSTOM_CATEGORY = new POSTRequest("Delete Custom category", "custom-category/delete");
    private POSTRequest ADD_PRODUCT_TO_CUSTOM_CATEGORY = new POSTRequest("Add product to Custom category", "custom-category/addProducts");

    private ArrayList<CustomCategory> customCategories = new ArrayList<>();

    public ParentCustomCategory createParentInstance(String id, String name, User user) {
        ParentCustomCategory parentCustomCategory = new ParentCustomCategory(id, name, user.getDepartment());
        customCategories.add(parentCustomCategory);
        return parentCustomCategory;
    }

    public ChildCustomCategory createChildInstance(String id, String name, ParentCustomCategory parentCategory) {
        ChildCustomCategory childCustomCategory = new ChildCustomCategory(id, name, parentCategory);
        customCategories.add(childCustomCategory);
        return childCustomCategory;
    }

    @SuppressWarnings("unchecked")
    @Step("Create parent category {1}.")
    public ParentCustomCategory createNewParentCustomCategoryByApi(UserSession userSession, String name) {
        String csrfToken = getCSRFToken(userSession);
        POSTRequest createParentCC = ADD_NEW_CUSTOM_CATEGORY.getClone();

        createParentCC.addPostParameterAndValue(new API.PostParameterAndValue("categoryName", name));
        createParentCC.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));

        try {
            createParentCC.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String id = getParentCCIdByName(userSession, name);
        return createParentInstance(id, name, userSession.getUser());
    }

    @SuppressWarnings("unchecked")
    @Step("Create child category {1} for parent {2}.")
    public ChildCustomCategory createNewChildCustomCategoryByApi(UserSession userSession, String name, ParentCustomCategory parentCategory) {
        String csrfToken = getCSRFToken(userSession);
        POSTRequest createParentCC = ADD_NEW_CUSTOM_CATEGORY.getClone();

        createParentCC.addPostParameterAndValue(new API.PostParameterAndValue("categoryName", name));
        createParentCC.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        createParentCC.addPostParameterAndValue(new API.PostParameterAndValue("parentCategoryCode", parentCategory.getId()));

        try {
            createParentCC.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String id = getChildCCIdByName(userSession, name);
        return createChildInstance(id, name, parentCategory);
    }

    public void deleteAllCustomCategories() {
        customCategories.stream()
                .filter(category -> category instanceof ParentCustomCategory)
                .forEach(customCategory -> {
                    UserSession userSession = userSessions.getAnyUserSessionForOrganization(customCategory.getDepartment());
                    deleteCustomCategory(userSession, customCategory);
                });
        customCategories.clear();
    }

    @SuppressWarnings("unchecked")
    public void deleteCustomCategory(UserSession userSession, CustomCategory category) {
        String csrfToken = getCSRFToken(userSession);
        POSTRequest deleteCC = DELETE_CUSTOM_CATEGORY.getClone();

        deleteCC.addPostParameterAndValue(new API.PostParameterAndValue("categoryCode", category.getId()));
        deleteCC.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            deleteCC.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void addProductsToCategoryByApi(UserSession userSession, ChildCustomCategory childCustomCategory, List<Product> products) {
        products.forEach(product -> addProductToCategoryByApi(userSession, childCustomCategory, product));
    }

    @SuppressWarnings("unchecked")
    public void addProductToCategoryByApi(UserSession userSession, ChildCustomCategory childCustomCategory, Product product) {
        String csrfToken = getCSRFToken(userSession);
        POSTRequest addProductsToCC = ADD_PRODUCT_TO_CUSTOM_CATEGORY.getClone();
        addProductsToCC.addPostParameterAndValue(new API.PostParameterAndValue("category", childCustomCategory.getId()));
        addProductsToCC.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        addProductsToCC.addPostParameterAndValue(new API.PostParameterAndValue("products[]", product.getSku()));

        try {
            addProductsToCC.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        childCustomCategory.getProducts().add(product);
    }

    private String getCSRFToken(UserSession userSession) {
        GETRequest getCsrfToken = GET_CSRF_TOKEN.getClone();

        try {
            getCsrfToken.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = getCsrfToken.getResponse().getHTMLResponseDocument().toString();
        return response.split("ACC.config.CSRFToken = ")[1]
                .split("\"")[1];
    }

    private org.jsoup.nodes.Document getTreeViewInfo(UserSession userSession) {
        GETRequest getTreeInfo = GET_TREE_VIEW.getClone();
        try {
            getTreeInfo.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getTreeInfo.getResponse().getHTMLResponseDocument();
    }

    public ArrayList<CustomCategory> getCustomCategories() {
        return customCategories;
    }

    private String getParentCCIdByName(UserSession userSession, String name) {
        Document ccTree = getTreeViewInfo(userSession);
        return Xsoup.select(ccTree, "div[@class=expanded_panel]").getElements().stream()
                .filter(element -> element.text().equals(name))
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No Parent Custom Category with name: " + name);
                }).attr("id");
    }

    private String getChildCCIdByName(UserSession userSession, String name) {
        Document ccTree = getTreeViewInfo(userSession);
        return Xsoup.select(ccTree, "//a[@class=custom_subcategory]").getElements().stream()
                .filter(element -> element.text().equals(name))
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No Child Custom Category with name: " + name);
                }).attr("data-category");
    }

    public Category getCustomCategoryById(String id) {
        return getCustomCategories().stream().filter(category -> category.getId().equals(id)).findAny().orElse(null);
    }
}
