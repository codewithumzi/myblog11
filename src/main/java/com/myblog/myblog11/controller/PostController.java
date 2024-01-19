package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.LineNumberReader;
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
    @GetMapping("/single")
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto dto=postService.getPostById(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping//("/getAllPosts")only for getting all posts removed during pagination and sorting

    public List<PostDto>getAllPosts(
        @RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize",required = false,defaultValue = "5")int pageSize
                        ){
            List<PostDto>postDtos=postService.getAllPosts( pageNo,pageSize);
            return postDtos;
        }
}
