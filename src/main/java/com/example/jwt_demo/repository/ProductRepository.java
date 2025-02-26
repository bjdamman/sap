package com.example.jwt_demo.repository;

import com.example.jwt_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Product findByProductname(String productname);
    boolean existsByName(String name);
}