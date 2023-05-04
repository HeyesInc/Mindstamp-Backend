package com.heyesinc.api.mindstamp.controllers;

import com.heyesinc.api.mindstamp.dtos.Post;
import com.heyesinc.api.mindstamp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getUserById(@PathVariable("id") int postId){
        return ResponseEntity.ok().body(postService.getPostById(postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer postId){
        return ResponseEntity.ok().body(postService.deletePostById(postId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> editUserById(@PathVariable("id") Integer postId, @RequestBody Post post){
        return ResponseEntity.ok().body(postService.editPostById(postId, post));
    }
}
