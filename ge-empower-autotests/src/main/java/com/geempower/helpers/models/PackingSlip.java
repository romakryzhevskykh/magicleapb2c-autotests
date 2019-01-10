package com.geempower.helpers.models;

import lombok.Getter;

public class PackingSlip {
    @Getter String orderLine;
    @Getter String dataPackingSlipNumber;
    @Getter String dataPackingBolNumber;
    @Getter String orderId;

    public PackingSlip (String orderId, String orderLine, String dataPackingSlipNumber, String dataPackingBolNumber) {
        this.orderId = orderId;
        this.orderLine = orderLine;
        this.dataPackingSlipNumber = dataPackingSlipNumber;
        this.dataPackingBolNumber = dataPackingBolNumber;
    }

}
