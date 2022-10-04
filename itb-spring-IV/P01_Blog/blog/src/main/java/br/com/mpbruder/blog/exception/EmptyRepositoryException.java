package br.com.mpbruder.blog.exception;

public class EmptyRepositoryException extends RuntimeException{
    public EmptyRepositoryException(String message) {
        super(message);
    }
}
