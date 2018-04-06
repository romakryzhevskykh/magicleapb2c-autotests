package com.geempower.helpers.managers;

import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Return;

import java.util.ArrayList;

public class ReturnManager {
    private ArrayList<Return> returnList = new ArrayList<>();

    public void createReturnInstance(String id, Product product, long invoiceNo, String reasonForRequest, double requestedCredit){
        returnList.add(new Return(id, product, invoiceNo, reasonForRequest, requestedCredit));
    }
}
