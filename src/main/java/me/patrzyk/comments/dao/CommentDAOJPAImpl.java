package me.patrzyk.comments.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.patrzyk.comments.entity.Comment;

@Repository
public class CommentDAOJPAImpl implements CommentDAO {

    private EntityManager entityManager;

    @Autowired
    public CommentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = entityManager.createQuery("from Comment", Comment.class);
        List<Comment> comments = query.getResultList();
        return comments;
    }

    // TODO get by host/path combination

    @Override
    public Comment getbyId(UUID id) {
        Comment comment = entityManager.find(Comment.class, id);
        if (comment == null) {
            throw new RuntimeException(String.format("Comment %s not found", id));
        } else {
            return comment;
        }
    }

    @Override
    public Comment save(Comment comment) {
        Comment newComment = entityManager.merge(comment);
        return newComment;
    }

    // TODO rethink deletion in case reply-to comments possible

    @Override
    public void delete(UUID id) {
        Comment comment = this.getbyId(id);
        entityManager.remove(comment);
    }
    
    
}
