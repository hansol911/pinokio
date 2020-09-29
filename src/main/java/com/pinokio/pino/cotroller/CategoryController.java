package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Category;

import com.pinokio.pino.service.CategoryService;
import org.hibernate.dialect.Ingres9Dialect;
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

    //카테고리 전체 조회
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> category = categoryService.findAllAdmin();
        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }

    //카테고리 NUM 조회
    @GetMapping(value = "/{num}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer num) {
        Optional<Category> category =categoryService.findByCategoryNum(num);
        return new ResponseEntity<Category>(category.get(), HttpStatus.OK);
    }

    //카테고리 WOODNUM 조회
    @GetMapping(value = "/woods/{woodNum}")
    public ResponseEntity<List<Category>> getCategoryByWoodNum(@PathVariable Integer woodNum) {
        List<Category> category =categoryService.findByCateWoodNum(woodNum);
        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(Category category) {
        return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.OK);
    }

    //카테고리 NUM 삭제
    @DeleteMapping(value = "/{num}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer num){
        categoryService.deleteByCategoryNum(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //카테고리 NUM 수정
    @PutMapping(value = "/{num}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer num, @RequestBody Category category) {
        categoryService.updateByCategoryNum(num, category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}
