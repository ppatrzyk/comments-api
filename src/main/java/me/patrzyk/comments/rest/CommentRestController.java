package me.patrzyk.comments.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.service.CommentService;


@RestController
@RequestMapping("/api")
public class CommentRestController {

    private CommentService commentService;

    // TODO trail/lead slash

    @GetMapping("comments")
    public List<Comment> getComments() {
        
        return commentService.getAllComments();
    }
    
    @GetMapping("comments/{commentId}")
    public Comment getCommentById(@PathVariable UUID commentId) {
        try {
            Comment comment = commentService.getComment(commentId);
            return comment;
        } catch (Exception e) {
            throw new CommentNotFoundException(e);
        }
    }

    @GetMapping("comments/{host}/{path}")
    public List<Comment> getSiteComments(@PathVariable String host, @PathVariable String path) {
        return commentService.getSiteComments(host, path);
    }

    @PostMapping("comments")
    public Comment saveComment(@Valid @RequestBody Comment comment) {
        comment.setId(null);
        comment.setTs(new Date());
        Comment newComment = commentService.saveComment(comment);
        return newComment;
    }

    @DeleteMapping("comments/{commentId}")
    public String deleteComment(@PathVariable UUID commentId) {
        commentService.deleteComment(commentId);
        return "OK";
    }

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

}
