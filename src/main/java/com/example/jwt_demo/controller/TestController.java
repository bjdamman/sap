package com.example.jwt_demo.controller;

import com.example.jwt_demo.model.Product;
import com.example.jwt_demo.model.User;
import com.example.jwt_demo.repository.ProductRepository;
import com.example.jwt_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class TestController {
    //testtest
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/product")
    public List<Product>  allAccessJson() {

        return productRepository.findAll();
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product>  allAccessJsonId(@PathVariable Long id) {

        //return productRepository.findById(id)
        //        .orElseGet();

        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());

        //return productRepository.findAll();
    }

    @PostMapping("/product")
    public String allAccessJsonPost(@RequestBody Product product) {

        if (productRepository.existsByName(product.getName())) {
            return "Error: name is already taken!";
        }

        Product newProduct = new Product(
                null,
                product.getName(),
                product.getCategory()
        );
        productRepository.save(newProduct);
        return "Product added successfully!";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }
}