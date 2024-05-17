package com.cina.reput.services;

import com.cina.reput.entities.Post;
import com.cina.reput.entities.User;
import com.cina.reput.exceptions.PostException;
import com.cina.reput.exceptions.UserException;
import com.cina.reput.models.DTO.PostDTO;
import com.cina.reput.models.DTO.UserDTO;
import com.cina.reput.repositories.PostRepository;
import com.cina.reput.repositories.UserRepository;
import com.cina.reput.validators.PostValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostValidator validator;

    public PostDTO create(PostDTO post) throws PostException {
        if (validator.isPostValid(post)) {
            Post entity = modelMapper.map(post, Post.class);
            Optional<User> student = userRepository.findById(post.getUser_id());
            entity.setUser(student.get());
            Post saved = postRepository.save(entity);
            modelMapper.map(saved, post);
            return post;
        } else {
            throw new PostException("Post not added, a problem occurred with the data", 400);
        }
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAllPostByUser(Long id) {
        List<Post> finalList = new ArrayList<>();
        List<Post> list = postRepository.findAll();
        for(Post p : list) {
            if (p.getUser().getId() == id) {
                finalList.add(p);
            }
        }
        return finalList;
    }
}
