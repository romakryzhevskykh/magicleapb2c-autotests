package com.template.storefront.models;

import org.springframework.stereotype.Component;

@Component
public class CheckoutModelBuilder {
	private String newShipAddress;
	private String newRequestedDeliveryDate;
	private String newPartialDeliveryAllowed;
	private String newAccount;
	private String newPackagingInstructions;
	private String newShippingInstructions;
	private String newPurchaseOrderNumber;

	public CheckoutModelBuilder() {

	}

	public CheckoutModelBuilder setNewShipAddress(String newShipAddress) {
		this.newShipAddress = newShipAddress;
		return this;
	}

	public CheckoutModelBuilder setNewRequestedDeliveryDate(String newRequestedDeliveryDate) {
		this.newRequestedDeliveryDate = newRequestedDeliveryDate;
		return this;
	}

	public CheckoutModelBuilder setNewPartialDeliveryAllowed(String newPartialDeliveryAllowed) {
		this.newPartialDeliveryAllowed = newPartialDeliveryAllowed;
		return this;
	}

	public CheckoutModelBuilder setNewAccount(String newAccount) {
		this.newAccount = newAccount;
		return this;
	}

	public CheckoutModelBuilder setNewPackagingInstructions(String newPackagingInstructions) {
		this.newPackagingInstructions = newPackagingInstructions;
		return this;
	}

	public CheckoutModelBuilder setNewShippingInstructions(String newShippingInstructions) {
		this.newShippingInstructions = newShippingInstructions;
		return this;
	}

	public CheckoutModelBuilder setNewPurchaseOrderNumber(String newPurchaseOrderNumber) {
		this.newPurchaseOrderNumber = newPurchaseOrderNumber;
		return this;
	}

	public CheckoutDataModel createCheckoutDataModel() {
		return new CheckoutDataModel(newShipAddress, newRequestedDeliveryDate, newPartialDeliveryAllowed, newAccount,
				newPackagingInstructions, newShippingInstructions, newPurchaseOrderNumber);
	}

}
