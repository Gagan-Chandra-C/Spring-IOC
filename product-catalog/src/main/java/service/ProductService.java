package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

private final ProductRepository productRepository;

public ProductService(ProductRepository productRepository) {
this.productRepository = productRepository;
}

public void saveProduct(Product product) {
productRepository.save(product);
}

public List<Product> getAllProducts() {
return productRepository.findAll();
}

public List<Product> getProductsByCategory(String category) {
return productRepository.findByCategory(category);
}
}
