package com.pinokio.pino.repo;

import com.pinokio.pino.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    //Admin findByAdminNameAndPhone(String name, String phone);

    //아이디 조회
    Optional<Admin> findByAdminId(String adminId);

}
