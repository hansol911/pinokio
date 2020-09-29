package com.pinokio.pino.repo;

import com.pinokio.pino.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List findByWood_woodNum(@Param(value = "wood_num") Integer woodNum);
}

