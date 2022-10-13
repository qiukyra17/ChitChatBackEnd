package chitchat.Service;

import chitchat.Model.Comment;
import chitchat.Model.Post;
import chitchat.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentService {
    CommentRepository commentRepository;
    PostService postService;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository =
                commentRepository;
        this.postService = postService;
    }

    //ALL COMMENTS
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    //GET COMMENT BY POSTID
    public List<Comment> getCommentsByPostId(int postId) {
        return commentRepository.getCommentsByPostId(postId);
    }

    //ADD COMMENT
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // ADD COMMENT WITHE POSTID
    public Comment addCommentWithPostId(int postId, Comment comment) {
        Post post = postService.getPostById(postId);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

}
