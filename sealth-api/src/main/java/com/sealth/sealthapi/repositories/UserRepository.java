package com.sealth.sealthapi.repositories;

import com.sealth.sealthapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, String> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(String id);

    @Query("SELECT u.id FROM User u")
    List<String> findAllUserIds();
}
