package com.template.storefront.models;

import org.springframework.stereotype.Component;

@Component
public class CheckoutModelBuilder {
	private String newStreetName;
	private String newStreetNumber;
	private String newPostalCode;
	private String newTown;
	private String newCountry;
	private String newRequestedDeliveryDate;
	private String newPartialDeliveryAllowed;
	private String newAccount;
	private String newPackagingInstructions;
	private String newShippingInstructions;
	private String newPurchaseOrderNumber;

	public CheckoutModelBuilder() {

	}

	public CheckoutModelBuilder setNewStreetName(String newStreetName) {
		this.newStreetName = newStreetName;
		return this;
	}

	public CheckoutModelBuilder setNewStreetNumber(String newStreetNumber) {
		this.newStreetNumber = newStreetNumber;
		return this;
	}

	public CheckoutModelBuilder setNewPostalCode(String newPostalCode) {
		this.newPostalCode = newPostalCode;
		return this;
	}

	public CheckoutModelBuilder setNewTown(String newTown) {
		this.newTown = newTown;
		return this;
	}

	public CheckoutModelBuilder setNewCountry(String newCountry) {
		this.newCountry = newCountry;
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
		return new CheckoutDataModel(newStreetName, newStreetNumber, newPostalCode, newTown, newCountry,
				newRequestedDeliveryDate, newPartialDeliveryAllowed, newAccount, newPackagingInstructions,
				newShippingInstructions, newPurchaseOrderNumber);
	}

}
