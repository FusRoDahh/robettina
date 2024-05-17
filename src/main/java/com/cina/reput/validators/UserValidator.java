package com.cina.reput.validators;

import com.cina.reput.models.DTO.UserDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidator {

    public boolean isUserValid(UserDTO u) {
        return (isUserNotNull(u) && isEmailValid(u));
    }

    private boolean isUserNotNull(UserDTO u) {
        return (
                u.getUsername() != null &&
                u.getPassword() != null &&
                u.getEmail() != null &&
                u.getBirthDay() != null &&
                u.getFirstname() != null &&
                u.getSurname() != null
        );
    }

    private boolean isEmailValid(UserDTO u) {
        return (Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}", u.getEmail()));
    }

}
