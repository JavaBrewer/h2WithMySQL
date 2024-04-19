package com.example.demoh2.controller;

import com.example.demoh2.domain.dto.PostRequest;
import com.example.demoh2.domain.dto.PostResponse;
import com.example.demoh2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public PostResponse add(@PathVariable("userId") Long userId, @RequestBody PostRequest postRequest) {
        return postService.addPost(userId, postRequest);
    }
}
