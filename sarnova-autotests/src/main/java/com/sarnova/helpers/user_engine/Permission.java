package com.sarnova.helpers.user_engine;

import java.util.stream.Stream;

public enum Permission {
    ADD_BILLING_ADDRESS("b2bAddBillingAddressPermission"),
    ADD_SHIPPING_ADDRESS("b2bAddShippingAddressPermission"),
    BUSINESS_INFORMATION_MANAGEMENT("b2bBusinessInformationManagementPermission"),
    BYPASS_QUOTA("b2bBypassQuotaPermission"),
    CHECKOUT("b2bCheckoutPermission"),
    EDIT_PERSONAL_INFORMATION("b2bEditPersonalInformationPermission"),
    MANAGE_CUSTOM_CATEGORIES("b2bManageCustomCategoriesPermission"),
    MANAGE_PURCHASE_REQUESTS("b2bManagePurchaseRequestsPermission"),
    MANAGE_SUPPLY_LISTS("b2bManageSupplyListsPermission"),
    ORDER_HISTORY("b2bOrderHistoryPermission"),
    QUOTA_AND_PAR_MANAGEMENT("b2bQuotaAndParManagementPermission"),
    THE_EXCEED_QUOTA("b2bQuotaExceedPermission"),
    QUOTES("b2bQuotesPermission"),
    REPORTS("b2bReportsPermission"),
    SAVED_CARTS("b2bSavedCartsPermission"),
    SUBMIT_PURCHASE_REQUEST("b2bSubmitPurchaseRequestPermission"),
    SUPPLY_LISTS("b2bSupplyListsPermission"),
    USER_MANAGEMENT("b2bUserManagementPermission");

    private final String permissionCode;

    Permission(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public static Permission getPermissionByCode(String permissionCode) {
        return Stream.of(values()).filter(permission -> permission.getPermissionCode().equals(permissionCode)).findAny().orElse(null);
    }
}
