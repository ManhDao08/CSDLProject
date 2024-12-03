package com.example.Spring.Example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.Example.Models.Product;
import com.example.Spring.Example.Models.ResponseObject;
import com.example.Spring.Example.Repositories.ProductRepo;

@RestController
@RequestMapping("/api/v1/Products")
public class ProductController {
    // Dependency injection
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/getAllProducts")
    // this request: http://localhost:8080/api/v1/Products/getAllProducts
    List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @GetMapping("/{productCode}")
    ResponseEntity<ResponseObject> findByID(@PathVariable Long productCode) {
        Optional<Product> foundProduct = productRepo.findById(productCode);
        if (foundProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, "Get Successfully", foundProduct)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "Get Unsuccessfully", "")
            );
        }
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        List<Product> foundProducts = productRepo.findByProductName(newProduct.getProductName().trim());
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject(false, "ProductName duplicated", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "Insert successfully", productRepo.save(newProduct))
        );
    } 

    // Update, upsert
    @PutMapping("/{productCode}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long productCode) {
        Product updateProduct = productRepo.findById(productCode).map(
            product -> {
                product.setBuyPrice(newProduct.getBuyPrice());
                product.setMSRP(newProduct.getMSRP());
                product.setProductDescription(newProduct.getProductDescription());
                product.setProductLine(newProduct.getProductLine());
                product.setProductName(newProduct.getProductName());
                product.setProductVendor(newProduct.getProductVendor());
                product.setQuantityInStock(newProduct.getQuantityInStock());
                product.setUrl(newProduct.getUrl());
                return productRepo.save(product);
            }
        ).orElseGet(() -> {
            return productRepo.save(newProduct);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(true, "Update Succesfully", updateProduct)
        );
    }

    @DeleteMapping("/{productCode}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long productCode) {
        Optional<Product> foundProduct = productRepo.findById(productCode);
        if (foundProduct.isPresent()) {
            productRepo.delete(foundProduct.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, "Delete Succesfully", foundProduct.get())
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(false, "Can not find the product with given productCode", "")
            );
        }
    }
}
