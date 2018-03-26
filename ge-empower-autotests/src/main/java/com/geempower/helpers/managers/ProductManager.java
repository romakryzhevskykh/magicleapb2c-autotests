package com.geempower.helpers.managers;

import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.helpers.models.RegionType;
import com.geempower.helpers.request_engine.GETRequest;
import com.geempower.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;

@Component
public class ProductManager {
    private GETRequest GET_PRODUCT_DETAILS_FROM_PDP = new GETRequest("Get PD By Product Id.", "p/product_detail/%s");

    @Autowired
    RegionsManager regionsManager;
    ArrayList<Product> productsList = new ArrayList<>();

    private void createInstance(String catalogueNo, String region, String id) {
        System.out.println(region);
        System.out.println(regionsManager.getRegionByValue(region));
        productsList.add(new Product(catalogueNo, regionsManager.getRegionByValue(region), id));
    }

    public Product getProductByRegion(RegionType region) {
        return productsList.stream().filter(product -> product.getRegion().getRegionType().equals(region)).findAny().get();
    }

    public Product getProductWithAllDataByRegion(UserSession userSession, RegionType region) {
        return productsList.stream().filter(product -> product.getRegion().getRegionType().equals(region))
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
        System.out.println(response.body().toString());
        product.setDescription(Xsoup.select(response, "//[@id=product-details]/div/div[1]/table/tbody/tr[2]/td[2]/span/text()").get());
        product.setAvailability(Xsoup.select(response, "//[@id=price-availability]/div[2]/div/table/tbody/tr/td[1]/text()").get());
        product.setListPrice(Xsoup.select(response, "//[@id=price-availability]/div[5]/div[2]/table/tbody/tr[1]/td[2]/span/text()").get());
        product.setFinalNetPrice(Xsoup.select(response, "//[@id=price-availability]/div[5]/div[2]/table/tbody/tr[5]/td[2]/span/text()").get());

    }
}
