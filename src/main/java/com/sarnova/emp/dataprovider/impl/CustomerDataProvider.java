package com.sarnova.emp.dataprovider.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sarnova.emp.dataprovider.DataProvider;
import com.sarnova.emp.entity.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDataProvider implements DataProvider<CustomerDto> {

    private ThreadLocal<List<CustomerDto>> container = new ThreadLocal<>();

    @Override
    public CustomerDto getItem() {
        return Iterables.getOnlyElement(container.get());
    }

    @Override
    public void setItem(CustomerDto customerData) {
        container.set(Lists.newArrayList(customerData));
    }

    @Override
    public List<CustomerDto> getItems() {
        return container.get();
    }

    @Override
    public void setItems(List<CustomerDto> customerData) {
        container.set(customerData);
    }
}
