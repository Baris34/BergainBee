package com.example.backend.business.domain.model;

public class PriceAnalyzer {

    private BaseProduct product;
    private double previousPrice;
    private boolean isDiscounted;

    public double getDiscountPercentage() {
        return 0.0;
    }

    public BaseProduct getProduct() {
        return product;
    }

    public void setProduct(BaseProduct product) {
        this.product = product;
    }

    public double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }
}
