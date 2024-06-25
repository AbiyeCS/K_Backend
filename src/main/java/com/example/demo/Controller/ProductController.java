package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/product",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> newOrder(@RequestBody Product newProduct) {
        Product savedProduct = productRepository.save(newProduct);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/products")
    public List<Product> getAllOrders() {
        return productService.getAllProducts();
    }
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable int id) {
        return productService.findProductById(id);
    }
    @PutMapping("/product/{id}")
    Product updateOrder(@PathVariable int id, @RequestBody Product newProduct) {
        return productService.updateProduct(id, newProduct);
    }
    @DeleteMapping("/product/{id}")
    String deleteOrderById(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
