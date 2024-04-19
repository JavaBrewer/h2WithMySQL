package com.example.demoh2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity add() {
        return userRepository.save(new UserEntity("john"));
    }
}
