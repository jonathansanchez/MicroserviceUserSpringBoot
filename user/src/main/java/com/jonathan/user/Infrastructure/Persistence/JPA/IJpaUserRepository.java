package com.jonathan.user.Infrastructure.Persistence.JPA;

import com.jonathan.user.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IJpaUserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email=:email")
    User findByEmail(String email);
}
