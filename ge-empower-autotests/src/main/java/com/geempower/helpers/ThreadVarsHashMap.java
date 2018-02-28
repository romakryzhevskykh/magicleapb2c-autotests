package com.geempower.helpers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ThreadVarsHashMap {

    private InheritableThreadLocal<HashMap<Enum, Object>> tlHashMapList = new InheritableThreadLocal<>();

    @SuppressWarnings("unchecked")
    public void put(Enum key, Object value) {
        if (tlHashMapList.get() == null) {
            tlHashMapList.set(new HashMap<>());
        }
        if(get(key) == null){
            tlHashMapList.get().put(key, value);
        } else if (!(get(key) instanceof List)) {
            tlHashMapList.get().put(key, new ArrayList() {{
                add(value);
                add(ThreadVarsHashMap.this.get(key));
            }});
        } else {
            ((ArrayList) get(key)).add(value);
        }
    }

    @SuppressWarnings("unchecked")
    public Object get(Enum key) {
        if (tlHashMapList.get() == null) return null;
        else return tlHashMapList.get().getOrDefault(key, null);
    }

    public String getString(Enum key) {
        if (tlHashMapList.get() == null) return null;
        else return tlHashMapList.get().get(key) != null ? tlHashMapList.get().get(key).toString() : null;
    }

    public void clear() {
        if (tlHashMapList.get() != null) tlHashMapList.get().clear();
    }
}