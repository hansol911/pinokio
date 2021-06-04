package com.pinokio.pino.api.product;

import com.pinokio.pino.api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductCommand.CreateProduct productCommand, @RequestParam Long cateNum) {
        return productService.createProduct(productCommand, cateNum);
    }

    @GetMapping
    public List<ProductDTO> readAllProduct() {
        return productService.readAllProduct();
    }

    @GetMapping(value = "/{prodNum}")
    public ProductDTO readProduct(@PathVariable Long prodNum) {
        return productService.readProduct(prodNum);
    }

    //상품 CateNum 조회
    @GetMapping(value = "/categories/{cateNum}")
    public List<ProductDTO> getProductByCateNum(@PathVariable Long cateNum) {
        return productService.getProductByCateNum(cateNum);
    }

    @PutMapping(value = "/{prodNum}")
    public ProductDTO updateProduct(@PathVariable Long prodNum, @RequestBody ProductCommand.UpdateProduct productCommand) {
        return productService.updateByProductNum(prodNum, productCommand);
    }

    @DeleteMapping(value = "/{prodNum}")
    public String deleteProduct(@PathVariable Long prodNum) {
        return productService.deleteByProductNum(prodNum);
    }

}
