package me.patrzyk.comments.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me.patrzyk.comments.dao.CommentRepository;
import me.patrzyk.comments.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getSiteComments(String host, String path) {
        return commentRepository.findByHostAndPathOrderByTsDesc(host, path);
    }

    @Override
    public Comment getComment(UUID id) {
        Optional<Comment> result = commentRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException(String.format("Comment %s not found", id));
        }
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }

    @Autowired
    public CommentServiceImpl(CommentRepository CommentRepository) {
        this.commentRepository = CommentRepository;
    }
    
}
