package com.example.firebasepushpull;

public class Post {

    String ID, Post;

    public Post() {
    }

    public Post(String ID, String post) {
        this.ID = ID;
        Post = post;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }
}
