package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.*;
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

    public void createInstance(String sku, String name, ArrayList<IndividualProduct> individualProducts) {
        GroupProduct groupProduct = new GroupProduct(sku, name, individualProducts);
        defineAndSetProductTestType(groupProduct);
        addTestProduct(groupProduct);
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
        if (product instanceof IndividualProduct) {
            if (((IndividualProduct) product).getAccessoriesProducts().isEmpty()
                    && ((IndividualProduct) product).getAlternativeProducts().isEmpty()
                    && !((IndividualProduct) product).isDiscontinued()
                    && !((IndividualProduct) product).isGroupMember()
                    && !((IndividualProduct) product).getUnitsOfMeasurement().isEmpty()
                    && ((IndividualProduct) product).getUnitsOfMeasurement().stream().noneMatch(uom -> uom.getListPrice() == null)
                    && ((IndividualProduct) product).getUnitsOfMeasurement().stream().noneMatch(uom -> uom.getYourPrice() == null)) {
                product.setProductTestType(ProductTestType.INDIVIDUAL_VALID);
            }
        } else if (product instanceof GroupProduct) {
            product.setProductTestType(ProductTestType.GROUP_VALID);
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
