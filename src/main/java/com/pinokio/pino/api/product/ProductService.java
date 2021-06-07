package com.pinokio.pino.api.product;

import com.pinokio.pino.api.category.CategoryRepo;
import com.pinokio.pino.api.model.Category;
import com.pinokio.pino.api.model.Product;
import com.pinokio.pino.exception.CategoryNotFoundException;
import com.pinokio.pino.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public ProductDTO createProduct(ProductCommand.CreateProduct productCommand, Long cateNum) {
        Category category = categoryRepo.findById(cateNum).orElseThrow(() -> new CategoryNotFoundException("category not found"));
        return ProductDTO.toDTO(productRepo.save(productCommand.toProduct(category)));
    }

    public List<ProductDTO> readAllProduct() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
    }

    public ProductDTO readProduct(Long prodNum) {
        Product product = productRepo.findById(prodNum).orElseThrow(() -> new ProductNotFoundException("product not found"));
        return ProductDTO.toDTO(product);
    }

    public List<ProductDTO> getProductByCateNum(Long cateNum) {
        List<Product> products = productRepo.findByCategory_cateNum(cateNum);
        return products.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
    }

    public ProductDTO updateByProductNum(Long prodNum, ProductCommand.UpdateProduct productCommand) {
        Product product = productRepo.findById(prodNum).orElseThrow(() -> new ProductNotFoundException("product not found"));
        return ProductDTO.toDTO(productCommand.toProduct(productRepo.save(product)));

    }

    public String deleteByProductNum(Long prodNum) {
        productRepo.deleteById(prodNum);
        return "DELETE SUCCESS";
    }

}
