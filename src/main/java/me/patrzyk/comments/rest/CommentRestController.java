package me.patrzyk.comments.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.entity.CommentWithVote;
import me.patrzyk.comments.entity.Vote;
import me.patrzyk.comments.service.CommentService;



@RestController
@RequestMapping("/api")
public class CommentRestController {

    private CommentService commentService;

    // TODO trail/lead slash?

    // Comments

    @CrossOrigin
    @GetMapping("comments")
    public List<CommentWithVote> getSiteComments(@RequestParam String host, @RequestParam String path) {
        return commentService.getSiteComments(host, path);
    }

    @CrossOrigin
    @PostMapping("comments")
    public Comment saveComment(@Valid @RequestBody Comment comment) {
        comment.setId(null);
        comment.setTs(new Date());
        Comment newComment = commentService.saveComment(comment);
        return newComment;
    }

    @CrossOrigin
    @DeleteMapping("comments")
    public String deleteComment(@RequestParam UUID commentId) {
        commentService.deleteComment(commentId);
        return "OK";
    }

    // Votes

    @CrossOrigin
    @PostMapping("votes")
    public Vote saveVote(@RequestBody Vote vote) {
        vote.setId(null);
        vote.setTs(new Date());
        Vote newVote = commentService.saveVote(vote);
        return newVote;
    }
    
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

}
