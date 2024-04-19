package com.example.demoh2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        UserEntity newUser1 = userRepository.save(new UserEntity("kim min jae"));
        UserEntity savedUser1 = userRepository.findById(newUser1.getId()).orElseThrow();

        assertThat(newUser1.getName()).isEqualTo(savedUser1.getName());
    }

}