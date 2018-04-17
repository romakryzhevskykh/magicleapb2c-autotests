package com.geempower.helpers.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;

public class Rebate {
    @Getter String id;
    @Getter @Setter String accountNo;
    @Getter @Setter long spaQuoteNo;
    @Getter @Setter String endCustomerNo;
    @Getter @Setter String distributorInvoiceNo;
    @Getter @Setter LocalDate dateSubmitted;
    @Getter HashMap <Product, Integer> products = new HashMap<>();

    public Rebate(String id, long spaQuoteNo, String endCustomerNo, String distributorInvoiceNo, HashMap<Product, Integer> products){
        this.id = id;
        this.spaQuoteNo = spaQuoteNo;
        this.endCustomerNo = endCustomerNo;
        this.distributorInvoiceNo = distributorInvoiceNo;
        this.products.putAll(products);
    }
}
