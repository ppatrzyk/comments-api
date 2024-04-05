package me.patrzyk.comments.dao;

import java.util.List;
import java.util.UUID;

import me.patrzyk.comments.entity.Comment;

public interface CommentDAO {
    
    List<Comment> getAll();
    Comment getbyId(UUID id);
    Comment save(Comment comment);
    void delete(UUID id);
}
