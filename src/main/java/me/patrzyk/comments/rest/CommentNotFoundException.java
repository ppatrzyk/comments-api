package me.patrzyk.comments.rest;

public class CommentNotFoundException extends RuntimeException {
    
    public CommentNotFoundException(String message) {
        super(message);
    }

    public CommentNotFoundException(Throwable cause) {
        super(cause);
    }

    public CommentNotFoundException(String message, Throwable cause) {
        super(cause);
    }
}
