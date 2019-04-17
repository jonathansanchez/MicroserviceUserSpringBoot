package com.jonathan.user.Services;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserService {
    private UserRepository userRepository;

    @Autowired
    public AddUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getLastName(),
                userRequest.getEmail(),
                userRequest.getPassword()
        );

        userRepository.save(user);

        return user;
    }
}
