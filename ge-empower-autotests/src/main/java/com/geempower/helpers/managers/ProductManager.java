package com.geempower.helpers.managers;

import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.helpers.request_engine.GETRequest;
import com.geempower.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;

import static com.geempower.helpers.managers.ManagerWebElements.*;

@Component
public class ProductManager {
    private GETRequest GET_PRODUCT_DETAILS_FROM_PDP = new GETRequest("Get PD By product Id.", "p/product_detail/%s");

    @Autowired
    RegionsManager regionsManager;
    ArrayList<Product> productsList = new ArrayList<>();

    public void createInstance(String catalogueNo, String region, String id) {
        productsList.add(new Product(catalogueNo, regionsManager.getRegionByValue(region), id));
    }

    public Product getProductByRegion(Region region) {
        return productsList.stream().filter(product -> product.getRegion().equals(region)).findAny().get();
    }

    public Product getProductWithAllDataByRegion(UserSession userSession, Region region) {
        return productsList.stream().filter(product -> product.getRegion().equals(region))
                .filter(product -> product.getListPrice() != null).findAny()
                .orElseGet(() -> {
                    Product product = getProductByRegion(region);
                    try {
                        setAllDataFromPDP(userSession, product);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return product;
                });
    }

    public void setAllDataFromPDP(UserSession userSession, Product product) throws IOException {
        GETRequest getProductDetailsByProductId = GET_PRODUCT_DETAILS_FROM_PDP.getClone();
        getProductDetailsByProductId.setValue(product.getId());
        getProductDetailsByProductId.sendGetRequest(userSession);
        Document response = getProductDetailsByProductId.getResponse().getHTMLResponseDocument();
        product.setDescription(Xsoup.select(response, DESCRIPTION_XPATH).get());
        product.setAvailability(Xsoup.select(response, AVAILABILITY_XPATH).get());
        product.setListPrice(Xsoup.select(response, LIST_PRICE).get());
        product.setFinalNetPrice(Xsoup.select(response, FINAL_NET_PRICE).get());
    }
}
