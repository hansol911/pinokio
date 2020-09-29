package com.pinokio.pino.service;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.entity.Category;
import com.pinokio.pino.entity.Wood;
import com.pinokio.pino.repo.AdminRepo;
import com.pinokio.pino.repo.CategoryRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> findAllAdmin(){
        return categoryRepo.findAll();
    }

    public Optional<Category> findByCategoryNum(Integer num) {
        Optional<Category> category = categoryRepo.findById(num);
        return category;
    }

    public List<Category> findByWoodNum(Integer woodNum){
        return categoryRepo.findByWood_woodNum(woodNum);
    }

    public Category save(Category category) {
        categoryRepo.save(category);
        return category;
    }

    public void deleteByCategoryNum(Integer num) {
        categoryRepo.deleteById(num);
    }

    public void updateByCategoryNum(Integer num, Category category) {
        Optional<Category> c = categoryRepo.findById(num);
        if (c.isPresent()) {
            c.get().setCateNum(category.getCateNum());
            c.get().setCateName(category.getCateName());
            categoryRepo.save(category);
        }
    }

}
