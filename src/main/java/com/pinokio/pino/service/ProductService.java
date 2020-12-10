package com.pinokio.pino.service;

import com.pinokio.pino.entity.Category;
import com.pinokio.pino.entity.Product;
import com.pinokio.pino.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public List<Product> findByProdCateNum(Integer cateNum) {
        return productRepo.findByCategory_cateNum(cateNum);
    }

    public Optional<Product> findByProductNum(Integer num) {
        Optional<Product> product = productRepo.findById(num);
        return product;
    }

   public Product save(Product product) {
        productRepo.save(product);
        return product;
   }

    public void deleteByProductNum(Integer num) {
        productRepo.deleteById(num);
    }

    public void updateByProductNum(Integer num, Product product) {
        Optional<Product> p = productRepo.findById(num);
        if (p.isPresent()) {
            p.get().setProdNum(product.getProdNum());
            p.get().setProdName(product.getProdName());
            p.get().setProdLink(product.getProdLink());
            productRepo.save(product);
        }
    }
}
