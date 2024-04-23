package com.sealth.sealthapi.services;

import com.sealth.sealthapi.domain.user.User;
import com.sealth.sealthapi.dto.UpdateUserRequestDTO;
import com.sealth.sealthapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(String userId, UpdateUserRequestDTO request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        return userRepository.save(user);
    }
}
