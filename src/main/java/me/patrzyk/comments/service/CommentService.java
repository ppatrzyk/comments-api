package me.patrzyk.comments.service;

import java.util.List;
import java.util.UUID;

import me.patrzyk.comments.entity.Comment;

public interface CommentService {
    List<Comment> getAllComments();
    List<Comment> getSiteComments(String host, String path);
    Comment getComment(UUID id);
    Comment saveComment(Comment comment);
    void deleteComment(UUID id);
}
