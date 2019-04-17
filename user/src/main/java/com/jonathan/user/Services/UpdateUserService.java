package com.jonathan.user.Services;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateUserService {
    private UserRepository userRepository;

    @Autowired
    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public User execute(User user, Map<String, String> dataToUpdate) {
        user.setEmail(dataToUpdate.get("email"));
        user.setName(dataToUpdate.get("name"));
        user.setLastName(dataToUpdate.get("lastName"));
        user.setPassword(dataToUpdate.get("password"));

        userRepository.save(user);

        return user;
    }*/

    public User execute(User user, UserRequest userRequest) {
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);

        return user;
    }
}
