package com.microservice.post.post.controller;

import com.microservice.post.post.entity.Post;
import com.microservice.post.post.repository.PostRepository;
import com.microservice.post.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

        //http://localhost:8081/api/v1/posts/savePost
    @PostMapping("/savePost")
   public ResponseEntity<Post> savePost( @RequestBody Post post){
        Post newPost = postService.savePost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);



   }

   @GetMapping("/{postId}")
   public Post getPostByPostId(@PathVariable String postId){
       Post post =  postService.findPostById(postId);
       return post;
   }
}
