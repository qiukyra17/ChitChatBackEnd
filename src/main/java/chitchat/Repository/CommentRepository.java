package chitchat.Repository;

import chitchat.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Integer>{

    @Query("FROM Comment WHERE post_Id= :postId")
    List<Comment> getCommentsByPostId(@Param("postId") int postId);
}
