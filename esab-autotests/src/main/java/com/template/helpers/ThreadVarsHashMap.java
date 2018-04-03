package com.template.helpers;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ThreadVarsHashMap {

    private InheritableThreadLocal<HashMap<String, Object>> tlHashMapList = new InheritableThreadLocal<>();

    public void put(String key, Object value) {
        if (tlHashMapList.get() == null) tlHashMapList.set(new HashMap<>());
        tlHashMapList.get().put(key, value);
    }

    public Object get(String key) {
        if (tlHashMapList.get() == null) return null;
        else return tlHashMapList.get().getOrDefault(key, null);
    }

    public String getString(String key) {
        if (tlHashMapList.get() == null) return null;
        else return tlHashMapList.get().get(key) != null ? tlHashMapList.get().get(key).toString() : null;
    }

    public void clear() {
        if (tlHashMapList.get() != null) tlHashMapList.get().clear();
    }
}