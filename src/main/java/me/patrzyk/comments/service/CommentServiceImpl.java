package me.patrzyk.comments.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me.patrzyk.comments.dao.CommentRepository;
import me.patrzyk.comments.dao.VoteRepository;
import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.entity.CommentWithVote;
import me.patrzyk.comments.entity.Vote;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private VoteRepository voteRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<CommentWithVote> getSiteComments(String host, String path) {
        // return commentRepository.findByHostAndPathOrderByTsDesc(host, path);
        return commentRepository.findByHostAndPathWithVotes(host, path);
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

    @Transactional
    @Override
    public Vote saveVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Autowired
    public CommentServiceImpl(CommentRepository CommentRepository, VoteRepository voteRepository) {
        this.commentRepository = CommentRepository;
        this.voteRepository = voteRepository;
    }
    
}
