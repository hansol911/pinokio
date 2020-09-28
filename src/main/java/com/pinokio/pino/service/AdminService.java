package com.pinokio.pino.service;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.entity.Wood;
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

    public void updateByAdminNum(Long num, Admin admin) {
        Optional<Admin> a= adminRepo.findById(num);
        if (a.isPresent()) {
            a.get().setAdminNum(admin.getAdminNum());
            a.get().setAdminId(admin.getAdminId());
            a.get().setAdminPass(admin.getAdminPass());
            a.get().setAdminName(admin.getAdminName());
            a.get().setPhone(admin.getPhone());
            adminRepo.save(admin);
        }
    }

}
