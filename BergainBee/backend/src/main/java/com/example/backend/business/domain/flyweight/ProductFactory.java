package com.example.backend.business.domain.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static final Map<String, ProductFlyweight> flyweights = new HashMap<>();

    public static ProductFlyweight getFlyweight(String brand, String category) {
        String key = brand + ":" + category;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ProductFlyweight(brand, category));
        }
        return flyweights.get(key);
    }
}
