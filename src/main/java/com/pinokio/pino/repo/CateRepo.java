package com.pinokio.pino.repo;

import com.pinokio.pino.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepo extends JpaRepository<Category, Integer> {
    //Admin findByAdminNameAndPhone(String name, String phone);

//    Admin findByAdminId(String id);

//    @Transactional // <= Service에 사용!
//    @Modifying
//    Admin deleteByAdminNo(Integer id);

}
