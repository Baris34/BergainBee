package com.example.backend.business.domain.strategy;
import java.util.List;
import com.example.backend.business.domain.model.BaseProduct;
import java.util.ArrayList;

public class TrendyolPlatform implements IEcommercePlatform{

    @Override
    public List<BaseProduct> fetchProducts(String keyword) {
        System.out.println("Fetching products from Trendyol with keyword: " + keyword);
        return new ArrayList<>();
    }
}
