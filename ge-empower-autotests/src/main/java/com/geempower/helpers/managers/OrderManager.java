package com.geempower.helpers.managers;

import com.geempower.helpers.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderManager {

    private Order createOrderInstance(){
        return new Order();
    }
}
