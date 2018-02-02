package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UserSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
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

    public void createInstance(User user, String name, ArrayList<IndividualProduct> products) {
        ArrayList<SupplyListProduct> supplyListProducts = products
                .stream()
                .map(SupplyListProduct::new)
                .collect(Collectors.toCollection(ArrayList::new));
        SupplyList newSupplyList = new SupplyList(user, name, supplyListProducts);
        testSupplyLists.add(newSupplyList);
    }

    public void createViaApi(UserSession userSession, String name, ArrayList<IndividualProduct> products) {
        POSTRequest createNewSupplyList = CREATE_NEW_SUPPLY_LIST.getClone();
        createNewSupplyList.setHeader("Content-Type", "application/json");
        createNewSupplyList.addPostParameterAndValue(new API.ParameterAndValue("newWishlistName", name));
        createNewSupplyList.addPostParameterAndValue(new API.ParameterAndValue("productCodes", products
                .stream()
                .map(Product::getSku)
                .collect(Collectors.toCollection(ArrayList::new)).toString()));
        try {
            createNewSupplyList.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createInstance(userSession.getUser(), name, products);
    }

    public SupplyList getSupplyListByName(String name) {
        return testSupplyLists.stream().filter(supplyList -> supplyList.getName().equals(name)).findAny().orElse(null);
    }

    public SupplyList parseSupplyListFromHTMLSupplyListDetailsPage(User user, String name, String activeStatus,
                                                                   List<WebElement> supplyListProductsWebElements) {
        ArrayList<SupplyListProduct> supplyListProducts = supplyListProductsWebElements
                .stream()
                .map(supplyListProductsWebElement -> {
                    SupplyListProduct supplyListProduct = new SupplyListProduct((IndividualProduct) productsManager
                            .getProductBySku(supplyListProductsWebElement.findElement(By.xpath("//div[@class = 'item__code']")).getText().trim()));
                    supplyListProduct.setActive(supplyListProductsWebElement.findElement(By.xpath("div[@class = 'item__info']//span")).getText().trim()
                            .equals("Inactivate"));
                    return supplyListProduct;
                })
                .collect(Collectors.toCollection(ArrayList::new));
        SupplyList supplyList = new SupplyList(user, name, supplyListProducts);
        supplyList.setActive(activeStatus.equals("Inactivate"));
        return supplyList;
    }
}
