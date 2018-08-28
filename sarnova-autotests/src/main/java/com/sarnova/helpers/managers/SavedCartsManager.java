package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.saved_carts.SavedCart;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UserSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SavedCartsManager {
    private POSTRequest SAVE_CART = new POSTRequest("Save cart", "cart/save");
    @Autowired CartManager cartManager;
    private List<SavedCart> savedCarts = new ArrayList<>();

    private SavedCart createInstance(String id, User user, String name) {
        SavedCart savedCart = new SavedCart(id, user, name);
        savedCarts.add(savedCart);
        return savedCart;
    }

    @SuppressWarnings("unchecked")
    @Step("Create Saced Cart by API name: {1}, description: {2}.")
    public void createSavedCartByApi(UserSession userSession, String name, String description, HashMap<UnitOfMeasure, Integer> unitOfMeasures) {
        POSTRequest saveCart = SAVE_CART.getClone();
        String csrfToken = cartManager.getCartPageCsrfToken(userSession);
        String currentCartId = cartManager.getCurrentCartId(userSession);
        saveCart.addPostParameterAndValue(new API.PostParameterAndValue("name", name));
        saveCart.addPostParameterAndValue(new API.PostParameterAndValue("description", description));
        saveCart.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            saveCart.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("RESPONSE: " + saveCart.getResponse().getResponseBodyText());
        SavedCart savedCart = createInstance(currentCartId, userSession.getUser(), name);
        savedCart.setDescription(description);
        savedCart.getUnitOfMeasures().putAll(unitOfMeasures);
    }

    public void createSavedCartByApi(UserSession userSession, String name, HashMap<UnitOfMeasure, Integer> unitOfMeasures) {
        createSavedCartByApi(userSession, name, "", unitOfMeasures);
    }

    public void createSavedCartByApi(UserSession userSession, HashMap<UnitOfMeasure, Integer> unitOfMeasures) {
        String name = RandomStringUtils.randomAlphabetic(10);
        createSavedCartByApi(userSession, name, unitOfMeasures);
    }

    public List<SavedCart> getSavedCarts() {
        return savedCarts;
    }

    public List<SavedCart> getUserSavedCarts(User user) {
        return savedCarts.stream().filter(savedCart -> savedCart.getUser() == user).collect(Collectors.toList());
    }

    public SavedCart getCartById(String id) {
        return savedCarts.stream().filter(savedCart -> savedCart.getId().equals(id)).findAny().orElse(null);
    }
}
