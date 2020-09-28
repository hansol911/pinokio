package com.pinokio.pino.service;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.repo.AdminRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AdminService {
    private final AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> findAllAdmin(){
        return adminRepo.findAll();
    }

    public Optional<Admin> findByAdminNum(Long num){
        Optional<Admin> admin = adminRepo.findById(num);
        return admin;
    }

    public void deleteByAdminNum(Long num) {
        adminRepo.deleteById(num);
    }

}
