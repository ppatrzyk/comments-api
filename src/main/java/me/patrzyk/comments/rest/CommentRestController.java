package me.patrzyk.comments.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    private CommentService commentService;

    @GetMapping("comments")
    public List<Comment> getComments() {
        
        return commentService.getAll();
    }
    
    @GetMapping("comments/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {
        // TODO better query by id
        List<Comment> comments = commentService.getAll();

        try {
            return comments.get(commentId);
        } catch (Exception e) {
            throw new CommentNotFoundException(e);
        }
    }

    // TODO remaining methods

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

}
