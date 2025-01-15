package com.example.backend.business.domain.iterator;

import com.example.backend.business.domain.model.BaseProduct;

import java.util.List;
import java.util.NoSuchElementException;

public class ConcreteProductIterator implements IProductIterator {
    private List<BaseProduct> products;
    private int position = 0;

    public ConcreteProductIterator(List<BaseProduct> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public BaseProduct next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return products.get(position++);
    }
}