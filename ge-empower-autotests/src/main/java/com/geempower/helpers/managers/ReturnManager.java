package com.geempower.helpers.managers;

import com.geempower.helpers.models.Return;

import java.util.ArrayList;

public class ReturnManager {
    private ArrayList<Return> returnList = new ArrayList<>();

    public void createReturnInstance(String id, String catalogueNo, long invoiceNo, String reasonForRequest, double requestedCredit){
        returnList.add(new Return(id, catalogueNo, invoiceNo, reasonForRequest, requestedCredit));
    }
}
