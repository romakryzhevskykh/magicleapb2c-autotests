package com.template.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDataHelper {
	private float subtotal;
	final static Logger logger = Logger.getLogger(ShoppingCartDataHelper.class);
	private Map<String, Float> productWithPrices = new HashMap<String, Float>();
	private Map<String, Float> productWithTotalPrices = new HashMap<String, Float>();
	private String shoppingCartID = "";

	public ShoppingCartDataHelper() {
	}

	public float getSubtotal() {
		return subtotal;
	}

	public Map<String, Float> getProductWithTotalPrices() {
		return productWithTotalPrices;
	}

	public Map<String, Float> getProductWithPrices() {
		return productWithPrices;
	}

	public String getShoppingCartID() {
		return shoppingCartID;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public void setShoppingCartID(String shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public void addProductNamePriceToMap(String name, float price) {
		productWithPrices.put(name, price);
	}

	public void addProductNameTotalPriceToMap(String name, float totalPrice) {
		productWithTotalPrices.put(name, totalPrice);
	}

}
