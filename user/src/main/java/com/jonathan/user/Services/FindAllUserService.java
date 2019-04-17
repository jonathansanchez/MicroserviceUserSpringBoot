package com.jonathan.user.Services;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUserService {

    private UserRepository userRepository;

    @Autowired
    public FindAllUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }
}
