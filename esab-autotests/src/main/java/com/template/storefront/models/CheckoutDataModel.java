package com.template.storefront.models;

public class CheckoutDataModel {
	private String shipToAddress;
	private String requestedDeliveryDate;
	private String partialDeliveryAllowed;
	private String account;
	private String packagingInstructions;
	private String shippingInstructions;
	private String purchaseOrderNumber;

	@Override
	public String toString() {
		return "CheckoutDataModel [shipToAddress=" + shipToAddress + ", requestedDeliveryDate=" + requestedDeliveryDate
				+ ", partialDeliveryAllowed=" + partialDeliveryAllowed + ", account=" + account
				+ ", packagingInstructions=" + packagingInstructions + ", shippingInstructions=" + shippingInstructions
				+ ", purchaseOrderNumber=" + purchaseOrderNumber + "]";
	}

	public CheckoutDataModel() {

	}

	public CheckoutDataModel(String shipToAddress, String requestedDeliveryDate, String partialDeliveryAllowed,
			String account, String packagingInstructions, String shippingInstructions, String purchaseOrderNumber) {
		this.shipToAddress = shipToAddress;
		this.requestedDeliveryDate = requestedDeliveryDate;
		this.partialDeliveryAllowed = partialDeliveryAllowed;
		this.account = account;
		this.packagingInstructions = packagingInstructions;
		this.shippingInstructions = shippingInstructions;
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getShipToAddress() {
		return shipToAddress;
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
