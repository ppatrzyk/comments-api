package me.patrzyk.comments.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentRestExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<CommentErrorResponse> handleException(CommentNotFoundException exc) {
        var status = HttpStatus.NOT_FOUND;
        CommentErrorResponse error = new CommentErrorResponse(status.value(), System.currentTimeMillis(), exc.getMessage());
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler
    public ResponseEntity<CommentErrorResponse> handleException(Exception exc) {
        var status = HttpStatus.BAD_REQUEST;
        CommentErrorResponse error = new CommentErrorResponse(status.value(), System.currentTimeMillis(), exc.getMessage());
        return new ResponseEntity<>(error, status);
    }
}
