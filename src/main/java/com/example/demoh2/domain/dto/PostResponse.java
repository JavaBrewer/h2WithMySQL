package com.example.demoh2.domain.dto;

import com.example.demoh2.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private String title;
    private String contents;

    public static PostResponse of(PostEntity post) {
        return PostResponse.builder()
                .title(post.getTitle())
                .contents(post.getContents())
                .build();
    }
}
