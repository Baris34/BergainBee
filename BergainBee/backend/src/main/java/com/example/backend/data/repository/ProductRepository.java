package com.example.backend.data.repository;

import com.example.backend.business.domain.model.BaseProduct;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<BaseProduct, Integer> {

    List<BaseProduct> findByCategory(String category);
    List<BaseProduct> findAll();
    List<BaseProduct> findByPlatform(String platform);
    List<BaseProduct> findByNameContaining(String name);
}
