package chitchat.Controller;

import chitchat.Model.Post;
import chitchat.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("posts")
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService){ this.postService = postService;}

    //GET ALL POSTS
    @GetMapping()
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    //GET POST BY POSTID
    @GetMapping("{postId}")
    public Post getPostById(@PathVariable int postId){
        return postService.getPostById(postId);
    }

    //POST - ADD NEW POST
    @PostMapping
    public Post addPost(@RequestBody Post post) { return postService.addPost(post);}
}
