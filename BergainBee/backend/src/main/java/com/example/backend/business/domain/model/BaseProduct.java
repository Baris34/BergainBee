package com.example.backend.business.domain.model;


import com.example.backend.business.domain.flyweight.ProductFlyweight;
import jakarta.persistence.*;

@Entity
@Table(name="Products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseProduct  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    private String name;
    private double price;
    private String details;
    private String URL;
    private String category;
    private String platform;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public BaseProduct(int productID, String name, double price, String url, String details, String category) {
        this.productID = productID;
        this.name = name;
        this.price=price;
        this.details = details;
        this.URL = url;
        this.category = category;
    }

    public BaseProduct() {

    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public String getURL() {
        return URL;
    }

    public String getCategory() {
        return category;
    }
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
