package com.pinokio.pino.api.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryCommand categoryCommand) {
        return categoryService.createCategory(categoryCommand);
    }

    @GetMapping
    public List<CategoryDTO> readCategories(@RequestParam Long woodNum) {
        return categoryService.readCategories(woodNum);
    }

    @PutMapping(value = "/{cateNum}")
    public CategoryDTO updateCategory(@PathVariable Long cateNum, @RequestBody CategoryCommand categoryCommand) {
        return categoryService.updateCategory(cateNum, categoryCommand);
    }

    @DeleteMapping(value = "/{cateNum}")
    public String deleteCategory(@PathVariable Long cateNum) {
        return categoryService.deleteByCategoryNum(cateNum);
    }

}
