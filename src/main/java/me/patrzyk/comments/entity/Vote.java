package me.patrzyk.comments.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="votes")
public class Vote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="ts")
    private Date ts;

    @NotNull(message="Empty score")
    @Column(name="score")
    private int score;

    @NotNull(message="Empty comment_id")
    @Column(name="comment_id")
    private UUID commentId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

    public Vote() {
    }

    public Vote(UUID id, Date ts, @NotNull(message = "Empty score") int score,
            @NotNull(message = "Empty comment_id") UUID commentId) {
        this.id = id;
        this.ts = ts;
        this.score = score;
        this.commentId = commentId;
    }
    
}
