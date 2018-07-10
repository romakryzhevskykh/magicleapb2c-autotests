package com.template.helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.template.storefront.models.ProductModel;
import com.template.storefront.models.ProductModelBuilder;
import com.template.storefront.pages.RegisterPage;

@Component
public class ProductController {
	private ProductModel productModel;
	@Autowired
	private ProductModelBuilder productModelBuilder;
	final static Logger logger = Logger.getLogger(RegisterPage.class);
	private List<ProductModel> listOfProducts = new ArrayList<ProductModel>();
	private ProductPricesHelper prodHelper;

	public ProductController() {
	}

	public void createProductModel(String newScu, String newQty, String newPrice, String newProductName,
			String newInStock) {
		productModelBuilder.setNewScu(newScu);
		productModelBuilder.setNewQty(newQty);
		productModelBuilder.setNewPrice(newPrice);
		productModelBuilder.setNewProductName(newProductName);
		productModelBuilder.setNewInStock(newInStock);
		productModel = productModelBuilder.createProductModel();
	}

	public void addProductToCollection(String newScu, String newQty, String newPrice, String newProductName,
			String newInStock) {
		createProductModel(newScu, newQty, newPrice, newProductName, newInStock);
		listOfProducts.add(productModel);
	}

	public List<ProductModel> getListOfProducts() {
		logger.info(listOfProducts);
		return listOfProducts;
	}

}
