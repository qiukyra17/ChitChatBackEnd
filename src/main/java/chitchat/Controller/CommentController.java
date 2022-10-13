package chitchat.Controller;

import chitchat.Model.Comment;
import chitchat.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("comments")
public class CommentController {
    CommentService commentService;

    @Autowired
    public CommentController (CommentService commentService){this.commentService = commentService;}

    //GET ALL COMMENTS
    @GetMapping
    public List<Comment> getAllComments() {return commentService.getAllComments();}

    //GET COMMENTS BY POSTID
    @GetMapping ("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable("postId") int postId) {return commentService.getCommentsByPostId(postId);}

    //POST - ADD NEW COMMENT
    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {return commentService.addComment(comment);}

    //POST - ADD NEW COMMENT WITH POSTID
    @PostMapping ("/post/{postId}")
    public Comment addCommentWithPostId(@PathVariable int postId, @RequestBody Comment comment){
        return commentService.addCommentWithPostId(postId,comment);
    }
}
