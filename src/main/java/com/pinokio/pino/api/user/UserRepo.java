package com.pinokio.pino.api.user;

import com.pinokio.pino.api.model.User;
import com.pinokio.pino.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("select u.role from User u where u.id = :userId")
    List<UserRole> getUserRoles(Long userId);
}
