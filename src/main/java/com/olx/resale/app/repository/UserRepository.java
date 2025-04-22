package com.olx.resale.app.repository;

import com.olx.resale.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByEmailOrMobileNumber(String email, String mobile);

   Optional<User> findByEmail(String email);

   Optional<User> findByMobileNumber(String mobileNumber);
}
