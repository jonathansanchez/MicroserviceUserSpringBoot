package com.jonathan.user.Services;

import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveUserService {

    private UserRepository userRepository;

    @Autowired
    public RemoveUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Integer id) {
        userRepository.deleteById(id);
    }
}
