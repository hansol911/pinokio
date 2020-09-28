package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.entity.Category;

import com.pinokio.pino.entity.Wood;
import com.pinokio.pino.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> category = categoryService.findAllAdmin();
        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }

    @GetMapping(value = "/{num}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer num) {
        Optional<Category> category =categoryService.findByCategoryNum(num);
        return new ResponseEntity<Category>(category.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(Category category) {
        return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{num}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer num){
        categoryService.deleteByCategoryNum(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{num}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer num, @RequestBody Category category) {
        categoryService.updateByCategoryNum(num, category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}
