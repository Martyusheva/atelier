package com.example.atelier.repository;

import com.example.atelier.model.Users.Tailor;
import com.example.atelier.model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TailorRepository extends JpaRepository<Tailor, Long> {
    Tailor findByUser(User user);
}
