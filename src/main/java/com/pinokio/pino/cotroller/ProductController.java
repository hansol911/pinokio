package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.entity.Product;
import com.pinokio.pino.entity.Wood;
import com.pinokio.pino.service.AdminService;
import com.pinokio.pino.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> product = productService.findAllProduct();
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/{num}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer num) {
        Optional<Product> product = productService.findByProductNum(num);
        return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(Product product) {
        return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{num}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer num){
        productService.deleteByProductNum(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{num}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer num, @RequestBody Product product) {
        productService.updateByProductNum(num, product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
