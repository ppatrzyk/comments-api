package me.patrzyk.comments.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import me.patrzyk.comments.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByHostAndPathOrderByTsDesc(String host, String path);
}
