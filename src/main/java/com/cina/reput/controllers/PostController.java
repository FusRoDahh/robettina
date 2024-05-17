package com.cina.reput.controllers;

import com.cina.reput.entities.Post;
import com.cina.reput.exceptions.PostException;
import com.cina.reput.models.DTO.PostDTO;
import com.cina.reput.models.Response;
import com.cina.reput.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/")
    public ResponseEntity<Response> postUser(@RequestBody PostDTO post) {
        try {
            PostDTO newPost = postService.create(post);
            return ResponseEntity.ok().body(
                    new Response(
                            200,
                            "Post: " + newPost.getId() + "added by: " + newPost.getUser_id() + " added correctly",
                            newPost)
            );
        } catch (PostException e) {
            return ResponseEntity.status(400).body(
                    new Response(
                            400,
                            e.getMessage()
                    )
            );
        }
    }

    @GetMapping("/list")
    public List<Post> getAllReview() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getReviewById(@PathVariable Long id) {
        Optional<Post> p = postService.getPostById(id);
        if(p.isPresent()){
            return ResponseEntity.ok().body(
                    new Response(200,
                            "Post found: ",
                           p)
            );
        }else{
            return ResponseEntity.status(404).body(
                    new Response(
                            404,
                            "Post not found, Id invalid"
                    )
            );
        }
    }

    @GetMapping("/user/{id}")
    public List<Post> getPostByUser(@PathVariable Long id) {
        return postService.getAllPostByUser(id);
    }
}
