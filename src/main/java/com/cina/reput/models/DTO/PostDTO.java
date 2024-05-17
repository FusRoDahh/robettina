package com.cina.reput.models.DTO;

import com.cina.reput.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostDTO {
    private Long id;
    private String post;
    private Long user_id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date publication;
    private Boolean publicPost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public Boolean getPublicPost() {
        return publicPost;
    }

    public void setPublicPost(Boolean publicPost) {
        this.publicPost = publicPost;
    }
}
