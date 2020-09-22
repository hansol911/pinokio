package com.pinokio.pino.repo;

import com.pinokio.pino.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends JpaRepository<Admin, String> {
    //Admin findByAdminNameAndPhone(String name, String phone);
}
