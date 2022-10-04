package br.com.mpbruder.blog.repository;

import br.com.mpbruder.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BlogRepository {

    private HashMap<Integer, Blog> hashMap = new HashMap<Integer, Blog>();



}
