package com.cina.reput.services;

import com.cina.reput.entities.User;
import com.cina.reput.exceptions.UserException;
import com.cina.reput.models.DTO.UserDTO;
import com.cina.reput.repositories.UserRepository;
import com.cina.reput.validators.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserValidator validator;

    public UserDTO create(UserDTO user) throws UserException {
        if (validator.isUserValid(user)) {
            User userEntity = modelMapper.map(user, User.class);
            User saved = userRepository.save(userEntity);
            modelMapper.map(saved, user);
            return user;
        } else {
            throw new UserException("User not added, a problem occurred with the data", 400);
        }
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
