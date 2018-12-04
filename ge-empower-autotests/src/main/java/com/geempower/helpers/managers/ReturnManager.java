package com.geempower.helpers.managers;

import com.geempower.helpers.models.Return;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReturnManager {
    private ArrayList<Return> returnList = new ArrayList<>();

    public void createReturnInstance(String id, String catalogueNo, Long invoiceNo, String reasonForRequest, String requestedAction) {
        returnList.add(new Return(id, catalogueNo, invoiceNo, reasonForRequest, requestedAction));
    }

    public Return getReturnByRequestNo(String id) {
        return returnList.stream().filter(testReturn -> testReturn.getId().equals(id)).findAny().orElse(null);
    }
}