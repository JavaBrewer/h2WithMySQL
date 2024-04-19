package com.example.demoh2.domain.dto;

import com.example.demoh2.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;

    public static UserResponse of(UserEntity user) {
        return UserResponse.builder()
                .name(user.getName())
                .build();
    }
}
