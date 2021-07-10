package com.pinokio.pino.api.user;

import com.pinokio.pino.api.model.User;
import com.pinokio.pino.exception.UserAuthorityException;
import com.pinokio.pino.exception.UserIdDuplicationException;
import com.pinokio.pino.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO signUp(UserCommand.createUser userCommand) {
        User user = userCommand.toUser();
        if (userRepo.findByEmail(userCommand.getEmail()) != null)
            throw new UserIdDuplicationException("ID 중복");

        user.setPassword("{noop}" + passwordEncoder.encode(userCommand.getPassword()));
        return UserDTO.toDTO(userRepo.save(user));
    }

    public UserDTO getUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        return UserDTO.toDTO(user);
    }

    public UserDTO updateUser(UserCommand.updateUser userCommand, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        user.setPassword("{noop}" + passwordEncoder.encode(userCommand.getPassword()));
        return UserDTO.toDTO(userRepo.save(userCommand.toUser(user)));
    }


    /**
     * LOGIN
     **/

    public String login(UserCommand.loginUser loginUser) {
        User user = userRepo.findByEmail(loginUser.getEmail());
        if (user == null)
            throw new UserNotFoundException("user not found");
        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword()))
            throw new UserAuthorityException("ID/PW 확인 바람");

        return loginUser.getEmail() + "님, 환영합니다.";
    }

}
