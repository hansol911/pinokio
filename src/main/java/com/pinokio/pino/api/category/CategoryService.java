package com.pinokio.pino.api.category;

import com.pinokio.pino.api.model.Category;
import com.pinokio.pino.api.model.Wood;
import com.pinokio.pino.api.wood.WoodRepo;
import com.pinokio.pino.exception.CategoryNotFoundException;
import com.pinokio.pino.exception.WoodNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final WoodRepo woodRepo;

    public CategoryService(CategoryRepo categoryRepo, WoodRepo woodRepo) {
        this.categoryRepo = categoryRepo;
        this.woodRepo = woodRepo;
    }

    public CategoryDTO createCategory(CategoryCommand categoryCommand) {
        Wood wood = woodRepo.findById(categoryCommand.getWoodNum()).orElseThrow(() -> new WoodNotFoundException("wood not found"));
        return CategoryDTO.toDTO(categoryRepo.save(categoryCommand.toCategory(wood)), categoryCommand.getWoodNum());
    }

    public List<CategoryDTO> readCategories(Long woodNum) {
        List<Category> categories = categoryRepo.findByWood_WoodNum(woodNum);
        return categories.stream().map(category -> CategoryDTO.toDTO(category, woodNum)).collect(Collectors.toList());
    }

    public CategoryDTO updateCategory(Long cateNum, CategoryCommand categoryCommand) {
        Category category = categoryRepo.findById(cateNum).orElseThrow(() -> new CategoryNotFoundException("category not found"));
        Wood wood = woodRepo.findById(category.getWood().getWoodNum()).orElseThrow(() -> new WoodNotFoundException("wood not found"));
        return CategoryDTO.toDTO(categoryRepo.save(categoryCommand.toCategory(wood)), wood.getWoodNum());
    }

    public String deleteByCategoryNum(Long num) {
        categoryRepo.deleteById(num);
        return "DELETE SUCCESS";
    }

}
