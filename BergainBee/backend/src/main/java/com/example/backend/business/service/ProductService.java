package com.example.backend.business.service;

import com.example.backend.business.domain.abstractFactory.PlatformFactoryManager;
import com.example.backend.business.domain.model.BaseProduct;
import com.example.backend.business.domain.abstractFactory.EcommercePlatformFactory;
import com.example.backend.business.domain.model.User;
import com.example.backend.data.repository.ProductRepository;
import com.example.backend.data.repository.UserRepository;
import com.example.backend.presentation.util.StrategyContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final StrategyContext strategyContext;

    @Autowired
    private PlatformFactoryManager platformFactoryManager;

    public ProductService(ProductRepository productRepository, StrategyContext strategyContext) {
        this.productRepository = productRepository;
        this.strategyContext = strategyContext;
    }

    public List<BaseProduct> getProductsByPlatform(String platformName) {
        try {
            EcommercePlatformFactory factory = platformFactoryManager.getFactory(platformName);
            List<BaseProduct> products = new ArrayList<>();

            if (factory != null) {
                for (int i = 1; i <= 5; i++) {
                    BaseProduct product = factory.createProduct(i, platformName + " Product " + i, 10.0 * i, "url" + i, "details" + i, "category" + i);
                    products.add(product);
                }
                productRepository.saveAll(products);
                return products;
            } else {
                System.err.println("PlatformFactoryManager returned null for platform: " + platformName);
                return Collections.emptyList();
            }

        } catch (Exception e) {
            System.err.println("Error in getProductsFromPlatform: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<BaseProduct> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    public List<BaseProduct> searchProducts(String keyword) {
        List<BaseProduct> products = new ArrayList<>();
        products.addAll(productRepository.findByNameContaining(keyword));
        products.addAll(productRepository.findByCategory(keyword));
        products.addAll(productRepository.findByPlatform(keyword));

        return products.stream().distinct().collect(Collectors.toList());
    }

    public BaseProduct getProductById(int id) {
        Optional<BaseProduct> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public void addProductToFavorites(int userId, int productId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        BaseProduct product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        user.getFavorites().add(product);
        userRepository.save(user);
    }

    public void removeProductFromFavorites(int userId, int productId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        BaseProduct product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        user.getFavorites().remove(product);
        userRepository.save(user);
    }

    public List<BaseProduct> getAllProducts() {
        return productRepository.findAll();
    }

}
