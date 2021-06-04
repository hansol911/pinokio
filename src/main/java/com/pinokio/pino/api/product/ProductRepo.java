package com.pinokio.pino.api.product;

import com.pinokio.pino.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategory_cateNum(Long cateNum);
}
