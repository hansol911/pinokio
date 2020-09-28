package com.pinokio.pino.service;


import com.pinokio.pino.entity.Category;
import com.pinokio.pino.repo.CateRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;

//import java.util.Optional;/
//import javax.transaction.Transactional;

@Transactional
@Service
public class CateService {
//    private static JpaRepository adminRepository;
    //    private static AdminRepo adminRepository;
    private final CateRepo cateRepository;

    public CateService(CateRepo cateRepository) {
        this.cateRepository = cateRepository;
    }

    public List<Category> findAllCategory() {
        return cateRepository.findAll();
    }

 //Admin 타입의 객체를 감쌀 수 있는 Optional(null이 될 수 있는) 타입의 변수
//    public Optional<Category> findById(Integer num) {
//        Optional<C> member = adminRepository.findById(num);
//        return member;
//    }
//
//
//    public void deleteByAdmin(Long num) {
//        adminRepository.deleteById(num);
//    }

}

