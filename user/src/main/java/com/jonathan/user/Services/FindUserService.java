package com.jonathan.user.Services;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserService {

    private UserRepository userRepository;

    @Autowired
    public FindUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email) {
        return userRepository.findByEmail(email);
    }
}
