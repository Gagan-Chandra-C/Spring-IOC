
package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

private final ProductService productService;

public ProductController(ProductService productService) {
this.productService = productService;
}

@GetMapping
public String homePage() {
return "index";
}

@GetMapping("/add-product")
public String showAddProductForm(Model model) {
model.addAttribute("product", new Product());
return "add-product";
}

@PostMapping("/add-product")
public String addProduct(@ModelAttribute Product product) {
productService.saveProduct(product);
return "redirect:/";
}

@GetMapping("/display-products")
public String displayProducts(Model model) {
List<Product> products = productService.getAllProducts();
model.addAttribute("products", products);
return "display-products";
}
}
