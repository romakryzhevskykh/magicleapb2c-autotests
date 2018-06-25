package com.template.storefront.models;

public class ProductModel {
	private String scu;
	private String qty;
	private String price;

	@Override
	public String toString() {
		return "ProductModel [SCU=" + scu + ", Qty=" + qty + ", price=" + price + "]";
	}
	
	public ProductModel(){
	}
	
	public ProductModel(String scu, String qty, String price){
		this.scu = scu;
		this.qty = qty;
		this.price = price;	
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
	

}
