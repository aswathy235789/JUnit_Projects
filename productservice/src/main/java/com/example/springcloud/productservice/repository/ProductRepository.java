package com.example.springcloud.productservice.repository;

import com.example.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
