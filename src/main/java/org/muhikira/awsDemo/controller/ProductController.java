package org.muhikira.awsDemo.controller;

import org.muhikira.awsDemo.model.Product;
import org.muhikira.awsDemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    // Constructor injection for productService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST: /product - Insert/add a product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    // GET: /product/{productId} - Get a single product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId) {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // GET: /product/products - Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    // PATCH: /product/{productId} - Update an existing product
    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable long productId, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // DELETE: /product/{productId} - Delete an existing product
    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long productId) {
        Product deletedProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    // GET: /product/by-name - Get products by name
    @GetMapping("/by-name")
    public List<Product> getProductsByName(@RequestParam(name = "productName") String productName) {
        return productService.getProductsByName(productName);
    }
}
