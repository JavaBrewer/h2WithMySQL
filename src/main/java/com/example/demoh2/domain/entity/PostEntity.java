package com.example.demoh2.domain.entity;

import com.example.demoh2.domain.dto.PostRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long id;

    private String title;
    private String contents;

    @Builder
    public PostEntity(String title, String contents, UserEntity user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
    }

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public static PostEntity toEntity(PostRequest request, UserEntity user) {
        return PostEntity.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .user(user)
                .build();
    }
}
