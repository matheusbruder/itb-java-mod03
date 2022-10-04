package br.com.mpbruder.blog.controller;

import br.com.mpbruder.blog.model.Blog;
import br.com.mpbruder.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<Blog> newPost(@RequestBody Blog post) {
        return new ResponseEntity<>(blogService.newPost(post), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<HashMap<Integer, Blog>> getAllPosts() {
        return new ResponseEntity<>(blogService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getPost(@PathVariable int id) {
        return new ResponseEntity<>(blogService.getPost(id), HttpStatus.FOUND);
    }
}
