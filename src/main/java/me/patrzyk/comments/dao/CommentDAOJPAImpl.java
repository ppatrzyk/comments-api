package me.patrzyk.comments.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.patrzyk.comments.entity.Comment;

@Repository
public class CommentDAOJPAImpl implements CommentDAO {

    private EntityManager entityManager;

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = entityManager.createQuery("from Comment", Comment.class);
        List<Comment> comments = query.getResultList();
        return comments;
    }

    @Autowired
    public CommentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
}
