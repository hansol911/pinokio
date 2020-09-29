package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Admin;
import com.pinokio.pino.entity.LoginVo;
import com.pinokio.pino.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    //로그인
    @PostMapping(value = "/login")
    // @RequestBody는 Json으로 받은 요청을 MessageConverter를 통해 Java 객체로 변환
    public ResponseEntity login(@RequestBody LoginVo loginVo, HttpSession session){

        Optional<Admin> member = adminService.findByAdminId(loginVo.getAdminId());

        if(member.isPresent()){//Id찾기 null인경우
            new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        if(!loginVo.getAdminPass().equals(member.get().getAdminPass())){//pass가 다른 경우
            new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        session.setAttribute("user", member);
        System.out.println("session 담김");
        return new ResponseEntity("로그인 성공", HttpStatus.OK);
    }

    //로그아웃

    //비밀번호 찾기
    /**
     * 1. 아이디 Check
     * 2. admin name, admin_phone Check
     * 3. 비밀번호 update
     * */

}