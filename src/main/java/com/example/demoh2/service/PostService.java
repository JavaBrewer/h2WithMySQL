package com.example.demoh2.service;

import com.example.demoh2.domain.dto.PostRequest;
import com.example.demoh2.domain.dto.PostResponse;
import com.example.demoh2.domain.entity.PostEntity;
import com.example.demoh2.domain.entity.UserEntity;
import com.example.demoh2.repository.PostRepository;
import com.example.demoh2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponse addPost(Long userId, PostRequest postRequest) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("test"));
        PostEntity newPost = PostEntity.toEntity(postRequest, user);
        user.add(newPost);
        userRepository.save(user);
        return PostResponse.of(newPost);
    }
}
