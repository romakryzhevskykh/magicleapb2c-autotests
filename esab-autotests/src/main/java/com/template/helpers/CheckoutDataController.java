package com.template.helpers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.template.storefront.models.CheckoutDataModel;
import com.template.storefront.models.CheckoutModelBuilder;
import com.template.storefront.pages.RegisterPage;

@Component
public class CheckoutDataController {
	private CheckoutDataModel checkoutDataModel;
	@Autowired
	private CheckoutModelBuilder checkoutModelBuilder;
	final static Logger logger = Logger.getLogger(CheckoutDataController.class);

	public CheckoutDataController() {

	}

	public void createCheckoutDataModel(String newStreetName, String newStreetNumber, String newPostalCode,
			String newTown, String newCountry, String newRequestedDeliveryDate, String newPartialDeliveryAllowed,
			String newAccount, String newPackagingInstructions, String newShippingInstructions,
			String newPurchaseOrderNumber) {
		checkoutModelBuilder.setNewStreetName(newStreetName);
		checkoutModelBuilder.setNewStreetNumber(newStreetNumber);
		checkoutModelBuilder.setNewPostalCode(newPostalCode);
		checkoutModelBuilder.setNewTown(newTown);
		checkoutModelBuilder.setNewCountry(newCountry);
		checkoutModelBuilder.setNewRequestedDeliveryDate(newRequestedDeliveryDate);
		checkoutModelBuilder.setNewPartialDeliveryAllowed(newPartialDeliveryAllowed);
		checkoutModelBuilder.setNewAccount(newAccount);
		checkoutModelBuilder.setNewPackagingInstructions(newPackagingInstructions);
		checkoutModelBuilder.setNewShippingInstructions(newShippingInstructions);
		checkoutModelBuilder.setNewPurchaseOrderNumber(newPurchaseOrderNumber);
		checkoutDataModel= checkoutModelBuilder.createCheckoutDataModel();
		logger.info("Chekout Data Model: " + checkoutDataModel);
	}

	public CheckoutDataModel getCheckoutDataModel() {
		return checkoutDataModel;
	}
	

}
