package com.geempower.helpers.models;

import lombok.Getter;

public class Return {
    @Getter final String id;
    @Getter Product product;
    @Getter final long invoiceNo;
    @Getter int qty;
    @Getter final String reasonForRequest;
    @Getter double netPrice;
    @Getter double requestedCredit;
    @Getter String requestedAction;
    @Getter String requestSubType;
    @Getter String additionalInformation;

    public Return(String id, Product product, long invoiceNo, String reasonForRequest, double requestedCredit){
        this.id = id;
        this.product = product;
        this.invoiceNo = invoiceNo;
        this.reasonForRequest = reasonForRequest;
        this.requestedCredit = requestedCredit;
    }
}
