package com.jonathan.user.Infrastructure.Persistence.JPA;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Domain.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaUserRepository implements UserRepository {
    @Autowired
    IJpaUserRepository jpaRepository;

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void save(User user) {
        jpaRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return jpaRepository.findById(id).get();
    }

    @Override
    public User findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }
}
