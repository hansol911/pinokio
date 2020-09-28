package com.pinokio.pino.entity;

import lombok.*;

import javax.persistence.*;

//@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminNum;
    private String adminId;
    private String adminPass;
    private String adminName;
    private String phone;

//    @Builder
//    public Admin(String adminId, String adminPass, String adminName, String phone) {
//        this.adminId = adminId;
//        this.adminPass = adminPass;
//        this.adminName = adminName;
//        this.phone = phone;
//    }

    public Long getAdminNum() {
        return adminNum;
    }
    public void setAdminNum(Long num) {
        this.adminNum = num;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String id) {
        this.adminId = id;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String pass) {
        this.adminPass = pass;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String name) {
        this.adminName = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
