package com.template.storefront.models;

public class CheckoutDataModel {
	private String streetName;
	private String streetNumber;
	private String postalCode;
	private String town;
	private String country;
	private String requestedDeliveryDate;
	private String partialDeliveryAllowed;
	private String account;
	private String packagingInstructions;
	private String shippingInstructions;
	private String purchaseOrderNumber;

	public CheckoutDataModel() {

	}

	public CheckoutDataModel(String streetName, String streetNumber, String postalCode, String town, String country,
			String requestedDeliveryDate, String partialDeliveryAllowed, String account, String packagingInstructions,
			String shippingInstructions, String purchaseOrderNumber) {
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.town = town;
		this.country = country;
		this.requestedDeliveryDate = requestedDeliveryDate;
		this.partialDeliveryAllowed = partialDeliveryAllowed;
		this.account = account;
		this.packagingInstructions = packagingInstructions;
		this.shippingInstructions = shippingInstructions;
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	@Override
	public String toString() {
		return "CheckoutDataModel [streetName=" + streetName + ", streetNumber=" + streetNumber + ", postalCode="
				+ postalCode + ", town=" + town + ", country=" + country + ", requestedDeliveryDate="
				+ requestedDeliveryDate + ", partialDeliveryAllowed=" + partialDeliveryAllowed + ", account=" + account
				+ ", packagingInstructions=" + packagingInstructions + ", shippingInstructions=" + shippingInstructions
				+ ", purchaseOrderNumber=" + purchaseOrderNumber + "]";
	}

	public String getStreetName() {
		return streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getTown() {
		return town;
	}

	public String getCountry() {
		return country;
	}

	public String getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public String getPartialDeliveryAllowed() {
		return partialDeliveryAllowed;
	}

	public String getAccount() {
		return account;
	}

	public String getPackagingInstructions() {
		return packagingInstructions;
	}

	public String getShippingInstructions() {
		return shippingInstructions;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

}
