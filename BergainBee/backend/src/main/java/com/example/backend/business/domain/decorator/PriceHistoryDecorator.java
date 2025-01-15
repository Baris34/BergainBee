package com.example.backend.business.domain.decorator;

import java.util.ArrayList;
import java.util.List;

public class PriceHistoryDecorator implements IProduct {

    private IProduct decoratedProduct;
    private List<Double> priceHistory;

    public PriceHistoryDecorator(IProduct decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
        this.priceHistory = new ArrayList<>();
    }

    public void addPriceToHistory(double price) {
        priceHistory.add(price);
    }

    public List<Double> getPriceHistory() {
        return priceHistory;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDetails() {
        return "";
    }
}
