package br.com.mpbruder.blog.service;

import br.com.mpbruder.blog.model.Blog;

import java.util.HashMap;

public interface IBlogService {

    Blog newPost(Blog post);

    Blog getPost(int id);

    HashMap<Integer, Blog> getAllPosts();

}
