package com.pinokio.pino.repo;

import com.pinokio.pino.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List findByCategory_cateNum(@Param(value = "cate_num") Integer cateNum);
}
