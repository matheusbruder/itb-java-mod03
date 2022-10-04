package br.com.mpbruder.blog.service;

import br.com.mpbruder.blog.exception.DuplicatedIdException;
import br.com.mpbruder.blog.exception.EmptyRepositoryException;
import br.com.mpbruder.blog.exception.NotFoundException;
import br.com.mpbruder.blog.model.Blog;
import br.com.mpbruder.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog newPost(Blog post) {
        Optional<Blog> optionalBlog = blogRepository.getPost(post.getId());
        if (optionalBlog.isPresent()) {
            throw new DuplicatedIdException("Id[" + post.getId() + "] já existe");
        }
        return blogRepository.newPost(post);
    }

    @Override
    public Blog getPost(int id) {
        Optional<Blog> optionalBlog = blogRepository.getPost(id);
        if (optionalBlog.isEmpty()) {
            throw new NotFoundException("Post não encontrado no repositório");
        }
        return optionalBlog.get();
    }

    @Override
    public HashMap<Integer, Blog> getAllPosts() {
        Optional<HashMap<Integer, Blog>> optionalAllPosts = blogRepository.getAllPosts();
        if (optionalAllPosts.isEmpty()) {
            throw new EmptyRepositoryException("Repositório ainda está vazio, por favor faço alguma entrada");
        }
        return optionalAllPosts.get();
    }
}
