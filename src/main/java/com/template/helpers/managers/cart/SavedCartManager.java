//package com.template.helpers.managers.cart;
//
//import com.template.helpers.managers.products.ProductsManager;
//import com.template.helpers.models.lists.SavedCart;
//import com.template.helpers.models.users.User;
//import com.template.helpers.request_engine.DELETERequest;
//import com.template.helpers.request_engine.GETRequest;
//import com.template.helpers.request_engine.POSTRequest;
//import com.template.helpers.user_engine.UserSession;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.yandex.qatools.allure.annotations.Step;
//import us.codecraft.xsoup.Xsoup;
//
//import java.io.IOException;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//@Component
//public class SavedCartManager {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SavedCartManager.class);
//
//    @Autowired private ProductsManager productsManager;
//
//    private static final POSTRequest CREATE_LIST = new POSTRequest("Create List", "my-account/saved-lists/addSavedList");
//    private static final DELETERequest REMOVE_LIST = new DELETERequest("Remove Saved List", "my-account/saved-lists/%s/delete");
//    private static final POSTRequest RENAME_LIST = new POSTRequest("Rename Saved List", "my-account/saved-lists/%s/edit");
//    private static final GETRequest LIST_PAGE_SOURCE = new GETRequest("Get a Saved List information", "my-account/saved-lists/%s");
//    private static final GETRequest LISTS_PAGE_SOURCE = new GETRequest("Get All lists", "my-account/saved-lists");
//    private static final POSTRequest ADD_SKU_TO_LIST = new POSTRequest("Add SKU to a Saved List", "my-account/saved-lists/%s/addSku");
//    private static final POSTRequest UPDATE_PRODUCT_QTY = new POSTRequest("Update product qry in the Saved List", "my-account/saved-lists/%s/updateProductQuantity/%s");
//    private static final GETRequest GET_RESTORED_LIST_NAME = new GETRequest("Get list name which will contain products from cart", "my-account/saved-lists/%s/restore");
//    private static final POSTRequest ADD_PRODUCTS_FROM_THE_LIST_TO_CART = new POSTRequest("Add all the products from the list to cart", "my-account/saved-lists/%s/restore");
//
//    @Step("Create a new Saved List {1} for user {0}")
//    public User.UserSavedCart createNewList(UserSession userSession, String listName) {
//        POSTRequest createList = CREATE_LIST.getClone();
//        createList.addPostParameterAndValue("name", listName);
//        createList.setFollowRedirection(true);
//        try {
//            createList.sendPostRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot create a new List: {}", e);
//            return null;
//        }
//        String duplicateListResponse = "A Saved List already exists with the same name";
//        String responseText = createList.getResponse().getResponseBodyText();
//        if (duplicateListResponse.equals(responseText.trim())) {
//            LOGGER.error("{}: {}", duplicateListResponse, listName);
//        } else if (!responseText.contains("action=created")) {
//            LOGGER.error("Cannot create a List with name {}, the reason is {}", listName, responseText);
//        } else {
//            String id = responseText.replaceAll("[^0-9]", "");
//            SavedCart newSavedList = new SavedCart(listName);
//            User.UserSavedCart userList = userSession.getUser().addSavedList(id, newSavedList);
//            userList.setUpdatedDate(SiteUtil.getFormattedListUpdatedDate());
//            return userList;
//        }
//        return null;
//    }
//
//    @Step("Remove the Saved List {1} for user {0}")
//    private void removeList(UserSession userSession, User.UserSavedList savedList) {
//        DELETERequest removeList = REMOVE_LIST.getClone();
//        removeList.setValue(savedList.getId());
//        try {
//            removeList.sendDeleteRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot remove the list: {}, {}", savedList, e);
//        }
//    }
//
//    public void removeUserSavedLists(UserSession userSession, List<User.UserSavedList> savedLists) {
//        savedLists.forEach(list -> removeList(userSession, list));
//        userSession.getUser().getUserSavedLists().removeAll(savedLists);
//    }
//
//    public void removeUserSavedList(UserSession userSession, User.UserSavedList savedList) {
//        removeList(userSession, savedList);
//        userSession.getUser().getUserSavedLists().remove(savedList);
//    }
//
//    @Step("Rename the Saved List {1} to: {2}.")
//    public void renameTheList(UserSession userSession, User.UserSavedList list, String newListName) {
//        POSTRequest renameList = RENAME_LIST.getClone();
//        renameList.addPostParameterAndValue("name", newListName);
//        renameList.setValue(list.getId());
//        try {
//            renameList.sendPostRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot rename the list {} to {}, error: {}", list, newListName, e);
//            return;
//        }
//        String duplicateListResponse = "A Saved List already exists with the same name";
//        String responseText = renameList.getResponse().getResponseBodyText();
//        if (duplicateListResponse.equals(responseText.trim())) {
//            LOGGER.error("{}: {}", duplicateListResponse, newListName);
//        } else if (!responseText.contains("action=updated")) {
//            LOGGER.error("Cannot rename the list {} to {}, the reason is {}", list, newListName, responseText);
//        } else {
//            SavedList updatedList = list.getSavedList();
//            updatedList.setName(newListName);
//            list.setUpdatedDate(SiteUtil.getFormattedListUpdatedDate());
//        }
//    }
//
//    @Step("Get Saved Lists page source")
//    private APIResponse getPageSource(UserSession userSession) {
//        GETRequest listsPageSource = LISTS_PAGE_SOURCE.getClone();
//        try {
//            listsPageSource.sendGetRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot get page source of Saved Lists for user {}, {}", userSession, e);
//            return null;
//        }
//        return listsPageSource.getResponse();
//    }
//
//    @Step("Get Saved Saved List with id {1} page source")
//    private APIResponse getPageSourceForParticularList(UserSession userSession, String id) {
//        GETRequest listPageSource = LIST_PAGE_SOURCE.getClone();
//        listPageSource.setValue(id);
//        try {
//            listPageSource.sendGetRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot get page source for list with id {}, {}", id, e);
//            return null;
//        }
//        return listPageSource.getResponse();
//    }
//
//    @Step("Get all the lists for user {0}")
//    public List<User.UserSavedList> getAllTheUserLists(UserSession activeUserSession) {
//        if (activeUserSession.getUser().isSavedListsInit()) {
//            return activeUserSession.getUser().getUserSavedLists();
//        } else {
//            return getAllTheLists(activeUserSession);
//        }
//    }
//
//    private List<User.UserSavedList> getAllTheLists(UserSession activeUserSession) {
//        activeUserSession.getUser().getUserSavedLists().clear();
//        String allTheListsLinksXSoupPath = "//div[@class='nav-saved-lists column']//ul/li//a";
//        String listIdAttributeNameXSoupPath = "data-savedcart-id";
//
//        APIResponse apiResponse = getPageSource(activeUserSession);
//        if (Objects.isNull(apiResponse)) {
//            LOGGER.error("Cannot obtain all the saved lists for user {}. Nothing returned by a server", activeUserSession);
//            return null;
//        }
//        Document pageSourceDocument = apiResponse.getHTMLResponseDocument();
//        List<String> listsIds = Xsoup.select(pageSourceDocument, allTheListsLinksXSoupPath).getElements().stream()
//                .map(link -> link.attr(listIdAttributeNameXSoupPath)).collect(Collectors.toList());
//        listsIds.forEach(id -> getUserList(activeUserSession, id));
//        activeUserSession.getUser().setSavedListsInit(true);
//        return activeUserSession.getUser().getUserSavedLists();
//    }
//
//    @Step("Get the Saved List {1} for user {0}")
//    private User.UserSavedList getUserList(UserSession activeUserSession, String listId) {
//
//        String listNameXSoupPath = "//span[@class='label']";
//        String updatedDateXSoupPath = "//span[@class='update-date col-padding-reset']";
//        String mainInformationXSoupXpath = "//div[@class='cart-totals']//ul/li";
//
//        String productsListXSoupXpath = "//ul[@class='item__list item__list__cart']/li";
//        String productSkuXSoupXpath = "//div[@class='product-sku']/span[@class='code']";
//        String productQuantityXSoupXpath = "//input[contains(@name,'quantity')]";
//
//        APIResponse listApiResponse = getPageSourceForParticularList(activeUserSession, listId);
//        if (Objects.nonNull(listApiResponse)) {
//            Document listPageSourceDoc = listApiResponse.getHTMLResponseDocument();
//            String name = Xsoup.select(listPageSourceDoc, listNameXSoupPath).getElements().get(0).text();
//            String updatedDate = Xsoup.select(listPageSourceDoc, updatedDateXSoupPath).getElements().get(0).text();
//            List<String> mainInfos = Xsoup.select(listPageSourceDoc, mainInformationXSoupXpath).getElements().stream().map(Element::text).collect(Collectors.toList());
//            SavedList savedList = new SavedList(name);
//            User.UserSavedList userList;
//            if (mainInfos.isEmpty()) {
//                userList = activeUserSession.getUser().addSavedList(listId, savedList);
//                userList.setUpdatedDate(updatedDate);
//            } else {
//                Map<VariantProduct, Integer> productsInTheList = Xsoup.select(listPageSourceDoc, productsListXSoupXpath).getElements().stream().map(productElement -> {
//                    String sku = Xsoup.select(productElement, productSkuXSoupXpath).getElements().get(0).text();
//                    String qty = Xsoup.select(productElement, productQuantityXSoupXpath).getElements().get(0).attr("value");
//                    Map<VariantProduct, Integer> productMap = new HashMap<>();
//                    VariantProduct variantProduct = productsManager.getVariantProductById(sku);
//                    productMap.put(variantProduct, Integer.valueOf(qty));
//                    return productMap;
//                }).flatMap(map -> map.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//                savedList.addProducts(productsInTheList);
//                userList = activeUserSession.getUser().addSavedList(listId, savedList);
//                userList.setUpdatedDate(updatedDate);
//            }
//            return userList;
//        }
//        return null;
//    }
//
//    @Step("Add a product: {1}, to Saved List {2} for user {0}")
//    private void addProductToList(UserSession userSession, User.UserSavedList list, VariantProduct product) {
//        POSTRequest addSku = ADD_SKU_TO_LIST.getClone();
//        String productId = product.getId();
//        addSku.setValue(list.getId());
//        addSku.addPostParameterAndValue("sku", productId);
//        addSku.setFollowRedirection(true);
//        addSku.setIsShortLogResponse(true);
//        try {
//            addSku.sendPostRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot add product {} to the savedList {}, {}", product, list, e);
//        }
//        String responseText = addSku.getResponse().getResponseBodyText();
//        if (responseText.contains(String.format("A product %s exists in the Saved List", productId))) {
//            LOGGER.error("The product {} is already added to the savedList {}", product, list);
//        } else if (!responseText.contains(String.format("A product %s was successfully added", productId))) {
//            LOGGER.error("Cannot add the product {} to {}, response is {}", product, list, responseText);
//        }
//        list.getSavedList().addProduct(product, 1);
//    }
//
//    public void addUserProductsToList(UserSession userSession, User.UserSavedList list, List<VariantProduct> products) {
//        products.forEach(product -> addProductToList(userSession, list, product));
//    }
//
//    public void addUserProductToList(UserSession userSession, User.UserSavedList list, VariantProduct product) {
//        addProductToList(userSession, list, product);
//    }
//
//    @Step("Remove {2} from Saved List {1} for user {0}")
//    private void removeProductFromList(UserSession userSession, User.UserSavedList list, VariantProduct product) {
//        POSTRequest removeProduct = UPDATE_PRODUCT_QTY.getClone();
//        removeProduct.setValue(list.getId());
//        removeProduct.setValue(product.getId());
//        removeProduct.addPostParameterAndValue("entryNumber", "1");
//        removeProduct.addPostParameterAndValue("productCode", product.getId());
//        removeProduct.addPostParameterAndValue("initialQuantity", "0");
//        removeProduct.addPostParameterAndValue("quantity", "0");
//        try {
//            removeProduct.sendPostRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot remove product {} from the savedList {}, {}", product, list, e);
//        }
//        String responseText = removeProduct.getResponse().getResponseBodyText();
//        if (!responseText.contains("Product has been removed from your Saved List.")) {
//            LOGGER.error("Cannot remove the product {} from {}, response is {}", product, list, responseText);
//        }
//        list.getSavedList().getProducts().remove(product);
//    }
//
//    public void removeProductsFromUserList(UserSession userSession, User.UserSavedList list, List<VariantProduct> products) {
//        products.forEach(product -> removeProductFromList(userSession, list, product));
//    }
//
//    public void removeProductFromUserList(UserSession userSession, User.UserSavedList list, VariantProduct product) {
//        removeProductFromList(userSession, list, product);
//    }
//
//    public void removeAllProductsFromUserList(UserSession userSession, User.UserSavedList list) {
//        for (Iterator<Map.Entry<VariantProduct, Integer>> i = list.getSavedList().getProducts().entrySet().iterator(); i.hasNext(); ) {
//            Map.Entry<VariantProduct, Integer> entry = i.next();
//            removeProductFromList(userSession, list, entry.getKey());
//        }
//    }
//
//    @Step("Update {2} qty to {3} in Saved List {1} for user {0}")
//    public void updateQuantityOfProductInList(UserSession userSession, User.UserSavedList list, VariantProduct product, int oldQuantity, int newQuantity) {
//        POSTRequest updateQuantity = UPDATE_PRODUCT_QTY.getClone();
//        updateQuantity.setValue(list.getId());
//        updateQuantity.setValue(product.getId());
//        updateQuantity.addPostParameterAndValue("entryNumber", "1");
//        updateQuantity.addPostParameterAndValue("productCode", product.getId());
//        updateQuantity.addPostParameterAndValue("initialQuantity", String.valueOf(oldQuantity));
//        updateQuantity.addPostParameterAndValue("quantity", String.valueOf(newQuantity));
//        try {
//            updateQuantity.sendPostRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot update product {} qty to {} in the list {}, {}", product, newQuantity, list, e);
//        }
//        String responseText = updateQuantity.getResponse().getResponseBodyText();
//        if (!responseText.contains("Product quantity has been updated.")) {
//            LOGGER.error("Cannot update product {} qty {} in {}, response is {}", product, newQuantity, list, responseText);
//        }
//        list.getSavedList().getProducts().put(product, newQuantity);
//    }
//
//    public List<User.UserSavedList> createDefinedNumberOfUniqueSavedLists(UserSession activeUserSession, int numberOfListToCreate) {
//        List<User.UserSavedList> createdLists = new ArrayList<>();
//        for (int i = 0; i < numberOfListToCreate; ++i) {
//            createdLists.add(createNewList(activeUserSession, generateListName(ListTestType.VALID)));
//        }
//        return createdLists;
//    }
//
//    @Step("Get a name of a new list which will contain products from cart")
//    private String getRestoredListName(UserSession userSession, String oldListId) {
//        GETRequest getNewListName = GET_RESTORED_LIST_NAME.getClone();
//        getNewListName.setValue(oldListId);
//        try {
//            getNewListName.sendGetRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot get new list name for List with id {}, {}", oldListId, e);
//            return null;
//        }
//        APIResponse listApiResponse = getNewListName.getResponse();
//        if (Objects.nonNull(listApiResponse)) {
//            String responseBody = listApiResponse.getResponseBodyText();
//            String regex = "(?<=\\bvalue=\")[^\"]*";
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(responseBody);
//            return matcher.find() ? matcher.group() : null;
//        }
//        return null;
//    }
//
//    @Step("Add all the products from the list {1} to the cart for user {0}")
//    public void addTheProductsFromListToCart(UserSession userSession, User.UserSavedList list) {
//        POSTRequest addProductsToCart = ADD_PRODUCTS_FROM_THE_LIST_TO_CART.getClone();
//        String listId = list.getId();
//        addProductsToCart.setValue(listId);
//        addProductsToCart.setGetParameterAndValue("preventSaveActiveCart", "false");
//        addProductsToCart.setGetParameterAndValue("listName", getRestoredListName(userSession, listId));
//        addProductsToCart.setGetParameterAndValue("productCode", "");
//        try {
//            addProductsToCart.sendPostRequest(userSession);
//        } catch (IOException e) {
//            LOGGER.error("Cannot add products to cart of list with id {}, {}", listId, e);
//        }
//    }
//
//    @Step("Update the user {0} saved lists information")
//    public void updateUserSavedLists(UserSession userSession) {
//        getAllTheLists(userSession);
//    }
//
//    @Step("Get list id by name {1}")
//    public String getListIdByName(UserSession userSession, String name) {
//        Optional<User.UserSavedList> optionalList = getAllTheUserLists(userSession).stream()
//                .filter(list -> list.getSavedList().getName().equals(name)).findFirst();
//        if (optionalList.isPresent()) {
//            return optionalList.get().getId();
//        } else {
//            APIResponse apiResponse = getPageSource(userSession);
//            if (Objects.isNull(apiResponse)) {
//                LOGGER.error("Cannot obtain all the saved lists for user {}. Nothing returned by a server", userSession);
//                return null;
//            }
//            String allTheListsLinksXSoupPath = "//div[@class='nav-saved-lists column']//ul/li//a";
//            String listIdAttributeNameXSoupPath = "data-savedcart-id";
//            Document pageSourceDocument = apiResponse.getHTMLResponseDocument();
//            return Xsoup.select(pageSourceDocument, allTheListsLinksXSoupPath).getElements().stream()
//                    .filter(link -> Xsoup.select(link, "/span[@class='lists']").getElements().get(0).text().equals(name))
//                    .findFirst().map(element -> element.attr(listIdAttributeNameXSoupPath)).orElse(null);
//        }
//    }
//
//    @Step("Add a saved list {2} to user {0}.")
//    public User.UserSavedList addUserSavedList(UserSession userSession, String id, String name, Map<VariantProduct, Integer> products) {
//        SavedList list = new SavedList(name);
//        list.addProducts(products);
//        return userSession.getUser().addSavedList(id, list);
//    }
//
//    @Step("Generate list name with type {0}")
//    public String generateListName(ListTestType listType) {
//        if (listType == ListTestType.VALID) {
//            return RandomStringUtils.random(10, true, true);
//        } else if (listType == ListTestType.INVALID) {
//            String[] invalidNames = {"<alert></alert>", "     ", "<a href=\"/404\" />"};
//            Random r = new Random();
//            return invalidNames[r.nextInt(invalidNames.length)];
//        } else if (listType == ListTestType.SPECIAL_CHARACTERS) {
//            String alphabet = "!@#$%^&*()_+";
//            int n = alphabet.length();
//            Random rd = new Random();
//            StringBuilder sb = new StringBuilder(15);
//            for (int i = 0; i < 15; i++) {
//                sb.append(alphabet.charAt(rd.nextInt(n)));
//            }
//            return sb.toString();
//        } else {
//            return null;
//        }
//    }
//}
