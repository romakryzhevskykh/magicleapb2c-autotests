package com.sarnova.emp.dataprovider;

import java.util.List;

public interface DataProvider<T> {

    T getItem();

    void setItem(T data);

    List<T> getItems();

    void setItems(List<T> data);
}
