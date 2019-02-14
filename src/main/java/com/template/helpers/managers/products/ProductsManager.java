package com.template.helpers.managers.products;

import com.template.helpers.models.products.BaseProduct;
import com.template.helpers.models.products.ProductAttribute;
import com.template.helpers.models.products.ProductTestType;
import com.template.helpers.models.products.VariantProduct;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductsManager {

    @Getter private ArrayList<BaseProduct> testBaseProducts = new ArrayList<>();

    public synchronized void createTestBaseProductInstance(String id, String name, Set<ProductAttribute> attributes) {
        BaseProduct baseProduct = createParentProductInstance(id, name, attributes);
        testBaseProducts.add(baseProduct);
    }

    public synchronized BaseProduct createParentProductInstance(String id, String name, Set<ProductAttribute> attributes) {
        return new BaseProduct(id, name, attributes);
    }

    public synchronized void createTestBaseProductInstance(String id, String name) {
        BaseProduct baseProduct = createParentProductInstance(id, name);
        testBaseProducts.add(baseProduct);
    }

    public synchronized BaseProduct createParentProductInstance(String id, String name) {
        return new BaseProduct(id, name);
    }

    public synchronized void createTestVariantProductInstance(BaseProduct baseProduct, String id, double price, Set<ProductAttribute> attributes) {
        VariantProduct product = createVariantProductInstance(baseProduct, id, price, attributes);
        baseProduct.getVariantProducts().add(product);
        defineAndSetProductTestType(product);
    }

    public synchronized VariantProduct createVariantProductInstance(BaseProduct parentProduct, String id, double price, Set<ProductAttribute> attributes) {
        return new VariantProduct(parentProduct, id, price, attributes);
    }

    public synchronized void createTestVariantProductInstance(BaseProduct baseProduct, String id, double price) {
        VariantProduct product = createVariantProductInstance(baseProduct, id, price);
        baseProduct.getVariantProducts().add(product);
        defineAndSetProductTestType(product);
    }

    public synchronized VariantProduct createVariantProductInstance(BaseProduct baseProduct, String id, double price) {
        return new VariantProduct(baseProduct, id, price);
    }


    public synchronized BaseProduct getBaseProductById(String id) {
        return getTestBaseProducts().stream()
                .filter(baseProduct -> baseProduct.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public synchronized VariantProduct getVariantProductById(String id) {
        return getTestBaseProducts().stream()
                .flatMap(parentProduct -> parentProduct.getVariantProducts().stream())
                .filter(variantProduct -> variantProduct.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<VariantProduct> getTestVariantProducts() {
        return getTestBaseProducts().stream()
                .flatMap(parentProduct -> parentProduct.getVariantProducts().stream())
                .collect(Collectors.toList());
    }

    public synchronized VariantProduct getProductByProductTestTypes(List<String> productTypes) {
        return getTestVariantProducts().stream()
                .filter(variantProduct -> variantProduct.getProductTestTypes().containsAll(productTypes.stream()
                        .map(ProductTestType::valueOf)
                        .collect(Collectors.toCollection(ArrayList::new))))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No such product type in the test products list: " + productTypes.toString());
                });
    }

    public synchronized List<VariantProduct> getUniqueVariantProductsByProductsQuantityAndProductTestTypes(int numberOfProductsToReturn, List<String> productTypes) {
        ArrayList<VariantProduct> selectedProducts = new ArrayList<>();
        for (int i = 0; i < numberOfProductsToReturn; i++) {
            selectedProducts.add(getTestVariantProducts().stream()
                    .filter(productVariant -> productVariant.getProductTestTypes().containsAll(productTypes.stream()
                            .map(ProductTestType::valueOf)
                            .collect(Collectors.toCollection(ArrayList::new))))
                    .filter(productVariant -> !selectedProducts.contains(productVariant))
                    .findAny()
                    .orElseGet(() -> {
                        throw new NullPointerException("No such product type in the test UOMs list: " + productTypes.toString());
                    }));
        }
        return selectedProducts;
    }

    private synchronized void defineAndSetProductTestType(VariantProduct product) {
        Optional<ProductAttribute> licenseRestricted = product.getBaseProduct().getProductAttributes()
                .stream().filter(attribute -> attribute.getName().equalsIgnoreCase("license"))
                .findAny();
        boolean isLicenseRestricted = licenseRestricted.isPresent() && licenseRestricted.get().getBooleanValue();
        if (isLicenseRestricted){
            product.addProductTestType(ProductTestType.LICENSE_RESTRICTED);
        }else {
            product.addProductTestType(ProductTestType.VALID);
        }
    }

    public synchronized VariantProduct getProductThatHasAtLeastInputNumberOfVariants(int numberOfVariants) {
        return getTestBaseProducts().stream().filter(parentProduct -> parentProduct.getVariantProducts().size() >= numberOfVariants)
                .findAny().orElseGet(() -> {
                    throw new NullPointerException(String.format("Cannot find a parent product with %d variants.", numberOfVariants));
                }).getVariantProducts().stream().findAny().orElse(null);
    }
}
