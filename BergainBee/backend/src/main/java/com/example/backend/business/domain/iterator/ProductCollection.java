package com.example.backend.business.domain.iterator;

import com.example.backend.business.domain.model.BaseProduct;

import java.util.List;

public class ProductCollection {
    private List<BaseProduct> products;

    public ProductCollection(List<BaseProduct> products) {
        this.products = products;
    }

    public IProductIterator createIterator() {
        return new ConcreteProductIterator(products);
    }
}
