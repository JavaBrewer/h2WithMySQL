package com.example.demoh2.domain.entity;

import com.example.demoh2.domain.dto.UserRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostEntity> postList = new ArrayList<>();

    @Builder
    public UserEntity(String name) {
        this.name = name;
    }

    public static UserEntity toEntity(UserRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .build();
    }

    public void add(PostEntity post) {
        postList.add(post);
        post.setUser(this);
    }
}
