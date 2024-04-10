package me.patrzyk.comments.entity;

import java.util.Date;
import java.util.UUID;

public interface CommentWithVote {
    UUID getid();
    Date getTs();
    String getHost();
    String getPath();
    String getAuthor();
    String getContent();
    int getScore();
    int getUpvotes();
    int getDownvotes();
}
