package com.geempower.helpers.managers;

import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Rebate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class RebateManager {

    private ArrayList<Rebate> rebatesList = new ArrayList<>();

    public void createRebateInstance(String id, long spaQuoteNo, String endCustomerNo, String distributorInvoiceNo, HashMap<Product, Integer> products){
        rebatesList.add(new Rebate(id, spaQuoteNo, endCustomerNo, distributorInvoiceNo, products));
    }

    public void createRebateInstance(String id, long spaQuoteNo, String catalogNo){
        rebatesList.add(new Rebate(id, spaQuoteNo, catalogNo));
    }

    public Rebate getRebateById(String rebateId) {
        return rebatesList.stream().filter(rebate -> rebate.getId().equals(rebateId)).findAny().orElse(null);
    }

    public Rebate getRebateBySpaQuoteNo(long spaNo){
        return rebatesList.stream().filter(rebate -> rebate.getSpaQuoteNo() == spaNo).findAny().orElse(null);
    }
}
