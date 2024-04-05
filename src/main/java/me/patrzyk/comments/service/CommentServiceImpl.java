package me.patrzyk.comments.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me.patrzyk.comments.dao.CommentDAO;
import me.patrzyk.comments.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;

    @Override
    public List<Comment> getAll() {
        return commentDAO.getAll();
    }

    @Override
    public Comment getbyId(UUID id) {
        return commentDAO.getbyId(id);
    }

    @Transactional
    @Override
    public Comment save(Comment comment) {
        return commentDAO.save(comment);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        commentDAO.delete(id);
    }

    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
    
}
