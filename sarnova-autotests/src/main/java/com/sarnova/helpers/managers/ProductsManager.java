package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.*;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                    && !((IndividualProduct) product).isGroupMember()
                    && !((IndividualProduct) product).getUnitsOfMeasurement().isEmpty()
                    && ((IndividualProduct) product).getUnitsOfMeasurement().stream().noneMatch(uom -> uom.getListPrice() == null)
                    && ((IndividualProduct) product).getUnitsOfMeasurement().stream().noneMatch(uom -> uom.getYourPrice() == null)) {
                product.addProductTestType(ProductTestType.VALID);
            }
            if (((IndividualProduct) product).getUnitsOfMeasurement().size() > 1) {
                product.addProductTestType(ProductTestType.WITH_MORE_THAN_ONE_UOM);
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
                .flatMap(unitOfMeasureRow -> ((IndividualProduct) getProductBySku(
                        Xsoup.select(unitOfMeasureRow, "//div[@class=item__info]/div[@class=item__code]/text()")
                                .get().trim()))
                        .getUnitsOfMeasurement()
                        .stream()
                        .filter(unitOfMeasure -> unitOfMeasure.getUomType().equalsByFullName(
                                Xsoup.select(unitOfMeasureRow, "//div[@class=item__unit]/text()")
                                        .get().trim())
                        )
                ).collect(Collectors.toCollection(ArrayList::new));
    }
}
