package com.example.blogshashi.controllers;

import com.example.blogshashi.payloads.PostDto;
import com.example.blogshashi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post/")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("user/{userId}/category/{catId}")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable("userId") Integer userId, @PathVariable ("catId") Integer catId){
        PostDto post = this.postService.createPost(postDto, userId, catId);
        return  new ResponseEntity<>(post, HttpStatus.CREATED);


    }
}
