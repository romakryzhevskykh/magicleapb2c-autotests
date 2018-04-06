package com.geempower.helpers.managers;

import com.geempower.helpers.models.Order;
import com.geempower.helpers.models.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class OrderManager {

    private ArrayList<Order> ordersList = new ArrayList<>();

    public void createOrderInstance(long orderId, HashMap<Product, Integer> products){
        ordersList.add(new Order(orderId, products));
    }

    public Order getOrderById(long orderId) {
        return ordersList.stream().filter(order -> order.getOrderId() == orderId).findAny().orElse(null);
    }

}
