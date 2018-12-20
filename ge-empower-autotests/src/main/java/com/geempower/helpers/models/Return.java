package com.geempower.helpers.models;

import lombok.Getter;

import java.util.Optional;

public class Return {
    @Getter final String id;
    @Getter String catalogueNo;
    @Getter Optional<Long> invoiceNo;
    @Getter int qty;
    @Getter final String reasonForRequest;
    @Getter double netPrice;
    @Getter String requestedAction;
    @Getter String requestSubType;
    @Getter String additionalInformation;

    public Return(String id, String catalogueNo, Long invoiceNo, String reasonForRequest, String requestedAction) {
        this.id = id;
        this.catalogueNo = catalogueNo;
        this.invoiceNo = Optional.ofNullable(invoiceNo);
        this.reasonForRequest = reasonForRequest;
        this.requestedAction = requestedAction;
    }
}
