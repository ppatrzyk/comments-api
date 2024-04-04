package me.patrzyk.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.patrzyk.comments.dao.CommentDAO;
import me.patrzyk.comments.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;

    @Override
    public List<Comment> getAll() {
        return commentDAO.getAll();
    }

    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    
    
}
