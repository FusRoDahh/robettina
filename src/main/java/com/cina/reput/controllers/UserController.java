package com.cina.reput.controllers;

import com.cina.reput.entities.User;
import com.cina.reput.exceptions.UserException;
import com.cina.reput.models.DTO.UserDTO;
import com.cina.reput.models.Response;
import com.cina.reput.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Response> postUser(@RequestBody UserDTO user) {
        try {
            UserDTO newUser = userService.create(user);
            return ResponseEntity.ok().body(
                    new Response(
                            200,
                            newUser.getUsername() +  " added correctly",
                            newUser)
            );
        } catch (UserException e) {
            return ResponseEntity.status(400).body(
                    new Response(
                            400,
                            e.getMessage()
                    )
            );
        }
    }

    @GetMapping("/list")
    public List<User> getAllReview() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getReviewById(@PathVariable Long id) {
        Optional<User> u = userService.getUserById(id);
        if(u.isPresent()){
            return ResponseEntity.ok().body(
                    new Response(200,
                            "User found: ",
                            u)
            );
        }else{
            return ResponseEntity.status(404).body(
                    new Response(
                            404,
                            "User not found, Id invalid"
                    )
            );
        }
    }
}
