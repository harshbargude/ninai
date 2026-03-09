package com.ninai.busbooking.repository;

import com.ninai.busbooking.entity.User_folder.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}