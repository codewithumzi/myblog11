package com.myblog.myblog11.controller;

import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.service.CommentService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
            //http://localhost:8080/api/comments?postId=1
public class CommentController {
    private CommentService commentService;//after implmentation we will call service layer
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId
    ){
       CommentDto dto= commentService.createComment(commentDto,postId);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    //http://localhost:8080/api/3
public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentService.deleteCommentById(id);
        return new ResponseEntity<>("comment is deleted !!!",HttpStatus.OK);
    }
    @PutMapping("/{id}/post/{postId}")
    //http://localhost:8080/api/comments/idNo  for updating only
    //http://localhost:8080/api/comments/id/2/postId/2
    public ResponseEntity<CommentDto>updateComment(
                @PathVariable long id,
               @RequestBody CommentDto commentDto,
                @PathVariable long postId){
        CommentDto dto = commentService.updateComment(id, commentDto,postId);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
}
