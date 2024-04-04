package me.patrzyk.comments.service;

import java.util.List;

import me.patrzyk.comments.entity.Comment;

public interface CommentService {
    List<Comment> getAll();
}
