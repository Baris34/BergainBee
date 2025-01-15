package com.example.backend.business.domain.abstractFactory;

import com.example.backend.business.domain.model.BaseProduct;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EcommercePlatformFactory {
  public abstract BaseProduct createProduct(int productID, String name, double price, String url, String details, String category);

}
