package com.pinokio.pino.api.user;

import com.pinokio.pino.api.model.User;
import com.pinokio.pino.security.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String addr;
    private UserRole role;

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setAddr(user.getAddr());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
