package com.example.atelier.repository;

import com.example.atelier.model.Users.Administrator;
import com.example.atelier.model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUser(User user);
}
