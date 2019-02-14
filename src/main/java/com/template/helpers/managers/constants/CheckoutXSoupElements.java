package com.template.helpers.managers.constants;

public class CheckoutXSoupElements {
    private static final String ADDRESS_FORM_XSOUP_PATH = "//form[@id=addressForm]";
    public static final String ADDRESS_ID_VALUE_XSOUPPATH = ADDRESS_FORM_XSOUP_PATH + "/input[@id=addressId]/@value";

    private static final String PAYMENT_FORM_XSOUPPATH = "//div[@id=newPaymentMethod]//form[@id=postToCbsTokenizationIframe]";
    public static final String UM_KEY_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMkey]/@value";
    public static final String UM_REDIR_DECLINED_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMredirDeclined]/@value";
    public static final String UM_REDIR_APPROVED_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMredirApproved]/@value";
    public static final String UM_HASH_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMhash]/@value";
    public static final String UM_COMMAND_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMcommand]/@value";
    public static final String UM_AMOUNT_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMamount]/@value";
    public static final String UM_INVOICE_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMinvoice]/@value";
    public static final String UM_TRANSACTION_ID_VALUE_XSOUPPATH = PAYMENT_FORM_XSOUPPATH + "/input[@name=UMtransactionId]/@value";


    private static final String PLACEMENT_FORM_PATH = "//form[@id=postToCbsAuthorizationIframe]";
    public static final String UM_KEY_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMkey]/@value";
    public static final String UM_NAME_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMname]/@value";
    public static final String UM_COMMAND_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMcommand]/@value";
    public static final String UM_REDIR_DECLINED_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMredirDeclined]/@value";
    public static final String UM_REDIR_APPROVED_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMredirApproved]/@value";
    public static final String UM_HASH_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMhash]/@value";
    public static final String UM_AMOUNT_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMamount]/@value";
    public static final String UM_DISCOUNT_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMdiscount]/@value";
    public static final String UM_SUBTOTAL_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMsubtotal]/@value";
    public static final String UM_TAX_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMtax]/@value";
    public static final String UM_STREET_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMstreet]/@value";
    public static final String UM_ZIP_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMzip]/@value";
    public static final String UM_INVOICE_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMinvoice]/@value";
    public static final String UM_SUBSCRIPTION_ID_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMsubscriptionId]/@value";
    public static final String UM_CARD_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMsubscriptionId]/@value";
    public static final String UM_CUST_ID_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMcustid]/@value";
    public static final String UM_TRANSACTION_ID_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMtransactionId]/@value";
    public static final String UM_CLEARANCE_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMclearance]/@value";
    public static final String UM_IP_XSOUPPATH = PLACEMENT_FORM_PATH + "/input[@name=UMip]/@value";
}
