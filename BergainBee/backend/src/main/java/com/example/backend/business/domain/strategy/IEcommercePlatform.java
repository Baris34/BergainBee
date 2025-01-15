package com.example.backend.business.domain.strategy;
import com.example.backend.business.domain.model.BaseProduct;
import java.util.List;

public interface IEcommercePlatform {
    List<BaseProduct> fetchProducts(String keyword);
}
