package com.enlink.es.models;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GeneralModel {

    /**
     * 通过反射将java对象转化为map
     *
     * @return
     * @throws IllegalAccessException
     */
    public Map<String, Object> toMap() throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for (Field declaredField : this.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            map.put(declaredField.getName(), declaredField.get(this));
        }
        return map;
    }

    /**
     * 通过反射将map转化为对象
     *
     * @param sourceAsMap
     * @return
     * @throws IllegalAccessException
     */
    public GeneralModel map2Object(Map<String, Object> sourceAsMap) throws IllegalAccessException {
        for (Field declaredField : this.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            declaredField.set(this, sourceAsMap.get(declaredField.getName()));
        }
        return this;
    }
}
