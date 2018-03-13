package com.sarnova.helpers.managers;

import com.google.common.collect.Iterables;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplyListsManager {
    @Autowired ProductsManager productsManager;

    private POSTRequest CREATE_NEW_SUPPLY_LIST = new POSTRequest("Create new Supply list by User session, number of products and name", "boundtree/en/USD/my-account/supply-lists/addProduct/");

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
                .map(SupplyListProduct::new)
                .collect(Collectors.toCollection(ArrayList::new));
        SupplyList newSupplyList = new SupplyList(user, name, id, supplyListProducts);
        testSupplyLists.add(newSupplyList);
    }

    @SuppressWarnings("unchecked")
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
