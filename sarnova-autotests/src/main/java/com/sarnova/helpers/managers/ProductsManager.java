package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.ProductTestType;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductsManager {
    private ArrayList<Product> testProducts = new ArrayList<>();

    public void createInstance(String sku, String name, ArrayList<UnitOfMeasure> unitsOfMeasurement,
                               ArrayList<IndividualProduct> accessoriesProducts, ArrayList<IndividualProduct> alternativeProducts) {
        IndividualProduct individualProduct = new IndividualProduct(sku, name, unitsOfMeasurement, accessoriesProducts, alternativeProducts);
        defineAndSetProductTestType(individualProduct);
        addTestProduct(individualProduct);
    }

    public ArrayList<Product> getTestProducts() {
        return testProducts;
    }

    public void addTestProduct(Product product) {
        testProducts.add(product);
    }

    public Product getProductByProductTestType(ProductTestType productType) {
        return getTestProducts().stream()
                .filter(product -> product.getProductTestType().equals(productType))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No such product type in the test products list: " + productType.toString());
                });
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
        product.setProductTestType(ProductTestType.INDIVIDUAL_VALID);
    }
}
