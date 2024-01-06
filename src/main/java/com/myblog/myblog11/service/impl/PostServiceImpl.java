package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
//constructor based dependency injection
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       //copies that into entity
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        //then saves
        Post savedPost = postRepository.save(post);
        //we can't return this as we have to return dto
        PostDto dto=new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }
}
