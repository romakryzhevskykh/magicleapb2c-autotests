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
	private List<String> shoppingCartProductSCUs = new ArrayList<String>();
	private String shoppingCartID = "";
	private Map<String, String> scuProductMap = new HashMap<String, String>();
	private List<String> qtyValuesList = new ArrayList<String>();

	public ShoppingCartDataHelper() {
	}

	public List<String> getQtyValuesList() {
		return qtyValuesList;
	}

	public List<String> getshoppingCartProductSCUs() {
		return shoppingCartProductSCUs;
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

	public Map<String, String> getScuProductMap() {
		return scuProductMap;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public void setshoppingCartProductSCUs(List<String> shoppingCartProductSCUs) {
		this.shoppingCartProductSCUs = shoppingCartProductSCUs;
	}

	public void setShoppingCartID(String shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public void setQtyValuesList(List<String> qtyValuesList) {
		this.qtyValuesList = qtyValuesList;
	}

	public void addScuProductToMap(String scu, String productName) {
		scuProductMap.put(scu, productName);
	}

	public void addProductNamePriceToMap(String name, float price) {
		productWithPrices.put(name, price);
	}

	public void addProductNameTotalPriceToMap(String name, float totalPrice) {
		productWithTotalPrices.put(name, totalPrice);
	}

}
