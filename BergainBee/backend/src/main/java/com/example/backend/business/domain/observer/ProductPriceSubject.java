package com.example.backend.business.domain.observer;
import com.example.backend.business.domain.model.BaseProduct;
import java.util.List;

public class ProductPriceSubject {
    private BaseProduct product;
    private List<UserObserver> observers;

    public void addObserver(UserObserver observer) {

    }

    public void removeObserver(UserObserver observer) {

    }

    public void notifyObservers() {

    }

    public void setObservers(List<UserObserver> observers) {
        this.observers = observers;
    }
}
