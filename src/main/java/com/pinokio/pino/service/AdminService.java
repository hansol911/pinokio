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

    private final AdminRepo adminRepository;

    public AdminService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }

    //관리자 전체 조회
    public List<Admin> findAllAdmin() {
        return adminRepository.findAll();
    }

    //Admin 타입의 객체를 감쌀 수 있는 Optional(null이 될 수 있는) 타입의 변수
    //특정 관리자 조회
    public Optional<Admin> findById(Long num) {
        Optional<Admin> member = adminRepository.findById(num);
        return member;
    }

    //아이디로 관리자 조회
    public Optional<Admin> findByAdminId(String adminId) {
        Optional<Admin> member = adminRepository.findByAdminId(adminId);
        return member;
    }

    //관리자 추가
    public Admin save(Admin member) {
        adminRepository.save(member);
        return member;
    }

    //관리자 수정
    public void updateById(Long num, Admin member) {
        Optional<Admin> e = adminRepository.findById(num);

        if (e.isPresent()) {
            e.get().setAdminNum(member.getAdminNum());
            e.get().setAdminId(member.getAdminId());
            e.get().setAdminPass(member.getAdminPass());
            e.get().setAdminName(member.getAdminName());
            e.get().setPhone(member.getPhone());
            adminRepository.save(member);
        }
    }

    //관리자 삭제
    public void deleteByAdmin(Long num) {
        adminRepository.deleteById(num);
    }

}

