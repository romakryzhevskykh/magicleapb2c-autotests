package com.geempower.helpers.managers;

import com.geempower.helpers.models.Order;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class OrderManager {

    ArrayList<Order> ordersList = new ArrayList<>();

    public void createOrderInstance(double finalOrderPrice, long orderId){
        ordersList.add(new Order(orderId, finalOrderPrice));
    }

    public Order getOrderById(long orderId) {
        return ordersList.stream().filter(order -> order.getOrderId().equals(orderId)).findAny().orElse(null);
    }

}
