package com.example.demoh2.service;

import com.example.demoh2.domain.entity.UserEntity;
import com.example.demoh2.domain.dto.UserRequest;
import com.example.demoh2.domain.dto.UserResponse;
import com.example.demoh2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse addUser(UserRequest request) {
        UserEntity newUser = userRepository.save(UserEntity.toEntity(request));
        return UserResponse.of(newUser);
    }
}