package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.*;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsManager {
    private GETRequest GET_PDP_SOURCE = new GETRequest("Get PDP source", "boundtree/en/USD/p/%s");

    private ArrayList<Product> testProducts = new ArrayList<>();

    public void createInstance(String sku, String name, String isLicenseRestricted, ArrayList<UnitOfMeasure> unitsOfMeasurement,
                               ArrayList<IndividualProduct> accessoriesProducts, ArrayList<IndividualProduct> alternativeProducts) {
        IndividualProduct individualProduct = new IndividualProduct(sku, name, isLicenseRestricted, unitsOfMeasurement, accessoriesProducts, alternativeProducts);
        defineAndSetProductTestType(individualProduct);
        addTestProduct(individualProduct);
    }

    public void createInstance(String sku, String name, ArrayList<IndividualProduct> individualProducts) {
        GroupProduct groupProduct = new GroupProduct(sku, name, individualProducts);
        defineAndSetProductTestType(groupProduct);
        addTestProduct(groupProduct);
    }

    public ArrayList<Product> getTestProducts() {
        return testProducts;
    }

    public ArrayList<IndividualProduct> getTestIndividualProducts() {
        return testProducts
                .stream()
                .filter(product -> product instanceof IndividualProduct)
                .map(product -> (IndividualProduct) product)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void addTestProduct(Product product) {
        testProducts.add(product);
    }

    public Product getProductByProductTestTypes(List<String> productTypes) {
        return getTestProducts().stream()
                .filter(product -> product.getProductTestTypes().containsAll(productTypes.stream()
                        .map(ProductTestType::valueOf)
                        .collect(Collectors.toCollection(ArrayList::new))))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No such product type in the test products list: " + productTypes.toString());
                });
    }

    public ArrayList<Product> getUniqueProductsByProductsQuantityAndTestTypes(int numberOfProductsToReturn, List<String> productTypes) {
        ArrayList<Product> selectedProducts = new ArrayList<>();
        for (int i = 0; i < numberOfProductsToReturn; i++) {
            selectedProducts.add(getTestProducts().stream()
                    .filter(product -> product.getProductTestTypes().containsAll(productTypes.stream()
                            .map(ProductTestType::valueOf)
                            .collect(Collectors.toCollection(ArrayList::new)))
                            && !selectedProducts.contains(product))
                    .findAny()
                    .orElseGet(() -> {
                        throw new NullPointerException("No such product type in the test products list: " + productTypes.toString());
                    }));
        }
        return selectedProducts;
    }

    public ArrayList<UnitOfMeasure> getUniqueUOMsByUOMsQuantityAndProductTestTypes(int numberOfProductsToReturn, List<String> productTypes) {
        ArrayList<UnitOfMeasure> selectedUOMs = new ArrayList<>();
        for (int i = 0; i < numberOfProductsToReturn; i++) {
            selectedUOMs.add(getTestProducts().stream()
                    .filter(product -> product.getProductTestTypes().containsAll(productTypes.stream()
                            .map(ProductTestType::valueOf)
                            .collect(Collectors.toCollection(ArrayList::new))))
                    .flatMap(product -> product.getUnitsOfMeasurement().stream())
                    .filter(unitOfMeasure -> !selectedUOMs.contains(unitOfMeasure))
                    .findAny()
                    .orElseGet(() -> {
                        throw new NullPointerException("No such product type in the test UOMs list: " + productTypes.toString());
                    }));
        }
        return selectedUOMs;
    }

    public IndividualProduct getProductByUOM(UnitOfMeasure unitOfMeasure) {
        return testProducts.stream()
                .filter(product -> product instanceof IndividualProduct)
                .map(product -> (IndividualProduct) product)
                .filter(product -> product.getUnitsOfMeasurement().contains(unitOfMeasure))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No product with UOM: " + unitOfMeasure);
                });
    }

    private void defineAndSetProductTestType(Product product) {
        if (product instanceof IndividualProduct) {
            product.addProductTestType(ProductTestType.INDIVIDUAL);
            if (((IndividualProduct) product).getAccessoriesProducts().isEmpty()
                    && ((IndividualProduct) product).getAlternativeProducts().isEmpty()
                    && !((IndividualProduct) product).isDiscontinued()
                    && !((IndividualProduct) product).isLicenseRestricted()
                    && !((IndividualProduct) product).isGroupMember()
                    && !product.getUnitsOfMeasurement().isEmpty()
                    && product.getUnitsOfMeasurement().stream().noneMatch(uom -> uom.getListPrice() == null)
                    && product.getUnitsOfMeasurement().stream().noneMatch(uom -> uom.getYourPrice() == null)) {
                product.addProductTestType(ProductTestType.VALID);
            }
            if (product.getUnitsOfMeasurement().size() > 1) {
                product.addProductTestType(ProductTestType.WITH_MORE_THAN_ONE_UOM);
            }
            if (((IndividualProduct) product).isLicenseRestricted()) {
                product.addProductTestType(ProductTestType.LICENSE_RESTRICTED);
            }
            if (((IndividualProduct) product).isDiscontinued()) {
                product.addProductTestType(ProductTestType.DISCONTINUED);
            }
        } else if (product instanceof GroupProduct) {
            product.addProductTestType(ProductTestType.GROUP);
        }
    }

    public Product getProductBySku(String sku) {
        return getTestProducts().stream()
                .filter(product -> product.getSku().equals(sku))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No product with SKU: " + sku + " in the test list.");
                });
    }

    public ArrayList<UnitOfMeasure> parseUnitsOfMeasurementFromCartPageHTML(ArrayList<? extends Element> unitsOfMeasurementRows) {
        return unitsOfMeasurementRows.stream()
                .flatMap(unitOfMeasureRow -> (getProductBySku(
                        Xsoup.select(unitOfMeasureRow, "//div[@class=item__info]/div[@class=item__code]/text()")
                                .get().trim()))
                        .getUnitsOfMeasurement()
                        .stream()
                        .filter(unitOfMeasure -> unitOfMeasure.getUomType().equalsByAbbreviation(
                                Xsoup.select(unitOfMeasureRow, "//div[@class=item__unit]/text()").get().trim())
                        )
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    String getCSRFTokenFromPDPOf(UserSession userSession, List<IndividualProduct> products) {
        GETRequest pageSourceToGetCSRF = GET_PDP_SOURCE.getClone();
        pageSourceToGetCSRF.setValue(products.stream().map(Product::getSku).findAny().orElse(null));
        try {
            pageSourceToGetCSRF.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = pageSourceToGetCSRF.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//form[@id=productListAddToCartForm]//input[@name=CSRFToken]/@value").get();
    }
}
