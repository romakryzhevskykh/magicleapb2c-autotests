package com.template.storefront.models;

import org.springframework.stereotype.Component;

@Component
public class ProductModelBuilder {
	private String newScu;
	private String newQty;
	private String newPrice;
	private String newProductName;
	private String newInStock;

	public ProductModelBuilder() {
	}

	public ProductModelBuilder setNewScu(String newScu) {
		this.newScu = newScu;
		return this;
	}
	
	public ProductModelBuilder setNewQty(String newQty){
		this.newQty = newQty;
		return this;
	}
	
	public ProductModelBuilder setNewPrice(String newPrice){
		this.newPrice = newPrice;
		return this;
	}
	
	public ProductModelBuilder setNewProductName(String newProductName){
		this.newProductName = newProductName;
		return this;
	}
	
	public ProductModelBuilder setNewInStock(String newInStock){
		this.newInStock = newInStock;
		return this;
	}
	
	public ProductModel createProductModel(){
		return new ProductModel(newScu, newQty, newPrice, newProductName, newInStock);
	}
}
