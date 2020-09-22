package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
//@RequiredArgsConstructor
public class UserController {
    private final UserJpaRepo userJpaRepo;

    public UserController(UserJpaRepo userJpaRepo) {
        this.userJpaRepo = userJpaRepo;
    }

    @GetMapping("/select/{id}")
    public List<Admin> findAllAdmin(@PathVariable long id){
        return userJpaRepo.findAll();
    }

}
