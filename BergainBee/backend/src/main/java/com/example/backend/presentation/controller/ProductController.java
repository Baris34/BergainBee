package com.example.backend.presentation.controller;


import com.example.backend.business.domain.model.BaseProduct;
import com.example.backend.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public List<BaseProduct> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }

    @GetMapping("/category/{category}")
    public List<BaseProduct> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/platform/{platformName}")
    public List<BaseProduct> getProductsByPlatform(@PathVariable String platformName) {
        return productService.getProductsByPlatform(platformName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseProduct> getProductById(@PathVariable int id) {
        BaseProduct product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{productId}/favorites/add/{userId}")
    public ResponseEntity<String> addProductToFavorites(@PathVariable int productId, @PathVariable int userId) {
        try {
            productService.addProductToFavorites(userId, productId);
            return ResponseEntity.ok("Product added to favorites successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public List<BaseProduct> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/{productId}/favorites/remove/{userId}")
    public ResponseEntity<String> removeProductFromFavorites(@PathVariable int productId, @PathVariable int userId) {
        try {
            productService.removeProductFromFavorites(userId, productId);
            return ResponseEntity.ok("Product removed from favorites successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
