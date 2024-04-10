package me.patrzyk.comments.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import me.patrzyk.comments.entity.Comment;
import me.patrzyk.comments.entity.CommentWithVote;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByHostAndPathOrderByTsDesc(String host, String path);
    
    @Query(value = """
        select
            id,
            ts,
            host,
            path,
            author,
            content,
            coalesce(score, 0) as score,
            coalesce(upvotes, 0) as upvotes,
            coalesce(downvotes, 0) as downvotes
        from comments
        left join (
            select 
                comment_id,
                sum(score) as score,
                count(*) filter (where score > 0) as upvotes,
                count(*) filter (where score < 0) as downvotes
            from votes
            group by comment_id
        ) as vote_summary
        on comments.id = vote_summary.comment_id
        where host = :host and path = :path
        order by ts desc;
            """, nativeQuery = true)
    List<CommentWithVote> findByHostAndPathWithVotes(@Param("host") String host, @Param("path") String path);
}
