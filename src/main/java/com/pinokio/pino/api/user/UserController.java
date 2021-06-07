package com.pinokio.pino.api.user;

import com.pinokio.pino.security.SecurityUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO signUp(@RequestBody UserCommand.createUser userCommand) {
        return userService.signUp(userCommand);
    }

    @GetMapping("/me")
    public UserDTO getUser(@AuthenticationPrincipal SecurityUser securityUser) {
        return userService.getUser(securityUser.getUserId());
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserCommand.updateUser userCommand, @AuthenticationPrincipal SecurityUser securityUser) {
        return userService.updateUser(userCommand, securityUser.getUserId());
    }

    @PostMapping("/login")
    public String login(@RequestBody UserCommand.loginUser loginUser) {
        return userService.login(loginUser);
    }
}
