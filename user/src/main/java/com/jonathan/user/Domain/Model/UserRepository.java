package com.jonathan.user.Domain.Model;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    void save(User user);
    User findById(Integer id);
    User findByEmail(String email);
    void deleteById(Integer id);
}
