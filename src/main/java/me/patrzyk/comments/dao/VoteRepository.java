package me.patrzyk.comments.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import me.patrzyk.comments.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, UUID> {
    
}
