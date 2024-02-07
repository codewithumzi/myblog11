package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/single/{id}")
    public ResponseEntity<PostDto>getPostById(@PathVariable long id){
        PostDto dto=postService.getPostById(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/getAllPosts")
    //("/getAllPosts")only for getting all posts removed during pagination and sorting
    //http://localhost:8080/api/posts/getAllPosts?pageNo=0&pageSize=10
//http://localhost:8080/api/posts/getAllPosts?pageNo=0&pageSize=10&sortBy=title
//http://localhost:8080/api/posts/getAllPosts?pageNo=0&pageSize=10&sortBy=id&sortDir=desc

    public List<PostDto>getAllPosts(
        @RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize",required = false,defaultValue = "5")int pageSize,
        @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy,
        @RequestParam(name="sortDir",required = false,defaultValue = "asc") String sortDir
                        ){
            List<PostDto>postDtos=postService.getAllPosts( pageNo,pageSize,sortBy,sortDir);
            return postDtos;
        }
    //http://localhost:8080/api/posts/5
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);

        return new ResponseEntity<>("post id is deleted",HttpStatus.OK);
        }
    //http://localhost:8080/api/posts/postId=1
        @PutMapping("/update/{postId}")
        public ResponseEntity<PostDto> updatePost(
                @PathVariable("postId") long postId,
                @RequestBody PostDto postDto
        ){
        PostDto dto=postService.updatePost(postId,postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
