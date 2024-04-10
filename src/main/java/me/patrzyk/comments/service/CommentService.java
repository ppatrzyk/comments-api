package me.patrzyk.comments.service;

import java.util.List;
import java.util.UUID;

import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.entity.CommentWithVote;
import me.patrzyk.comments.entity.Vote;

public interface CommentService {
    List<Comment> getAllComments();
    List<CommentWithVote> getSiteComments(String host, String path);
    Comment saveComment(Comment comment);
    void deleteComment(UUID id);
    Vote saveVote(Vote vote);
}
