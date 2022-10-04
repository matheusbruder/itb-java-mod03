package br.com.mpbruder.blog.repository;

import br.com.mpbruder.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class BlogRepository {

    private final HashMap<Integer, Blog> blogHashMap = new HashMap<>();

    public Blog newPost(Blog post) {
        blogHashMap.put(post.getId(), post);
        return blogHashMap.get(post.getId());
    }

    public Optional<HashMap<Integer, Blog>> getAllPosts() {
        if (blogHashMap.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(blogHashMap);
    }

    public Optional<Blog> getPost(int id) {
        if (!blogHashMap.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(blogHashMap.get(id));
    }

}
