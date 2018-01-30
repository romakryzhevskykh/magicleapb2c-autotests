package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.supply_lists.SupplyList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SupplyListsManager {
    private ArrayList<SupplyList> allSupplyLists;
    private ArrayList<SupplyList> testSupplyLists;

    public ArrayList<SupplyList> getTestSupplyLists() {
        return testSupplyLists;
    }

    public ArrayList<SupplyList> getAllSupplyLists() {
        return allSupplyLists;
    }
}
