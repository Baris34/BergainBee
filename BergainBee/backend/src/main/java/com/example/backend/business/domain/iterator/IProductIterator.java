package com.example.backend.business.domain.iterator;
import com.example.backend.business.domain.model.BaseProduct;

public interface IProductIterator {
    boolean hasNext();
    BaseProduct next();
}
