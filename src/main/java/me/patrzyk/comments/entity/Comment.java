package me.patrzyk.comments.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="ts")
    private Date ts;

    @Column(name="host")
    private String host;

    @Column(name="path")
    private String path;

    @Column(name="author")
    private String author;

    @Column(name="content")
    private String content;

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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment() {
        
    }

    public Comment(UUID id, Date ts, String host, String path, String author, String content) {
        this.id = id;
        this.ts = ts;
        this.host = host;
        this.path = path;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", ts=" + ts + ", host=" + host + ", path=" + path + ", author=" + author
                + ", content=" + content + "]";
    }
    
}
