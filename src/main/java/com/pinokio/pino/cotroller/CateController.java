package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Category;
import com.pinokio.pino.service.CateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@RestController
@RequestMapping("categories")
//@RequiredArgsConstructor
public class CateController {
    private final CateService categoryService;

    public CateController(CateService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping()
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAllCategory();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }


    // 회원번호로 한명의 회원 조회
//    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public ResponseEntity<Admin> getMember(@PathVariable("id") Long num) {
//        Optional<Admin> member = adminService.findById(num);
//        return new ResponseEntity<Admin>(member.get(), HttpStatus.OK);
//    }


}



