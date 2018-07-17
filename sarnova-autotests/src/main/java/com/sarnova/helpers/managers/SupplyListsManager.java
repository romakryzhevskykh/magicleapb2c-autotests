package com.sarnova.helpers.managers;

import com.google.common.collect.Iterables;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.request_engine.PUTRequest;
import com.sarnova.helpers.user_engine.*;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplyListsManager {
    @Autowired ProductsManager productsManager;
    @Autowired UserSessions userSessions;

    private POSTRequest CREATE_NEW_SUPPLY_LIST = new POSTRequest("Create new Supply list by User session, number of products and name", "my-account/supply-lists/addProduct/");
    private PUTRequest DEACTIVATE_SUPPLY_LIST = new PUTRequest("Deactivate Supply list", "my-account/supply-lists/%s/deactivate");
    private PUTRequest DEACTIVATE_PRODUCT_IN_SUPPLY_LIST = new PUTRequest("Deactivate product in the Supply list", "my-account/supply-lists/%s/deactivate/%s");
    private POSTRequest CHANGE_FAVORITE_STATUS_FOR_SUPPLY_LIST = new POSTRequest("Change Supply list favorite status", "my-account/supply-lists/%s/toggleFavorite");
    private GETRequest SUPPLY_LIST_DETAILS_PAGE = new GETRequest("Supply list details page", "my-account/supply-lists/%s");

    private ArrayList<SupplyList> allSupplyLists;
    private ArrayList<SupplyList> testSupplyLists = new ArrayList<>();

    public ArrayList<SupplyList> getTestSupplyLists() {
        return testSupplyLists;
    }

    public ArrayList<SupplyList> getAllSupplyLists() {
        return allSupplyLists;
    }

    public void createInstance(User user, String name, String id, List<IndividualProduct> products) {
        ArrayList<SupplyListProduct> supplyListProducts = products
                .stream()
                .map(this::createSupplyProductInstance)
                .collect(Collectors.toCollection(ArrayList::new));
        SupplyList newSupplyList = new SupplyList(user, name, id, supplyListProducts);
        testSupplyLists.add(newSupplyList);
    }

    public SupplyListProduct createSupplyProductInstance(IndividualProduct individualProduct) {
        return new SupplyListProduct(individualProduct);
    }

    @SuppressWarnings("unchecked")
    @Step("Create Supply list for user: {0}, with name: {1} and products: {2}")
    public void createViaApi(UserSession userSession, String name, List<IndividualProduct> products) {
        String csrfToken = productsManager.getCSRFTokenFromPDPOf(userSession, products);
        POSTRequest createNewSupplyList = CREATE_NEW_SUPPLY_LIST.getClone();
        createNewSupplyList.setHeader("CSRFToken", csrfToken);
        createNewSupplyList.setHeader("Content-Type", "application/json");

        createNewSupplyList.addPostParameterAndValue(new API.PostParameterAndValue("existingWishlistCode",
                "not-selected"));
        createNewSupplyList.addPostParameterAndValue(new API.PostParameterAndValue("newWishlistName", name));
        createNewSupplyList.addPostParameterAndValue(new API.PostParameterAndValue("productCodes", products
                .stream()
                .map(Product::getSku)
                .collect(Collectors.toCollection(ArrayList::new))));
        try {
            createNewSupplyList.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id = Iterables
                .getLast(Arrays.asList(
                        Xsoup.select(createNewSupplyList.getResponse().getHTMLResponseDocument(), "//a/@href")
                                .get()
                                .split("/")
                ));
        createInstance(userSession.getUser(), name, id, products);
    }

    public SupplyList getSupplyListByName(String name) {
        return testSupplyLists.stream().filter(supplyList -> supplyList.getName().equals(name)).findAny().orElse(null);
    }

    @Step("Deactivate Supply list: {1}")
    public void deactivate(UserSession userSession, SupplyList activeSupplyList) {
        PUTRequest deactivateSupplyList = DEACTIVATE_SUPPLY_LIST.getClone();
        deactivateSupplyList.setValue(activeSupplyList.getId());
        try {
            deactivateSupplyList.sendPutRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        activeSupplyList.setActive(false);
    }

    @Step("Deactivate Supply list: {0}")
    public void deactivate(SupplyList activeSupplyList) {
        UserSession userSession = userSessions.getAnyUserSessionForUser(activeSupplyList.getUser());
        if (userSession != null) {
            deactivate(userSession, activeSupplyList);
        } else {
            System.out.println("[ERROR]: Can not deactivate Supply list. User has no active sessions!");
        }
    }

    @Step("Deactivate product {2} in Supply list: {1}")
    public void deactivateProductInList(UserSession userSession, SupplyList activeSupplyList, SupplyListProduct supplyListProduct) {
        PUTRequest deactivateProductInSupplyList = DEACTIVATE_PRODUCT_IN_SUPPLY_LIST.getClone();
        deactivateProductInSupplyList.setValue(activeSupplyList.getId());
        deactivateProductInSupplyList.setValue(supplyListProduct.getSku());
        try {
            deactivateProductInSupplyList.sendPutRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        supplyListProduct.setActive(false);
    }

    @SuppressWarnings("unchecked")
    @Step("Mark {1} as favorite.")
    public void markSupplyListAsFavorite(UserSession activeUserSession, SupplyList supplyList) {
        String csrfToken = getCsrfTokenFromSLDP(activeUserSession, supplyList);
        POSTRequest toggleSupplyListFavoriteStatus = CHANGE_FAVORITE_STATUS_FOR_SUPPLY_LIST.getClone();
        toggleSupplyListFavoriteStatus.setValue(supplyList.getId());
        toggleSupplyListFavoriteStatus.addPostParameterAndValue(new API.PostParameterAndValue("favorite", "true"));
        toggleSupplyListFavoriteStatus.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            toggleSupplyListFavoriteStatus.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        supplyList.setFavorite(true);
    }

    @SuppressWarnings("unchecked")
    @Step("Mark {1} as not favorite.")
    public void markSupplyListAsNotFavorite(UserSession activeUserSession, SupplyList supplyList) {
        String csrfToken = getCsrfTokenFromSLDP(activeUserSession, supplyList);
        POSTRequest toggleSupplyListFavoriteStatus = CHANGE_FAVORITE_STATUS_FOR_SUPPLY_LIST.getClone();
        toggleSupplyListFavoriteStatus.setValue(supplyList.getId());
        toggleSupplyListFavoriteStatus.addPostParameterAndValue(new API.PostParameterAndValue("favorite", "false"));
        toggleSupplyListFavoriteStatus.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            toggleSupplyListFavoriteStatus.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        supplyList.setFavorite(true);
    }

    private String getCsrfTokenFromSLDP(UserSession userSession, SupplyList supplyList) {
        GETRequest supplyListDetailsPage = SUPPLY_LIST_DETAILS_PAGE.getClone();
        supplyListDetailsPage.setValue(supplyList.getId());

        try {
            supplyListDetailsPage.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document htmlResponse = supplyListDetailsPage.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//input[@name=CSRFToken]/@value").get();
    }

    @Step("Share {2} with {1}.")
    public void shareSupplyListWithUser(UserSession activeUserSession, User userToShareWith, SupplyList supplyList) {

    }

//    public SupplyList parseSupplyListFromHTMLSupplyListDetailsPage(User user, String name, String id, String activeStatus,
//                                                                   List<Document> supplyListProductsHtml) {
//        ArrayList<SupplyListProduct> supplyListProducts = new ArrayList<>();
//        supplyListProducts.addAll(supplyListProductsHtml
//                .stream()
//                .map(supplyListProductHtml -> {
//                    SupplyListProduct supplyListProduct = new SupplyListProduct((IndividualProduct) productsManager
//                            .getProductBySku(
//                                    Xsoup.select(supplyListProductHtml, "/@data-product-code")
//                                            .get().trim()));
//
//                    supplyListProduct.setActive(
//                            Xsoup.select(supplyListProductHtml, "//div[@class=item__info]//span/text()")
//                                    .get().trim()
//                                    .equals("Inactivate"));
//                    return supplyListProduct;
//                })
//                .collect(Collectors.toList())
//        );
//        SupplyList supplyList = new SupplyList(user, name, id, supplyListProducts);
//        supplyList.setActive(activeStatus.equals("Inactivate"));
//        return supplyList;
//    }
}
