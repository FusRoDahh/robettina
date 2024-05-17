package com.cina.reput.validators;

import com.cina.reput.models.DTO.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class PostValidator {

    public boolean isPostValid(PostDTO p) {
        return (isUserNotNull(p) && isDescriptionValid(p));
    }

    private boolean isUserNotNull(PostDTO p) {
        return (
                p.getPost() != null &&
                p.getUser_id() != null &&
                p.getUser_id() > 0 &&
                p.getPublication() != null &&
                p.getPublicPost() != null
        );
    }

    private boolean isDescriptionValid(PostDTO p) {
        return p.getPost().length() > 1;
    }
}
