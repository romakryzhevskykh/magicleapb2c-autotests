package com.template.storefront.models;

public class ProductModel {
	private String scu;
	private String qty;
	private String price;
	private String productName;
	private String inStock;

	@Override
	public String toString() {
		return "ProductModel [scu=" + scu + ", qty=" + qty + ", price=" + price + ", productName=" + productName
				+ ", inStock=" + inStock + "]";
	}

	public ProductModel() {
	}

	public ProductModel(String scu, String qty, String price, String productName, String inStock) {
		this.scu = scu;
		this.qty = qty;
		this.price = price;
		this.productName = productName;
		this.inStock = inStock;
	}

	public String getScu() {
		return scu;
	}

	public String getQty() {
		return qty;
	}

	public String getPrice() {
		return price;
	}

	public String getProductName() {
		return productName;
	}

	public String getInStock() {
		return inStock;
	}

}
