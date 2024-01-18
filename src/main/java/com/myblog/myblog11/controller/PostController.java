package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    //http://localhost:8080/api/posts?id=1

    private PostService postService;
        //constructor based injection
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto dto=postService.getPostById(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/getAllPosts")

    public List<PostDto>getAllPosts(){
        List<PostDto>postDtos=postService.getAllPosts();
        return postDtos;

    }

}
