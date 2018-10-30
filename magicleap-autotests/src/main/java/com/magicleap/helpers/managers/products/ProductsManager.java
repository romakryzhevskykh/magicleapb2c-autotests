package com.magicleap.helpers.managers.products;

import com.magicleap.helpers.models.products.Product;
import com.magicleap.helpers.models.products.ProductTestType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsManager {

    private ArrayList<Product> testProducts = new ArrayList<>();

    public void createInstance(String sku, String name, String isLicenseRestricted) {
        Product groupProduct = new Product(sku, name, isLicenseRestricted);
        defineAndSetProductTestType(groupProduct);
        addTestProduct(groupProduct);
    }

    public ArrayList<Product> getTestProducts() {
        return testProducts;
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

    public ArrayList<Product> getUniqueProductsByProductsQuantityTestTypesAndExcludeProductList(int numberOfProductsToReturn, List<String> productTypes, List<? extends Product> excludeProducts) {
        ArrayList<Product> selectedProducts = new ArrayList<>();
        ArrayList<Product> productsToSearchIn = new ArrayList<Product>() {{
            addAll(getTestProducts());
            removeAll(excludeProducts);
        }};
        for (int i = 0; i < numberOfProductsToReturn; i++) {
            selectedProducts.add(productsToSearchIn.stream()
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

    private void defineAndSetProductTestType(Product product) {
        if (product != null) {
            product.addProductTestType(ProductTestType.VARIANT);
            if (!product.isLicenseRestricted()) {
                product.addProductTestType(ProductTestType.VALID);
            }
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
}
