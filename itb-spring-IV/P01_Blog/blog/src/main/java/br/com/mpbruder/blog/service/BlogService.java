package br.com.mpbruder.blog.service;

import br.com.mpbruder.blog.model.Blog;
import br.com.mpbruder.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog newPost(Blog post) {
        return null;
    }

    @Override
    public Blog getPost(int id) {
        return null;
    }

    @Override
    public List<Blog> getAllPosts() {
        return null;
    }
}
