package com.pinokio.pino.api.user;

public class LoginVo {
    private String adminId;
    private String adminPass;

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
}
