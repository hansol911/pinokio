package com.pinokio.pino.api.user;

import com.pinokio.pino.api.model.User;
import com.pinokio.pino.security.UserRole;
import lombok.Getter;
import lombok.Setter;

public class UserCommand {
    @Getter @Setter
    public static class createUser {
        private String email;
        private String password;
        private String name;
        private String addr;
        private UserRole role;

        public User toUser() {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setName(name);
            user.setAddr(addr);
            user.setRole(role);
            return user;
        }
    }

    @Getter @Setter
    public static class updateUser {
        private String password;
        private String name;
        private String addr;

        public User toUser(User user) {
            user.setPassword(password);
            user.setName(name);
            user.setAddr(addr);
            return user;
        }
    }

    @Getter @Setter
    public static class loginUser {
        private String email;
        private String password;

        public User toUser() {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            return user;
        }
    }

}
