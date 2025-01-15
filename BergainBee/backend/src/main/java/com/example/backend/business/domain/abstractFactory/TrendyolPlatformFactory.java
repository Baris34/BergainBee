package com.example.backend.business.domain.abstractFactory;

import com.example.backend.business.domain.model.BaseProduct;
import org.springframework.stereotype.Component;

@Component
public class TrendyolPlatformFactory extends EcommercePlatformFactory{

    @Override
    public BaseProduct createProduct(int productID, String name, double price, String url, String details, String category) {

        return new BaseProduct(productID, name, price, url, details, category);
    }


}
