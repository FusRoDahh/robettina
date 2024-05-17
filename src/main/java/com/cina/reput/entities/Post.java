package com.cina.reput.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String post;
    @ManyToOne(optional = false)
    private User user;
    @Column(nullable = false)
    private Date publication;
    @Column(nullable = false)
    private Boolean publicPost;

    public Post(Long id, String post, User user, Date publication, Boolean publicPost) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.publication = publication;
        this.publicPost = publicPost;
    }

    public Post() {
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
