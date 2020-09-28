package com.pinokio.pino.repo;

import com.pinokio.pino.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    //Admin findByAdmin(Long num); Primary Key가 아닌 다른걸로 메서드를 만들때 사용

}
