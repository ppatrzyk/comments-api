package me.patrzyk.comments.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class CommentRestController {

    private CommentService commentService;

    // TODO trail/lead slash

    @GetMapping("comments")
    public List<Comment> getComments() {
        
        return commentService.getAll();
    }
    
    @GetMapping("comments/{commentId}")
    public Comment getCommentById(@PathVariable UUID commentId) {
        try {
            Comment comment = commentService.getbyId(commentId);
            return comment;
        } catch (Exception e) {
            throw new CommentNotFoundException(e);
        }
    }

    @PostMapping("comments")
    public Comment saveComment(@Valid @RequestBody Comment comment) {
        comment.setId(null);
        comment.setTs(new Date());
        Comment newComment = commentService.save(comment);
        return newComment;
    }
    
    // TODO remove this later? test only
    @PutMapping("comments/{commentId}")
    public Comment updateComment(@PathVariable UUID commentId, @Valid @RequestBody Comment comment) {
        try {
            commentService.getbyId(commentId);
        } catch (Exception e) {
            throw new CommentNotFoundException(e);
        }
        comment.setId(commentId);
        comment.setTs(new Date());
        Comment newComment = commentService.save(comment);
        return newComment;
    }

    @DeleteMapping("comments/{commentId}")
    public String deleteComment(@PathVariable UUID commentId) {
        commentService.delete(commentId);
        return "OK";
    }

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

}
