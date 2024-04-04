package me.patrzyk.comments.dao;

import java.util.List;

import me.patrzyk.comments.entity.Comment;

public interface CommentDAO {
    List<Comment> getAll();
}
