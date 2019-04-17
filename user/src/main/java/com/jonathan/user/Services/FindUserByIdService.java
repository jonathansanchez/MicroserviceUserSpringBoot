package com.jonathan.user.Services;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService {

    private UserRepository userRepository;

    @Autowired
    public FindUserByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Integer id) {
        return userRepository.findById(id);
    }
}
