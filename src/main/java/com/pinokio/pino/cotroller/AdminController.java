package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admins")
//@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public ResponseEntity<List<Admin>> getAllAdmin(){
        List<Admin> admin = adminService.findAllAdmin();
        return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
    }

    @GetMapping(value = "/{num}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long num){
        Optional<Admin> admin = adminService.findByAdminNum(num);
        return new ResponseEntity<Admin>(admin.get(), HttpStatus.OK);
    }

    //delete 다시하기!! ClassCastException IllegalArgumentException
    @DeleteMapping(value = "/{num}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long num){
        adminService.deleteByAdminNum(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

//    private final AdminRepo adminRepo;
//
//    public AdminController(AdminRepo adminRepo) {
//        this.adminRepo = adminRepo;
//    }
//
//    @GetMapping("/select/{id}")
//    public List<Admin> findAllAdmin(@PathVariable String id){
//        return adminRepo.findAll();
//    }

}
