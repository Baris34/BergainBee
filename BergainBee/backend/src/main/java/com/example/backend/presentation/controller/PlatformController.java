package com.example.backend.presentation.controller;

import com.example.backend.business.domain.model.BaseProduct;
import com.example.backend.business.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    private final ProductService productService;

    public PlatformController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{platformName}/products")
    public ResponseEntity<List<BaseProduct>> getProductsByPlatform(@PathVariable String platformName) {
        List<BaseProduct> products = productService.getProductsByPlatform(platformName);
        return ResponseEntity.ok(products);
    }
}