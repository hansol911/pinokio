package com.pinokio.pino.api.product;

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

    //상품 전체 조회
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> product = productService.findAllProduct();
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    //상품 Num 조회
    @GetMapping(value = "/{num}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer num) {
        Optional<Product> product = productService.findByProductNum(num);
        return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }

    //상품 CateNum 조회
    @GetMapping(value = "/categories/{cateNum}")
    public ResponseEntity<List<Product>> getProductByCateNum(@PathVariable Integer cateNum) {
        List<Product> product =productService.findByProdCateNum(cateNum);
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    //상품 추가
    @PostMapping
    public ResponseEntity<Product> save(Product product) {
        return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
    }

    //상품 num 삭제
    @DeleteMapping(value = "/{num}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer num){
        productService.deleteByProductNum(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //상품 num 수정
    @PutMapping(value = "/{num}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer num, @RequestBody Product product) {
        productService.updateByProductNum(num, product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
