package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public ResponseEntity<List<Admin>> findAll() {
        List<Admin> member = adminService.findAllAdmin();
        return new ResponseEntity<List<Admin>>(member, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Admin> getMember(@PathVariable("id") Long num) {
        Optional<Admin> member = adminService.findById(num);
        return new ResponseEntity<Admin>(member.get(), HttpStatus.OK);
    }

    //회원 아이디로 아이디 조회
    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Admin> getMemberId(@PathVariable("id") String id) {
        Optional<Admin> member = adminService.findByAdminId(id);
        return new ResponseEntity<Admin>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long num) {
        adminService.deleteByAdmin(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원 로그인

    // 회원 추가
    @PostMapping()
    public ResponseEntity<Admin> save(@RequestBody Admin member){
        return new ResponseEntity<Admin>(adminService.save(member), HttpStatus.OK);
    }

    //회원 수정
    @PutMapping(value = "/{num}")
    public ResponseEntity<Admin> updateMember(@PathVariable Long num, @RequestBody Admin member) {
        adminService.updateById(num, member);
    return new ResponseEntity<Admin>(member, HttpStatus.OK);
    }
}