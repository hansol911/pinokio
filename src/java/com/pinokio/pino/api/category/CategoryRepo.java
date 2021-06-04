package com.pinokio.pino.api.category;

import com.pinokio.pino.api.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findByWood_WoodNum(@Param(value = "wood_num") Long woodNum);
}

